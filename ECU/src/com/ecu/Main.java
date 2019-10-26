package com.ecu;

public class Main {
	public static void main(String[] args) throws Exception {
		ecu = null;
		try {
			// ECU st = new ECU("COM5");
			//st = new ECU("COM5");
			st = new ECU("COM8");
			ecu = new ECU("70.12.230.119", 8888);
//			ecu.start();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
