package com.jjh.clientside;


import java.io.OutputStream;
import java.net.Socket;
import com.jjh.filecontrol.FileUtil;
import com.jjh.socketside.SocketUtil;

public class ClientApp {
	
	Socket       c_socket;
	OutputStream os;
	
	SocketUtil   su;
	FileUtil     fu;
	
	
	public ClientApp() {
		
		try {
			
			fu = new FileUtil();
			fu.getFileByte();
			
			su = new SocketUtil();
//			c_socket = new Socket(su.ip, su.port);
//			
//			String msg = "over";
//			
//			os = c_socket.getOutputStream();
//			os.write(msg.getBytes());
//			os.flush();
//			
//			System.out.println("[SEND]" + msg);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[ClientApp::ClientApp] Exception : " + e.getMessage());			
		}  finally {
			su.socketClose(c_socket);
		}
		
		su.socketClose(c_socket);
		
	}
	
	
	

	
	
	
	
}
