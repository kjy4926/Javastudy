package kgboostcamp_04_27_net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class  ConsoleChatClient implements Runnable{
	private InetAddress ia;
	private Socket soc;
	private Scanner key;
	private PrintWriter pw;
	private BufferedReader in;
	private String serverIp = "192.168.41.107"; //접속할 IP주소
	private int serverPort = ConsoleChatServer.SERVER_PORT;

	public ConsoleChatClient() throws Exception{
		ia = InetAddress.getByName(serverIp);
		soc = new Socket(ia, serverPort);
		System.out.println("##서버와 연결됨####");
		key = new Scanner(System.in);
		pw = new PrintWriter(soc.getOutputStream(),true);
		Thread tr=new Thread(this);
		tr.start();
		String msg="";
		while((msg=key.next())!=null){
			pw.println(msg);
		}//while------
	}//생성자---------
	public void run(){
		try{
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String serverMsg="";
			while(true){
				serverMsg=in.readLine();
				System.out.println("From Server: "+serverMsg);
			}//while-----
		}
		catch (Exception e){
			System.out.println("예외: "+e.getMessage());
		}
	}//run()----------

	public static void main(String[] args)  throws Exception{
		new ConsoleChatClient();
	}
}
