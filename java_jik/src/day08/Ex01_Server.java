package day08;

import java.net.ServerSocket;
import java.net.Socket;

public class Ex01_Server {

	public static void main(String[] args) {
		
		//1. port 지정
		int port = 7000;
		
		//2. port를 이용하여 서버소켓 객체 생성
		try(ServerSocket serverSocket = new ServerSocket(port)){
			
			System.out.println("[연결 대기 중...]");
			
			//3. 연결 대기 후, 연결 요청이 오면 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			System.out.println("[연결 성공!]");
			
			
		}catch(Exception e) {
			System.err.println("예외가 발생했습니다.");
		}

	}

}
