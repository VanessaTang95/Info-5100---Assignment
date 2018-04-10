package assignment8;

public class Controller extends Thread {
	private Device device;
	private Sensor heat,pressure;
	
	public Controller(Device device, Sensor heat, Sensor pressure) {
		this.device=device;
		this.heat=heat;
		this.pressure=pressure;
	}
	
	public void run() {
		device.startup();
		synchronized(device) {
		while(true) {
			try {
				device.wait();
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			if(heat.getValue()>70 || pressure.getValue()>100) {
				device.shutdown();
				break;
			}
			System.out.println("Heat -> "+heat.getValue()+" , pressure -> "+pressure.getValue());
			
		}
		}
	}
		
}
