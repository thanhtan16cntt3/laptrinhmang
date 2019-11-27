package bai2_chuong4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Client {

	public final static int SERVER_PORT = 1234;
	public final static String IP_SERVER = "127.0.0.1";
	public final static byte[] BUFFER = new byte[4096];

	public static void main(String[] args) {
		DatagramSocket datagramSocket = null;
		try {
			datagramSocket = new DatagramSocket();
			System.out.println("Client started ......");

			InetAddress server = InetAddress.getByName(IP_SERVER);
			while (true) {
				System.out.println("Ví dụ: 12 / 31 (cách toán tử bởi 1 dấu khoảng trắng)");
				System.out.print("Enter: ");
				// nhập một chuoi từ bàn phím
				InputStreamReader inputStreamReader = new InputStreamReader(System.in);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String string = bufferedReader.readLine();

				// đổi chuổi sang mảng bytes
				byte[] data = string.getBytes();

				// tạo gói tin gửi
				DatagramPacket dpSend = new DatagramPacket(data, data.length, server, SERVER_PORT);
				// send gói tin sang cho server
				datagramSocket.send(dpSend);

				// gói tin nhận
				DatagramPacket dpReceive = new DatagramPacket(BUFFER, BUFFER.length);
				// chờ nhận dữ liệu từ server gửi về
				datagramSocket.receive(dpReceive);

				// đổi dữ liệu nhận được dạng mảng bytes ra chuổi rồi in ra màn hình
				System.out.println("Received: " + new String(dpReceive.getData(), 0, dpReceive.getLength()));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (datagramSocket != null) {
				datagramSocket.close();
			}
		}

	}

}
