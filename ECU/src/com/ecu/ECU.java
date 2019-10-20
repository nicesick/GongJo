package com.ecu;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ECU implements SerialPortEventListener {
	Socket socket;
	boolean rflag = true;
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private BufferedInputStream bin;
	private InputStream in;
	private OutputStream out;
	static String str;
	static ECU st;
	static ECU ecu;
	String checkData;
	
	static String speed;
	static String distance;
	static String fuel;
	static String battery;
	static String co2;
	static String dust;
	static String sdust;
	static String temperature;
	static String humidity;
	

	public ECU() {

	}
	
	public ECU(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		// 포트가 정상이면 CONNECT
		System.out.println("Connect Com Port!");
		
		try {
			connectSerial();
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start(); //
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}
	}
	
	public ECU(String ip, int port) throws IOException {
		new ServerThread(port).start();
	}

	
	class ServerThread extends Thread {
		private int port;
		
		public ServerThread(int port) {
			this.port = port;
		}
		
		@Override
		public void run() {
			boolean flag = true;
			ServerSocket serverSocket = null;
			
			try {
				serverSocket = new ServerSocket(port);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while (flag) {
				try {
					System.out.println("server is ready...");
					socket = serverSocket.accept();
					System.out.println("Socket : " + socket.getInetAddress());
					new Receiver(socket).start();
					
				} catch (Exception e) {
					e.printStackTrace();
					
					try {
						serverSocket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
	

//	public void sendMsg(String msg) throws IOException {
//		Sender sender = null;
//		sender = new Sender(socket);
//		sender.setMsg(msg);
//		sender.start();
//	}

//	public void start() throws Exception {
//		Scanner sc = new Scanner(System.in);
//		boolean sflag = true;
//		while (sflag) {
//			System.out.println("input msg");
//			String str = sc.next();
//			sendMsg(str);
//			if (str.equals("q")) {
//				rflag = false;
//				break;
//			}
//		}
//		System.out.println("Bye....");
//		sc.close();
//	}

//	class Sender extends Thread {
//		OutputStream out;
//		DataOutputStream dout;
//		String msg;
//
//		public Sender(Socket socket) throws IOException {
//			out = socket.getOutputStream();
//			dout = new DataOutputStream(out);
//		}
//
//		public void setMsg(String msg) {
//			this.msg = msg;
//		}
//
//		public void run() {
//			if (dout != null) {
//				try {
//					dout.writeUTF(msg);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

	class Receiver extends Thread {
		Socket socket;
		InputStream in;
		DataInputStream din;

		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			din = new DataInputStream(in);
		}

		public void run() {
			System.out.println("Receiver is Ready...");
			
			try {
				while (rflag) {
					str = din.readUTF();
					System.out.println(str);
					// 시뮬레이터 조작
					// 속도 연료 거리 베터리
					
					System.out.println(str.substring(0,8));
					
					if (str.substring(0,8).equals("00010010")) {
						speed = str.substring(8,24);
						st.sendData("W28"+str);
					}
					
					else if(str.substring(0,8).equals("00010015")) {
						distance = str.substring(8,24);
						st.sendData("W28"+str);
					}
					
					else if(str.substring(0,8).equals("00010050")) {
						fuel = str.substring(8,24);
						st.sendData("W28"+str);
					}
					
					else if(str.substring(0,8).equals("00010055")) {
						battery = str.substring(8,24);
						st.sendData("W28"+str);
					}
					else if(str.substring(0,8).equals("00020020")) {
						co2 = str.substring(8,24);
						st.sendData("W28"+str);
					}
					else if(str.substring(0,8).equals("00020030")) {
						dust = str.substring(8,24);
						st.sendData("W28"+str);
					}
					else if(str.substring(0,8).equals("00020035")) {
						sdust = str.substring(8,24);
						st.sendData("W28"+str);
					}
					else if(str.substring(0,8).equals("00020040")) {
						temperature = str.substring(8,24);
						st.sendData("W28"+str);
					}
					else if(str.substring(0,8).equals("00020045")) {
						humidity = str.substring(8,24);
						st.sendData("W28"+str);
					}
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean checkSerialData(String data) {
		boolean check = false;
		// :U2800000050000000000000002046
		checkData = data.substring(1, 28);
		String checkSum = data.substring(28, 30);

		char c[] = checkData.toCharArray();
		int cdata = 0;
		for (char cc : c) {
			cdata += cc;
		}
		cdata = (cdata & 0xFF);
		String serialCheckSum = Integer.toHexString(cdata).toUpperCase();
		if (serialCheckSum.trim().equals(checkSum)) {
			check = true;
		}
		return check;
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128];

			try {

				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer);
				}

				String ss = new String(readBuffer);
				boolean result = checkSerialData(ss);
				System.out.println("Result:" + result);
				System.out.println("Receive Low Data:" + ss + "||");
				
				if(checkData.equals("U28000000000000000000000001")){
					System.out.println("enginestart");
//					ecu.sendMsg("EngineStart");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	public void sendData(String data) {
		SerialWriter sw = new SerialWriter(data);
		new Thread(sw).start();
	}

	public void connectSerial() throws Exception {

		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use"); // 그래도문제가 있으면 하지마라, 다른 사람이 쓰고 있다.
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 5000);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort; // COMMPORT
				serialPort.addEventListener(this); //
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // 통신속도
						SerialPort.DATABITS_8, // 데이터 비트
						SerialPort.STOPBITS_1, // stop 비트
						SerialPort.PARITY_NONE); // 패리티 우리가 전송하는건 검증 하겠다 .
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				out = serialPort.getOutputStream();
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	private class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			this.data = ":G11A9\r"; // 나도 같이 참가 하겠습니다 .
		}

		public SerialWriter(String serialData) {
			// W28 00000000 000000000000
			// :W28 00000000 000000000000 53 \r : \r 시작과 끝 53 체크섬
			String sdata = sendDataFormat(serialData);
			System.out.println(sdata);
			this.data = sdata;
		}

		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}
			cdata = (cdata & 0xFF);

			String returnData = ":";
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {

				byte[] inputData = data.getBytes();
				out.write(inputData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
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
