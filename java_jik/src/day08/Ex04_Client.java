package day08;

import java.net.Socket;
import java.util.Scanner;

public class Ex04_Client {

	public static void main(String[] args) {
		
		//ip, port 설정
		final int PORT = Ex04_Server.PORT;
		final String IP = "127.0.0.1";
		
		try {
			//연결 요청 후 객체 생성
			Socket socket = new Socket(IP, PORT);
			//아이디를 입력
			Scanner scan = new Scanner(System.in);
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			//클라이언트 객체 생성(아이디 추가)
			Client02 c = new Client02(socket, id);
			//클라이언트의 전송 기능 실행
			c.send();
			//클라이언트의 수신 기능 실행
			c.receive();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
