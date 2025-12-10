package day08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex04_Server {

	//port 설정
	public static final int PORT = 6000;
	
	public static void main(String[] args) {
		
		try {
			//서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			while(true) {
				//연결 대기 후 요청이 오면 수락 후 소켓 객체 생성
				Socket socket = serverSocket.accept();
				
				//클라이언트가 보낸 아이디 및 메세지를 다른 클라이언트들에게 전송
				//(본인 클라이언트포함)
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
