package assignment8;

public class Device {
	public void startup() {
		System.out.println("Device started");
	};//print to console that device is starting
	public void shutdown() {
		System.out.println("Device shutting down due to maintenance");
		System.exit(0);;
	};//print to console that device is shutting down and exit
	
}
