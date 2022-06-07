package kgboostcamp_04_27_net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatServer implements Runnable{
	private ServerSocket ss;
	private Socket soc;
	private Scanner key;
	private PrintWriter pw;
	private BufferedReader in;
	public static final int SERVER_PORT = 12345;
	
	public ConsoleChatServer(){
		try{
		System.out.println("ConsoleChatServer Started....");
		ss = new ServerSocket(SERVER_PORT);
		soc = ss.accept();
		System.out.println("##클라이언트와 연결 됐음###");
		//키보드 입력 스트림 생성
		key = new Scanner(System.in);
		
		//클라이언트에게 메시지 보낼 스트림--
		pw = new PrintWriter(soc.getOutputStream(),true);

		//클라이언트에서 온 메세지를 멀티스레드로 받는다.
		Thread tr=new Thread(this);
		tr.start();
		
		//클에게 키보드로 메시지 전송---
		String msg="";
		while((msg=key.next())!=null){
			pw.println(msg);
		}//while------------
		}catch(Exception e){
			System.out.println("예외: "+e.getMessage());
		}
	}//생성자 end-----------------
	
	public void run(){
		//클이 보내오는 메시지를 계속 받아서 자기 콘솔에 출력
		try{
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String clientMsg="";
			while(true){
				clientMsg=in.readLine();
				System.out.println("From Client>>"+clientMsg);
			}//while-----			
		}
		catch (Exception e){
			System.out.println("예외: "+e.getMessage());
		}
	}//run()----------------
	public static void main(String[] args){
		new ConsoleChatServer();//서버 가동..
	}
}
