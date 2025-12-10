package day08;

import java.net.Socket;

public class Ex01_Client {

	public static void main(String[] args) {
		
		//1. 서버 IP주소와 port를 지정
		String ip = "127.0.0.1";
		final int PORT = Ex01_Server.PORT;
		
		//2. IP주소와 port를 이용하여 연결 요청후 성공하면 소켓 객체를 생성
		try(Socket socket = new Socket(ip, PORT)){
			System.out.println("[연결 성공!]");
			
		}catch(Exception e) {
			System.err.println("예외 발생");
		}
	}

}
