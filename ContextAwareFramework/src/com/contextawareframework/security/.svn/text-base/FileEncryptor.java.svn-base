/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        SensorController
 * @Created:    01.01.2014
 * @author:     Prasenjit
 * Last Change: 13.01.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
/****************************************************************************
 * To encrypt / decrypt any file. User has to pass the algo name and path where
 * the encrypted file / decrypted file has to be created. In case user is creating 
 * the file on Sd Card, he / she has to provide the Read / Write Permission on Sd Card
 * in Android manifest file. 
 * **************************************************************************/

public class FileEncryptor{
    
    private String algo;
    private File file;
    /******************************************************************
	 * Description : Custom Constructor
	 ******************************************************************/
    public FileEncryptor(String algo,String path) {
    this.algo=algo; //setting algo
    this.file=new File(path); //setting file
    }
    
    //To encrypt any file
    /******************************************************************
	 * Description : To encrypt a given file with the provided algo
	 ******************************************************************/
     public void encrypt() throws Exception{
        //opening streams
         FileInputStream fis =new FileInputStream(file);
         file=new File(file.getAbsolutePath()+".enc");
         FileOutputStream fos =new FileOutputStream(file);
//         BASE64Decoder decoder = new BASE64Decoder();
//         BASE64Encoder encoder = new BASE64Encoder();
         //generating key
         byte k[] = "HignDlPs".getBytes();   
         
         SecretKeySpec key = new SecretKeySpec(k,algo.split("/")[0]);  //SecretKeySpec(k,algo.split("n")[0]);
         if (key != null) 
         {  
             
             //String Key1 = Base64.encode(key.getEncoded());
             //String Key1 = Base64.encodeToString(key.getEncoded(),Base64.DE);
             System.out.println("Key = " + key.getEncoded().toString());
           }
         //creating and initialising cipher and cipher streams
         Cipher encrypt =  Cipher.getInstance(algo); 
         System.out.println("Key - " + key);
         encrypt.init(Cipher.ENCRYPT_MODE, key);  
         System.out.println("Key - " + encrypt);
         CipherOutputStream cout=new CipherOutputStream(fos, encrypt);
         
         byte[] buf = new byte[1024];
         int read;
         while((read=fis.read(buf))!=-1)  //reading data
             cout.write(buf,0,read);  //writing encrypted data
         //closing streams
         fis.close();
         cout.flush();
         cout.close();
     }
     // Method to decrypt the  encrypted file
     /******************************************************************
 	 * Description : To decrypt a given file with the provided algo
 	 ******************************************************************/
     public void decrypt() throws Exception{
        //opening streams
         FileInputStream fis =new FileInputStream(file);
         file=new File(file.getAbsolutePath()+".dec");
         FileOutputStream fos =new FileOutputStream(file);               
         //generating same key
         byte k[] = "HignDlPs".getBytes();   
         SecretKeySpec key = new SecretKeySpec(k,algo.split("/")[0]);  
         //creating and initialising cipher and cipher streams
         Cipher decrypt =  Cipher.getInstance(algo);  
         decrypt.init(Cipher.DECRYPT_MODE, key);  
         CipherInputStream cin=new CipherInputStream(fis, decrypt);
              
         byte[] buf = new byte[1024];
         int read=0;
         while((read=cin.read(buf))!=-1)  //reading encrypted data
              fos.write(buf,0,read);  //writing decrypted data
         //closing streams
         cin.close();
         fos.flush();
         fos.close();
     
     }
    // public static void main (String[] args)throws Exception {
      //   new FileEncryptor("DES/ECB/PKCS5Padding","/home/prasenjit/Desktop/UploadFile/log.txt").encrypt();
       //  new FileEncryptor("DES/ECB/PKCS5Padding","/home/prasenjit/Desktop/UploadFile/log.txt.enc").decrypt();
//}
}