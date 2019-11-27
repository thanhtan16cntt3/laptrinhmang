package bai1_chuong4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_Server {

	public final static int SERVER_PORT = 1234; // Cổng mặc định của Echo Server
	public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận

	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = null;
		try {
			datagramSocket = new DatagramSocket(SERVER_PORT);
			System.out.println("Server stated");
			System.out.println("Waitting for messages from client .... ");
			String inline = "";
	        int tram,chuc,donvi;
			while(true) {
				//taọ gói tin nhận
				DatagramPacket dpReceive = new DatagramPacket(BUFFER, BUFFER.length);
				//chờ nhận gói tin gửi đến
				datagramSocket.receive(dpReceive);
				
				//lấy dữ liệu khỏi gói tin nhận
				inline = new String(dpReceive.getData(), 0, dpReceive.getLength());

				int i=Integer.parseInt(inline);
				inline = "";
		           tram = i/100;
		           chuc = (i-(tram*100))/10;
		           donvi = (i-((tram*100)+(chuc*10))); 
		            switch(tram)
		            {
		                case 1:inline="Một trăm";break;
		                case 2:inline="Hai trăm";break;
		                case 3:inline="Ba trăm";break;
		                case 4:inline="Bốn trăm";break;
		                case 5:inline="Năm trăm";break;
		                case 6:inline="Sáu trăm";break;
		                case 7:inline="Bảy trăm";break;
		                case 8:inline="Tám trăm";break;
		                case 9:inline="Chín trăm";break;
		            }
		//	                System.out.println(a);
		            switch(chuc)
		            {
		                case 1:inline=inline+" Mười";break;
		                case 2:inline=inline+" Hai mươi";break;
		                case 3:inline=inline+" Ba mươi";break;
		                case 4:inline=inline+" bốn mươi";break;
		                case 5:inline=inline+" năm mươi";break;
		                case 6:inline=inline+" sáu mươi";break;
		                case 7:inline=inline+" bảy mươi";break;
		                case 8:inline=inline+" tám mươi";break;
		                case 9:inline=inline+" chín mươi";break;
		            }
		            switch(donvi)
		            {
		                case 1:inline=inline+" Mot";break;
		                case 2:inline=inline+" Hai ";break;
		                case 3:inline=inline+" Ba ";break;
		                case 4:inline=inline+" Bon ";break;
		                case 5:inline=inline+" Nam ";break;
		                case 6:inline=inline+" Sau ";break;
		                case 7:inline=inline+" bay ";break;
		                case 8:inline=inline+" Tam ";break;
		                case 9:inline=inline+" chin ";break;
		            }
		            
			        byte[] data = inline.getBytes();
		            //tao gói tin gửi chứa dữ liệu nhận được
		            DatagramPacket dpSend = new DatagramPacket(data, data.length, dpReceive.getAddress(), dpReceive.getPort());
		            datagramSocket.send(dpSend);
			}
		} catch (Exception e) {
			System.err.println("Error: "+ e);
		} finally {
			if(datagramSocket != null) {
				datagramSocket.close();
			}
		}
	}

}
