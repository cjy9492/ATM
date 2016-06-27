import java.net.*;
public class receive extends Thread implements Runnable  {
	
	
	
	public void run() {
      DatagramPacket pack=null;
      DatagramSocket postman=null;
      byte data[]=new byte[8192];
      try{  pack=new DatagramPacket(data,data.length);
            postman = new DatagramSocket(8899);
      }
      catch(Exception e){} 
      while(true) {  
        if(postman==null) break;
        else
          try{ postman.receive(pack); 
               String message=new String(pack.getData(),0,pack.getLength());
               System.out.printf(message);
               
               
          }
          catch(Exception e){}
      } 
   }
  
	
}