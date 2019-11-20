package com.jjh.compress;

import java.io.ByteArrayOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class CompressUtil {

	
	public byte[] byteCompress(byte[] in) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DeflaterOutputStream defl = new DeflaterOutputStream(out);
			defl.write(in);
			defl.flush();
			defl.close();
			System.out.println("[CompressUtil::byteCompress] " + in.length + " >> " + out.toByteArray().length);

			return out.toByteArray();
		} catch (Exception e) {
			System.out.println("[CompressUtil::byteCompress]Exception : " + e.getMessage());
			return null;
		}
	}

	public byte[] byteDecompress(byte[] in) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InflaterOutputStream infl = new InflaterOutputStream(out);
			infl.write(in);
			infl.flush();
			infl.close();
			System.out.println("[CompressUtil::byteDecompress] " + in.length + " >> " + out.toByteArray().length);

			return out.toByteArray();
		} catch (Exception e) {
			System.out.println("[CompressUtil::byteDecompress]Exception : " + e.getMessage());
			return null;
		}
	}

}
