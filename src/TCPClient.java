import java.io.*;
import java.net.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class TCPClient {

  public final static int SOCKET_PORT = 8890;      // you may change this
  public final static String SERVER = "127.0.0.1";  // localhost
 //public final static String SERVER = "54.245.20.108";  // localhost
  public final static String FILE_TO_RECEIVED = "./source-downloaded.txt";

  public final static int FILE_SIZE = 6022386; // file size temporary hard coded
                                               // should bigger than the file to be downloaded

  public static void main (String [] args ) throws IOException {
    int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket sock = null;
    try 
    {
      sock = new Socket(SERVER, SOCKET_PORT);
      InputStream is = sock.getInputStream();
      OutputStream os = sock.getOutputStream();
      fos = new FileOutputStream(FILE_TO_RECEIVED);
      bos = new BufferedOutputStream(fos);
      System.out.println("Connecting...");
      
      os.write("HelloWORLD".getBytes());
      os.flush();
      
      // receive file
      byte [] mybytearray  = new byte [FILE_SIZE];
 
      bytesRead = is.read(mybytearray,0,mybytearray.length);
      current = bytesRead;
      String S=new String(mybytearray);
      bos.write(mybytearray, 0 , current);
      bos.flush();
      System.out.println("File " + FILE_TO_RECEIVED
          + " downloaded (" + current + " bytes read)");
    }
    finally 
    {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (sock != null) sock.close();
    }
  }

}