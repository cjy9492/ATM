import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AtmServer {
public static void main(String[] args) {
	
	/*Atmuser a=new Atmuser("陈佳雨","111111");
	a.login("陈佳雨","111111" );
	if(!a.f){System.exit(0);}
	a.selectmoney();
	System.out.println("========================");*/
	
	
	Scanner scanner = new Scanner(System.in);
    Thread readData ; 
    Server receiver = new Server();
    try{  readData = new Thread(receiver);
          readData.start();           //负责接收信息的线程 
          byte [] buffer=new byte[1];
          InetAddress address=InetAddress.getByName("127.0.0.1");
          DatagramPacket dataPack=
          new DatagramPacket(buffer,buffer.length, address,662);
          DatagramSocket postman=new DatagramSocket();
          while(scanner.hasNext()) {
              String mess = "";
              buffer=mess.getBytes();
              dataPack.setData(buffer);
              postman.send(dataPack);  
          }
     }
     catch(Exception e) {
          System.out.println(e);
     }

 }

}



   
