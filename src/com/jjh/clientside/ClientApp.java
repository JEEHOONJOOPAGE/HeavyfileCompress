package com.jjh.clientside;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.jjh.socketside.SocketUtil;

public class ClientApp {
	
	Socket       c_socket;
	OutputStream os;
	
	SocketUtil   su;
	
	
	public ClientApp() {
		
		try {
			
			su = new SocketUtil();
			c_socket = new Socket(su.ip, su.port);
			
			String msg = "over";
			
			os = c_socket.getOutputStream();
			os.write(msg.getBytes());
			os.flush();
			
			System.out.println("[SEND]" + msg);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("[ClientApp::ClientApp] UnknownHostException : " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[ClientApp::ClientApp] IOException : " + e.getMessage());
		}
		
		
		
		
		
	}
	
	
	
	
	
}
