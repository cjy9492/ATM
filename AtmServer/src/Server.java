import java.io.*;
import java.net.*;
import java.util.*;


public class Server implements Runnable {
	   public void run() {
	      DatagramPacket pack=null;
	      DatagramSocket postman=null;
	      byte data[]=new byte[8192];
	      String caozuo,a1,a2,x;
	      Atmuser a = null;
	      
	      try{  
	    	  pack=new DatagramPacket(data,data.length);
	          postman = new DatagramSocket(888);
	      }
	      catch(Exception e){} 
	      int i = 0;
	      int j = 0;
	      while(true) {  
	        if(postman==null) break;
	        else
	          try{ 
	        	   postman.receive(pack); //阻塞收
	                caozuo=new String(pack.getData(),0,pack.getLength());//拆包
	               
	               postman.receive(pack); //阻塞收
	                a1=new String(pack.getData(),0,pack.getLength());//拆包
	               
	               postman.receive(pack); //阻塞收
	                a2=new String(pack.getData(),0,pack.getLength());//拆包


	               if(caozuo.equals("0"))
	               {
	            	    a=new Atmuser();
	            	    a.login(a1, a2);
	            		if(!a.f){System.exit(0);}
	            		a.selectmoney();
	            		retu("T");
	            		System.out.println("========================");
	               }
	               
	               if(caozuo.equals("1"))
	               {
	            	   float sa=Float.parseFloat(a1);
	            	   a.savemoney(sa);
	            	   System.out.println("========================");
	               }
	               
	               if(caozuo.equals("2"))
	               {
	            	   float oa=Float.parseFloat(a1);
	            	   x=String.valueOf(a.takeoutmoney(oa));
	            	   retu(x);
	            	   System.out.println("========================");
	               }
	               
	               if(caozuo.equals("3"))
	               {
	            	   float ta=Float.parseFloat(a2);
	            	   x=String.valueOf(a.transfermoney(a1, ta));
	            	   retu(x);
	            	   System.out.println("========================");
	               }
	               
	               if(caozuo.equals("4"))
	               {
	            	   a.changepwd(a1);
	            	   System.out.println("========================");
	               }
	              
	               if(caozuo.equals("5"))
	               {
	            	   x=String.valueOf(a.selectmoney());
	            	   retu(x);
	            	   System.out.println("========================");
	               }
	               
	               if(caozuo.equals("n"))
	               {
	            	   retu(a.name);
	            	   System.out.println("已发出名字");
	               }
	               
	          }
	          catch(Exception e){
	        	  
	        	  
	          }
	      } 
	   }
	   
	   public void retu(String a) {
		      try{ 
		            byte [] buffer=new byte[1];
		            InetAddress address=InetAddress.getByName("127.0.0.1");
		            DatagramPacket dataPack=new DatagramPacket(buffer,buffer.length, address,662);
		            DatagramSocket postman=new DatagramSocket();
		                String mess = String.valueOf(a);
		                buffer=mess.getBytes();
		                dataPack.setData(buffer);
		                postman.send(dataPack);

		       }
		       catch(Exception e) {
		            System.out.println(e);
		       }
		   }
	  
}