package com.jjh.socketside;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtil {
	public final String ip = "localhost";
	public final int port = 8888;
	
	public final int packet = 30000; //서버와 클라이언트간 한번 통신에 보내는 데이터 양
	
	
	public void serverSocketCloes(ServerSocket ss) {
		try {
			if(ss != null) ss.close();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[SocketUtil::serverSocketCloes] Exception : " + e.getMessage());
		}
	}
	
	public void socketClose(Socket s) {
		try {
			if(s != null) s.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[SocketUtil::socketClose] Exception : " + e.getMessage());
		}
	}
	
	
}
