package com.jjh.socketside;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtil {
	public String ip = "localhost";
	public int port = 8888;
	
	
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
