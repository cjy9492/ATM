import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Atmuser
{
	Date date=new Date();
	Boolean f;
	String name="",card="";
	float money=0;
	
	String url="jdbc:sqlserver://localhost:1433;databaseName=atm_java";
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Atmuser()
   {

		try{
		Class.forName(driver);//加载驱动
		}
		catch(ClassNotFoundException event){System.out.print("无法创建驱动程式实体!");}

   }

//==============================================================登陆 
	   public void login(String userc,String cpwd)
	   {
		   Statement st;
		   Connection con;
		   try{
				Class.forName(driver);//加载驱动
				}
				catch(ClassNotFoundException event){System.out.print("无法创建驱动程式实体!");}
			  try
				{
					con=DriverManager.getConnection(url,"sa","123");
					con.setAutoCommit(true);
					System.out.println("数据库连接成功");
					st=con.createStatement();
					
					ResultSet rs=st.executeQuery("SELECT * from AtmUser where usercard='"+userc+"' and userpwd='"+cpwd+"'");
				    while(rs.next())
				    {   
				    	 name=rs.getString("UserName");
					     money=rs.getFloat("Usermoney");
					     card=rs.getString("UserCard");
				    }
				    
				    if(card!="")f =true;
				    else f=false;

				    st.close();
				    con.close(); 

				}
				catch(SQLException e1) 
				{
					System.out.println("异常"+e1);
				}
	   }
//==============================================================查账
  public float selectmoney()
   {	
	     System.out.println(name);
	     System.out.println(card);
	     System.out.println(money);
	     return money;
   }
   
//==============================================================存钱
  public void savemoney(float sm)
   {
	   Statement st;
	   Connection con;
	   try
		{
			con=DriverManager.getConnection(url,"sa","123");
			con.setAutoCommit(true);
			st=con.createStatement();
			
		    money+=sm;
		    st.execute("UPDATE [atm_java].[dbo].[AtmUser] SET [UserMoney] = "+money+" WHERE UserName='"+name+"'");
		    st.execute("INSERT INTO [atm_java].[dbo].[dailyrecord] ([Time],[Operation]) VALUES('"+df.format(new Date())+"','"+name+"存入"+sm+"')");
			System.out.println("已存入"+sm+"\n当前余额："+money);
			
		    st.close();
		    con.close();
		}
		catch(SQLException e1) 
		{
			System.out.println("异常"+e1);
		}
   }
   
//==============================================================取钱
  public  float takeoutmoney(float tom)
   {
	   Statement st;
	   Connection con;
	   try
		{
			con=DriverManager.getConnection(url,"sa","123");
			con.setAutoCommit(true);
			st=con.createStatement();
			
			
		    money-=tom;
		    if(money<0)
		    	{
		    		System.out.println("操作失败");
		    		money+=tom;
		    		return 0;
		    	}
		    else
		    {
		    	st.execute("UPDATE [atm_java].[dbo].[AtmUser] SET [UserMoney] = "+money+" WHERE UserName='"+name+"'");
		    	st.execute("INSERT INTO [atm_java].[dbo].[dailyrecord] ([Time],[Operation]) VALUES('"+df.format(new Date())+"','"+name+"取出"+tom+"')");
		    	System.out.println("已取出"+tom+"\n当前余额："+money);
		    	
		    }
		    
		    
		    st.close();
		    con.close(); 
		}
		catch(SQLException e1) 
		{
			System.out.println("异常"+e1);
		}
	return 1;
   }
   
//==============================================================转账
   public float transfermoney(String tcard,float tmoney)
   {
	   float um=0;
	   String un="";
	   Statement st;
	   Connection con;
	   try
		{
			con=DriverManager.getConnection(url,"sa","123");
			con.setAutoCommit(true);
			st=con.createStatement();
			
			
		    money-=tmoney;
		    if(money<0)
		    	{
		    		System.out.println("操作失败");
		    		money+=tmoney;
		    		return 0;
		    	}
		    else
		    {
		    	st.execute("UPDATE [atm_java].[dbo].[AtmUser] SET [UserMoney] = "+money+" WHERE UserName='"+name+"'");
		    	ResultSet rs=st.executeQuery("SELECT * from AtmUser where usercard='"+tcard+"'");
			    while(rs.next())
			    {   
			    		um=rs.getFloat("usermoney");
			    		un=rs.getString("username");
			    }
			    
		    	um+=tmoney;
		    	st.execute("UPDATE [atm_java].[dbo].[AtmUser] SET [UserMoney] = "+um+" WHERE Usercard='"+tcard+"'");
		    	st.execute("INSERT INTO [atm_java].[dbo].[dailyrecord] ([Time],[Operation]) VALUES('"+df.format(new Date())+"','"+name+"向"+un+"卡号为"+tcard+"转出"+tmoney+"')");
		    	System.out.println("转账成功！已转出"+tmoney+"\n当前余额："+money);
		    }
		    
		    
		    st.close();
		    con.close(); 
		}
		catch(SQLException e1) 
		{
			System.out.println("异常"+e1);
		}
		return 1;
   }
   
//==============================================================修改密码
   public void changepwd(String cp)
   {
	   Statement st;
	   Connection con;
	   try
		{
			con=DriverManager.getConnection(url,"sa","123");
			con.setAutoCommit(true);
			st=con.createStatement();
			
			
		    st.execute("UPDATE [atm_java].[dbo].[AtmUser] SET [Userpwd] = "+cp+" WHERE UserName='"+name+"'");
		    st.execute("INSERT INTO [atm_java].[dbo].[dailyrecord] ([Time],[Operation]) VALUES('"+df.format(new Date())+"','"+name+"修改密码')");
		    
		    
		    st.close();
		    con.close(); 
		}
		catch(SQLException e1) 
		{
			System.out.println("异常"+e1);
		}
   }

}