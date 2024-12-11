package com.home.one_to_manyThreads_example;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class RoundRobinFileProcessor {

    static class LineProcessor implements Runnable {
        private final BlockingQueue<String> taskQueue;
        private final int threadId;

        public LineProcessor(BlockingQueue<String> taskQueue, int threadId) {
            this.taskQueue = taskQueue;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String line = taskQueue.take(); // Take a line from the queue
                    if (line.equals("END")) break; // Exit signal
                    System.out.println("Thread " + threadId + " processing: " + line);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "E:\\Suman\\File_To_Be_Read_From_Code.txt"; // Update the file path
        int numWorkerThreads = 3; // Number of worker threads
        List<BlockingQueue<String>> taskQueues = new ArrayList<>();

        // Create queues for each worker thread
        for (int i = 0; i < numWorkerThreads; i++) {
            taskQueues.add(new LinkedBlockingQueue<>());
        }

        // Create worker threads
        List<Thread> workerThreads = new ArrayList<>();
        for (int i = 0; i < numWorkerThreads; i++) {
            Thread worker = new Thread(new LineProcessor(taskQueues.get(i), i + 1));
            workerThreads.add(worker);
            worker.start();
        }

        // File reader thread
        Thread fileReaderThread = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int turn = 0; // Round-robin turn
                while ((line = br.readLine()) != null) {
                    taskQueues.get(turn).put(line); // Assign line to the current queue
                    turn = (turn + 1) % numWorkerThreads; // Move to the next thread in round-robin
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Send "END" signals to all worker threads
                for (BlockingQueue<String> queue : taskQueues) {
                    try {
                        queue.put("END");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        // Start the file reader thread
        fileReaderThread.start();

        // Wait for the file reader thread to finish
        try {
            fileReaderThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Wait for all worker threads to finish
        for (Thread worker : workerThreads) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All lines processed.");
    }
}
