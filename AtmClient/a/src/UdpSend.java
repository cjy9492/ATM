import java.io.IOException;
import java.net.*;  
import java.awt.*;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;  
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class UdpSend  
{  public static void sent(String s) throws Exception
    {
	DatagramSocket ds  = new DatagramSocket();  
    byte[] buf = s.getBytes();  
    DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("172.21.90.24"),888);//10000为定义的端口     
    //DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),888);
    ds.send(dp);  
    ds.close();  
    }
public static String receive() throws IOException{
	DatagramSocket ds = new DatagramSocket(662);  //监听8899端口  
    //定义数据包，用于存储数据  
       byte[] buf = new byte[1024];  
       DatagramPacket dp = new DatagramPacket(buf,buf.length);   
       ds.receive(dp);     
       String data = new String(dp.getData(),0,dp.getLength());         
       ds.close();
       return data;
      
}


    public static  void main(String[] args) throws Exception  
    {
     /*Thread readData ; 
     receive receiver = new receive();
     readData = new Thread(receiver);
     readData.start();*/ 
     
     new WindowBox("ATM系统");    
     
     if( receive().equals("T")){new denglu("登陆");new Selection("选择");}
    	/*DatagramSocket ds = new DatagramSocket(8899);  //监听8899端口  
        //定义数据包，用于存储数据  
           byte[] buf = new byte[1024];  
           DatagramPacket dp = new DatagramPacket(buf,buf.length);   
           ds.receive(dp);     
           String ip = dp.getAddress().getHostAddress();   //数据提取  
           String data = new String(dp.getData(),0,dp.getLength());  
           int port = dp.getPort();  
           System.out.println(data);
           ds.close();  */   
 
    }
    
    
}  