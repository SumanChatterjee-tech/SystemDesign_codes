package com.home.ConsistantHashingTechnique;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class ConsistentHashing {
	private final TreeMap<Long, String> ring = new TreeMap<>();
	private final int numerOfReplicas;

	public ConsistentHashing(int numerOfReplicas) {
		this.numerOfReplicas = numerOfReplicas;
	}

	public void addNode(String nodeIdentifier) {
		for (int i = 0; i < numerOfReplicas; i++) {
			String nameToHash = nodeIdentifier + "#" + i;
			long hash = getHash(nameToHash);
			ring.put(hash, nameToHash);
		}
	}

	public void removeNode(String nodeIdentifier) {
		for (int i = 0; i < numerOfReplicas; i++) {
			String nameToHash = nodeIdentifier + "#" + i;
			long hash = getHash(nameToHash);
			ring.remove(hash);
		}
	}
	
	public String getNode(String key) {
		if (ring.isEmpty()) {
            return null;
        }
		
		long hash = getHash(key);
		Map.Entry<Long , String> details = ring.ceilingEntry(hash);
		if (details == null) {
			details = ring.firstEntry();
        }
        return details.getValue();
	}

	public long getHash(String name) {
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(name.getBytes());
            long hash = 0;
            for (int i = 0; i < 8; i++) {
                hash = (hash << 8) | (digest[i] & 0xFF);
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsistentHashing ch  = new ConsistentHashing(4);
		ch.addNode("Node1");
        ch.addNode("Node2");
        ch.addNode("Node3");
        //ch.addNode("Node4");
        
        String[] keys = {"user1", "user2", "user3", "user4"};
        for (String key : keys) {
            System.out.println("Key '" + key + "' is assigned to " + ch.getNode(key));
        }
        
        System.out.println("\nRemoving Node2...");
        ch.removeNode("Node2");

        for (String key : keys) {
            System.out.println("Key '" + key + "' is now assigned to " + ch.getNode(key));
        }

	}

}
