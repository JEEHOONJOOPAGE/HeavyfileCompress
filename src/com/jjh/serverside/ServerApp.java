package com.jjh.serverside;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.jjh.socketside.SocketUtil;

public class ServerApp {
	
	ServerSocket s_socket;
	Socket       c_socket;
	InputStream  is;
	OutputStream os;
	
	SocketUtil su;
	
	public ServerApp() {
		
		
		serverOn(); //서버실행
		
		
		while (true) {
			try {
				c_socket = s_socket.accept();
				is = c_socket.getInputStream();
				
				String msg = getMessage(is); 				
				System.out.println(msg);
				
				if(msg.equalsIgnoreCase("over")) break;
					
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("[ServerApp::ServerApp] Exception : " + e.getMessage());				
			} finally {
				serverClose(); //서버 종료
			}
		}
		
		
		serverClose(); //서버 종료		
	}
	
	
	//서버실행
	public void serverOn() {
		try {
			su = new SocketUtil();
			s_socket = new ServerSocket(su.port);			
			System.out.println("[ServerApp::serverOn] SERVER ON");			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ServerApp::serverOn] Exception : " + e.getMessage());
		}
	}
	
	//서버 종료
	public void serverClose() {		
		su.serverSocketCloes(s_socket);
		su.socketClose(c_socket);
		System.out.println("[ServerApp::serverClose] SERVER CLOSE");		
	}
	
	//메세지 포팅
	public String getMessage(InputStream is) {
		
		byte[] inputByte = new byte[500];
		try {
			
			is.read(inputByte);
			return new String(inputByte).trim();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[ServerApp::getMessage] Exception : " + e.getMessage());
			return "";
		}
		
	}
}
