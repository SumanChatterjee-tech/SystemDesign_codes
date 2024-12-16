package com.home.FactoryDesignPatterns;

interface Computer{
	public void cpu();
	public void hdd();
}

class Lenovo implements Computer{
	
	private String cpuType;
	private String hddType;

	public Lenovo(String cpuType, String hddType) {
		super();
		this.cpuType = cpuType;
		this.hddType = hddType;
	}
	@Override
	public void cpu() {
		System.out.println(this.cpuType);
		
	}
	@Override
	public void hdd() {
		System.out.println(this.hddType);
		
	}
}

class Asus implements Computer{

	private String cpuType;
	private String hddType;

	public Asus(String cpuType, String hddType) {
		super();
		this.cpuType = cpuType;
		this.hddType = hddType;
	}
	@Override
	public void cpu() {
		System.out.println(this.cpuType);
		
	}
	@Override
	public void hdd() {
		System.out.println(this.hddType);
		
	}
}

class ComputerFactory{

	public ComputerFactory() {
		super();
	}
	
	public Computer getComputer(String computerName, String cpuType, String hddType) {
		switch(computerName) {
			case "Asus":
				return new Asus(cpuType, hddType);
			case "Lenovo":
				return new Lenovo(cpuType, hddType);
			default:
				return null;
		}
	}
}
public class FactoryDesignPatternMain {

	public static void main(String[] args) {
		ComputerFactory c = new ComputerFactory();
		Computer compA = c.getComputer("Asus", "XYZ", "ABC");
		compA.hdd();
		Computer compL = c.getComputer("Lenovo", "DLF", "QWERTY");
		compL.hdd();

	}

}
