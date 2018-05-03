package com.DE.Bots.Service;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class EncryptionTest {/*
	Cipher ecipher;
	Cipher dcipher;
	byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3,
			(byte) 0x03 };
	int iterationCount = 19;
	public EncryptionTest() {

	}
	public String encrypt(String plainText) throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
			UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		String secretKey="ezeon8547";
		
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);		
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
	
		ecipher = Cipher.getInstance(key.getAlgorithm());
		ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		String charSet = "UTF-8";
		byte[] in = plainText.getBytes(charSet);
		byte[] out = ecipher.doFinal(in);
		@SuppressWarnings("restriction")
		String encStr = new sun.misc.BASE64Encoder().encode(out);
		return encStr;
	}

	*//**
	* @param secretKey
	*            Key used to decrypt data
	* @param encryptedText
	*            encrypted text input to decrypt
	* @return Returns plain text after decryption
	*//*
	public String decrypt(String secretKey, String encryptedText) throws NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
			UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException {
		// Key generation for enc and desc
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
		// Prepare the parameter to the ciphers
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
		// Decryption process; same key will be used for decr
		dcipher = Cipher.getInstance(key.getAlgorithm());
		dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
		byte[] utf8 = dcipher.doFinal(enc);
		String charSet = "UTF-8";
		String plainStr = new String(utf8, charSet);
		return plainStr;
	}

	public void data() throws IOException
	{
		final String path = "sample/folder";
		String path1=getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		System.out.println("   "+path1);
		path1=path1+"pdf_Templates";
		final File jarFile = new File(path1);
		//jarFile
		if(jarFile.isFile()) {  // Run with JAR file
		   final JarFile jar = new JarFile(jarFile);
		   final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		   while(entries.hasMoreElements()) {
		       final String name = entries.nextElement().getName();
		       if (name.startsWith(path + "/")) { //filter according to the path
		           System.out.println(name);
		       }
		   }
		   jar.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		//new EncryptionTest().data();
		
		DateFormat FromDF = new SimpleDateFormat("dd/MMM/yyyy");
         FromDF.setLenient(false);  // this is important!
         Date FromDate = FromDF.parse("01/FEB/2017");
		System.out.println("long  "+FromDate.getTime());
		System.out.println(""     );
		Date n=new Date();
	SimpleDateFormat f=	new SimpleDateFormat();
	
	
	long date=	new Date("01/FEB/2017").getTime();
	System.out.println("ADte   "+date  );
		EncryptionTest cryptoUtil = new EncryptionTest();
		String key = "ezeon8547";
		String plain = "01/FEB/2017 Brillio-BSN-1854 Commercial Brillio 3";
		String enc = cryptoUtil.encrypt(key, plain);
		System.out.println(enc.equals("gxWzgHabAdzDQyOV8nWbuZFxk1sQYYH4CF+KfWkvRq53yDwmpqYe068UgOL7rAkdW53jKxrvad4="));
		// String enc="0PQqurP9I526izppw745Qpj4//V8f2WM/ZQK7WEtFuA=";
		//System.out.println("Original text: " + plain);
		//System.out.println("Encrypted text: " + enc);
	String x=	cryptoUtil.decrypt(key,"Kx7sbgeA8HdkRhuiM0xvAsBnQYwhviChhxq9B27M1gj3DkvxdXPVVfJv8WW8Lwi1");
		String plainAfter = cryptoUtil.decrypt(key,enc);
		//System.out.println("Kx7sbgeA8HcpqWNTxBdxMYwSMEGf0LnQ1wneXyz/v6bKpAPtA69e/Rpo4BYAr5jP1uYN+aQt4GA=".equals(enc));
		System.out.println("Original text after decryption: " + plainAfter);
	}
*/}
