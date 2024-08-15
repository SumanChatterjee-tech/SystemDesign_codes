package com.home.Interpretor_DesignPattern;

import java.util.*;

public class Context {

	static Map<Character, Integer> map = new HashMap<>();
	
	public void put(Character c, int val) {
		map.put(c, val);
	}
	
	public int get(Character c) {
		return map.get(c);
	}
}
