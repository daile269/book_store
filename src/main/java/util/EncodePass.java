package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncodePass {
	//md5
	// sha-1
	public static String toSha1(String str) {
		String salt ="doqwjoidwqj;qjiwd,s";
		String result = null;
		
		str = str + salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(dataBytes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result; 
	}
	public static void main(String[] args) {
		System.out.println(toSha1("123456"));
	}
}
