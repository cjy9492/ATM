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
    DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("172.21.90.24"),888);//10000Ϊ����Ķ˿�     
    //DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),888);
    ds.send(dp);  
    ds.close();  
    }
public static String receive() throws IOException{
	DatagramSocket ds = new DatagramSocket(662);  //����8899�˿�  
    //�������ݰ������ڴ洢����  
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
     
     new WindowBox("ATMϵͳ");    
     
     if( receive().equals("T")){new denglu("��½");new Selection("ѡ��");}
    	/*DatagramSocket ds = new DatagramSocket(8899);  //����8899�˿�  
        //�������ݰ������ڴ洢����  
           byte[] buf = new byte[1024];  
           DatagramPacket dp = new DatagramPacket(buf,buf.length);   
           ds.receive(dp);     
           String ip = dp.getAddress().getHostAddress();   //������ȡ  
           String data = new String(dp.getData(),0,dp.getLength());  
           int port = dp.getPort();  
           System.out.println(data);
           ds.close();  */   
 
    }
    
    
}  