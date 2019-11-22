package com.jjh.clientside;


import java.io.OutputStream;
import java.net.Socket;

import com.jjh.compress.CompressUtil;
import com.jjh.filecontrol.FileUtil;
import com.jjh.socketside.SocketUtil;

public class ClientApp {
	
	Socket       c_socket;
	OutputStream os;
	
	SocketUtil   su;
	FileUtil     fu;
	
	byte[] fileByte = null;
	byte[] sendByte = null;
	
	
	public ClientApp() {
		
		try {
			
			//파일 읽기
			fu = new FileUtil();
			fileByte = fu.getFileByte(); //파일전체
//			fileByte = new CompressUtil().byteCompress(fu.getFileByte()); //파일 압축 후 
			
			su = new SocketUtil();			
			
			//파일 크기에 따라 몇번 데이터를 보낼지 계산
			int loopCnt = (fileByte.length/su.packet) + 1;
			System.out.println("[ClientApp::ClientApp] loopCnt : " + loopCnt);
			for (int i = 0; i < loopCnt; i++) {
				
				//서버와의 소켓 생성
				c_socket = new Socket(su.ip, su.port);
				os = c_socket.getOutputStream();
				
				//파일길이 체크 후 서버로 보낼 데이터길이 설정
				//SocketUtil에 packet설정으로 기본 데이터길이를 결정
				//남은 파일길이가 packet길이보다 짧을 경우 계산후 데이터 길이 결정
				if(fileByte.length < (i+1) * su.packet) {
					sendByte = new byte[fileByte.length - (i * su.packet)];
					System.arraycopy(fileByte, su.packet*i, sendByte, 0, fileByte.length - (i * su.packet));					
				} else {
					sendByte = new byte[su.packet];
					System.arraycopy(fileByte, su.packet*i, sendByte, 0, su.packet);
				}
				
				os.write(sendByte);
				os.flush();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[ClientApp::ClientApp] Exception : " + e.getMessage());
		}  finally {
			su.socketClose(c_socket);
		}
		
	}
	
	
	

	
	
	
	
}
