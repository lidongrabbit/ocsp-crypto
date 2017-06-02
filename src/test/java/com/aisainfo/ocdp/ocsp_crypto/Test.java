package com.aisainfo.ocdp.ocsp_crypto;


import java.util.HashMap;
import java.util.Map;

import com.aisainfo.ocdp.stream.crypto.AesCipher;
import com.aisainfo.ocdp.stream.crypto.Md5Crypto;

public class Test {
	public static void main(String[] args) {
		
		while(true){
			String imsi = "46000"+(int)(Math.random()*90000)+(int)(Math.random()*90000);
			String aes = AesCipher.encrypt(imsi);
			String md5 = Md5Crypto.encrypt(imsi);	
			//System.out.println(aes+","+md5);
		
		}
		
		
//		String a ="/5XxwA8xpWZ8spWOaBlOjA==";
//		System.out.println("decode :" + AesCipher.decrypt(a));
		
		
		
		
	}
}
