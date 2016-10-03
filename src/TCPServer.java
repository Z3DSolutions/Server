import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{


	
	  public final static int SOCKET_PORT = 8890;  // you may change this
	  public final static String FILE_TO_SEND = "./files/source.txt";  // you may change this

	  public static void main (String [] args ) throws IOException {
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    OutputStream os = null;
	    ServerSocket servsock = null;
	    Socket sock = null;
	    IO io=new IO();
	    File[] files=io.getFiles();
	    try {
	      servsock = new ServerSocket(SOCKET_PORT);
	      while (true) {
	        System.out.println("Waiting...");
	        try {
	          sock = servsock.accept();
	          System.out.println("Accepted connection : " + sock);
	          // send file
	          int FILE_SIZE = 6022386;
	          byte [] mybytearray  = new byte [FILE_SIZE];
	          InputStream is = sock.getInputStream();
	          is.read(mybytearray,0,mybytearray.length);
	          System.out.println(mybytearray.length);
	          String S=new String(mybytearray);
	          S=S.trim();
	          System.out.println(S.length()+" "+S);
	          mybytearray  = new byte [FILE_SIZE];
	         System.out.println(S.indexOf("GET"));
	          String get=S.substring(S.indexOf("GET")+4, S.indexOf("HTTP")-1);
	          System.out.println(get);
	          
	          String Send="";
	          Send=get+" \n";
	          if(get.length()<=1)
	          {
	        	  for(int i=0;i<files.length;i++)
	        	  {
	        		  Send=Send+files[i].getName()+"\n";
	        	  }	        	  
	          }
	          else
	          {	   
	        	  Send="File contents!";
	          }
	          File myFile = new File (FILE_TO_SEND);
	          mybytearray  = new byte [(int)myFile.length()];
	          fis = new FileInputStream(myFile);
	          bis = new BufferedInputStream(fis);
	          bis.read(mybytearray,0,mybytearray.length);
	         
	          os = sock.getOutputStream();
	          System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
	          os.write(Send.getBytes(),0,Send.getBytes().length);
	    //      os.write(mybytearray,0,mybytearray.length);
	          System.out.println(mybytearray.length);
	          os.flush();
	          System.out.println("Done.");
	        }
	        finally {
	          if (bis != null) bis.close();
	          if (os != null) os.close();
	          if (sock!=null) sock.close();
	        }
	      }
	    }
	    finally {
	      if (servsock != null) servsock.close();
	    }
	  }
	}

		


		
