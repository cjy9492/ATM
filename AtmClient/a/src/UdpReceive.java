import java.net.*;
import java.net.*;  
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.*;
import java.awt.geom.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;  
class UdpReceive  
{  
    public static void main(String[] args)throws Exception  
    {  
        //����UDP socket�������˵�  
        DatagramSocket ds = new DatagramSocket(888);  //����10000�˿�  
         //�������ݰ������ڴ洢����  
        byte[] buf = new byte[1024];  
        DatagramPacket dp = new DatagramPacket(buf,buf.length);   
        ds.receive(dp);            
        String data = new String(dp.getData(),0,dp.getLength());  
        System.out.println(data);
        //---------����-------------//
        DatagramSocket ds1  = new DatagramSocket();  
        byte[] buf1 = "T".getBytes();    
        DatagramPacket dp1 = new DatagramPacket(buf1,buf1.length,InetAddress.getByName("127.0.0.1"),662);//10000Ϊ����Ķ˿�     
        ds1.send(dp1);  
        ds1.close();  
      
    }  
}  