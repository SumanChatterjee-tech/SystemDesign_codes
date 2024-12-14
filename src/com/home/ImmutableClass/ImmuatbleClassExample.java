package com.home.ImmutableClass;

import java.util.HashMap;
import java.util.Map;

final class A{
	private int age;
	private String name;
	private Map<String, String> metadata;

	public A(int age, String name, Map<String, String> metadata) {
		super();
		this.age = age;
		this.name = name;
		Map<String, String > copy = new HashMap<String, String>();
		for(Map.Entry<String, String> m : metadata.entrySet()) {
			copy.put(m.getKey(), m.getValue());
		}
		this.metadata = copy;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public Map<String, String> getMetadata() {
		
		Map<String, String > copy = new HashMap<String, String>();
		for(Map.Entry<String, String> m : this.metadata.entrySet()) {
			copy.put(m.getKey(), m.getValue());
		}
		return copy;
	}
	@Override
	public String toString() {
		return "A [age=" + age + ", name=" + name + ", metadata=" + metadata + "]";
	}
}
public class ImmuatbleClassExample {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("30", "Suman");
		A a = new A(30,"Suman", m);
		System.out.println(a.toString());
		//Map<String, String> modified = a.getMetadata();
		m = a.getMetadata();
		m.put("30", "Suman1"); // we need deep copy for this
		System.out.println(a.toString());

	}

}
