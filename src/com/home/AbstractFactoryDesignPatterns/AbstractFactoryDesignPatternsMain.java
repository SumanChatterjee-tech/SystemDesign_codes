package com.home.AbstractFactoryDesignPatterns;


interface Computer{
	public void cpu();
	public void hdd();
}
interface AbstractfactoryLayer{
	public Computer getComputer();
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


class LenovoFactory implements AbstractfactoryLayer{
	private String cpuType;
	private String hddType;
	public LenovoFactory(String cpuType, String hddType) {
		super();
		this.cpuType = cpuType;
		this.hddType = hddType;
	}

	@Override
	public Computer getComputer() {
		return new Asus(this.cpuType, this.hddType);
	}
}

class AsusFactory implements AbstractfactoryLayer{
	private String cpuType;
	private String hddType;
	public AsusFactory(String cpuType, String hddType) {
		super();
		this.cpuType = cpuType;
		this.hddType = hddType;
	}

	@Override
	public Computer getComputer() {
		return new Asus(this.cpuType, this.hddType);
	}
}

class ComputerFactory{

	public ComputerFactory() {
		super();
	}
	
	public static Computer getComputer(AbstractfactoryLayer abs) {
		return abs.getComputer();
	}
}
public class AbstractFactoryDesignPatternsMain {

	public static void main(String[] args) {
//	 Same thing but with JAVA 8 functional interface	
//		AbstractfactoryLayer abs = ()->{
//			return new Asus("AS", "wsd");
//			
//		};
//		Computer asus = ComputerFactory.getComputer(abs);
//		asus.cpu();
		Computer asus = ComputerFactory.getComputer(new AsusFactory("ABC", "XYZ"));
		asus.cpu();
	}

}
