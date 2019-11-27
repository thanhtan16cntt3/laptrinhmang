package bai2_chuong4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server {

	public final static int SERVER_PORT = 1234; // Cổng mặc định của Echo Server
	public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận

	
	public static void main(String[] args) {
		DatagramSocket datagramSocket = null;
		
		try {
			datagramSocket = new DatagramSocket(SERVER_PORT);
			System.out.println("Server stated");
			System.out.println("Waitting for messages from client .... ");
			String string  = "";
			
			while(true) {
				DatagramPacket dpReceive = new DatagramPacket(BUFFER, BUFFER.length);
				datagramSocket.receive(dpReceive);
				string = new String(dpReceive.getData(), 0, dpReceive.getLength());
				
				String[] arr = string.split(" ");
				int numberOne = Integer.parseInt(arr[0]);
				int numberTwo = Integer.parseInt(arr[2]);
				String result = "";
				switch (arr[1]) {
				case "+":
					result = string + " = " + (numberOne + numberTwo);
					break;
				case "*":
					result = string + " = " + (numberOne * numberTwo);
					break;
				case "/":
					int a = numberOne / numberTwo;
					int b = numberOne % numberTwo;
					result = string + " = " + a + "," + b;
					break;
				case "-":
					result = string + " = " + (numberOne - numberTwo);
					break;
				default:
					break;
				}
				
				byte[] data = result.getBytes();
				DatagramPacket dpSend = new DatagramPacket(data, data.length, dpReceive.getAddress(), dpReceive.getPort());
	            datagramSocket.send(dpSend);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if(datagramSocket != null) {
				datagramSocket.close();
			}
		}

	}

}
