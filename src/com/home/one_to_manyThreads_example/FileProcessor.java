package com.home.one_to_manyThreads_example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class FileProcessor {

	private static final int NUM_OF_WORKER_THREADs = 4;
	private static BlockingQueue<String> bq = new LinkedBlockingQueue<>();
	
	static class FileReadingThread implements Runnable{

		String fileName;
		
		public FileReadingThread(String fileName) {
			super();
			this.fileName = fileName;
		}

		@Override
		public void run() {
			try(BufferedReader bf = new BufferedReader(new FileReader(this.fileName))){
				String line;
				while((line = bf.readLine())!=null) {
					try {
						bq.put(line);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//once the reading is done(for one line) signal the other threads
				for(int i=0;i<NUM_OF_WORKER_THREADs;i++) {
					try {
						bq.put("EOF");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static class FileProcessesingThread implements Runnable{
		String fileName;
		
		public FileProcessesingThread(String fileName) {
			super();
			this.fileName = fileName;
		}
		@Override
		public void run() {
			while(true) {
				try {
					String line = bq.take();
					if(line.equalsIgnoreCase("EOF")) {
						break;
					}
					System.out.println("processing: "+ line);
					Thread.sleep(1000); //simulate the time delay to process
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		String fileName = "E:\\Suman\\File_To_Be_Read_From_Code.txt";
		FileReadingThread fr = new FileReadingThread(fileName);
		Thread t1 = new Thread(fr);
		t1.start(); //reading part is done
		
		for(int i=0;i<NUM_OF_WORKER_THREADs;i++) {
			Thread t2 = new Thread( new FileProcessesingThread(fileName));
			t2.start(); //writing part is done with given number of threads
		}

	}
}
