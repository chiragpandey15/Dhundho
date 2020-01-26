package backEnd;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class DB 
{
  Scanner sc=new Scanner(System.in);
  private Connection connect = null;
  public static String currentUserId="0";
  private Statement statement = null;
  
  final private String host = "127.0.0.1:3306";
  final private String user = "root";
  final private String passwd = "root";
  public int row;
  String res;
  ArrayList<Report> rep;
  ArrayList<Report> upd;
  ArrayList<String>des;
 
  
  public String ConnectToDatabase(int ch,String arr[]) throws Exception
  {
    try 
    {
      // This will load the MySQL driver, each DB has its own driver
    	
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://" + host + "/dhundho?"
              + "user=" + user + "&password=" + passwd );
      statement = connect.createStatement();
    }
      catch (Exception e)
    {
    	    throw e;
    }
      finally 
    {
    		 // close();
    }
      
    if(connect!=null) 
    {
  	  System.out.println("connected");
  	  if(ch==1)
  	  {
  		  //login
  		  res="0";
    	PreparedStatement stmt=connect.prepareStatement("select * from users where Phone_no=?"); 
	      
	      stmt.setString(1,arr[0]);//1 specifies the first parameter in the query
	      
	      ResultSet rs1=stmt.executeQuery();
	      String pwd="";
	      String type="";
	      String id="";
	      while(rs1.next())
	      {
	    	  pwd=rs1.getString(7);
	    	  type=rs1.getString(6);
	    	  id=String.valueOf(rs1.getInt(1));
	      }
	      
	      if(pwd=="")
	    	  res="0";
	      else if(pwd.equals(arr[1]))
	      {
	    	  res=id; 
	    	  if(type.equals("Admin"))
	    	  {
	    		  res="-"+id;
	    	  }
	      }
	      else
	    	  res="0";
	      
	      currentUserId=id;
	      return res;
  	  }
  	  else if(ch==2)
  	  {
  		  //register
  		PreparedStatement stmt=connect.prepareStatement("select * from users where Phone_no="+arr[1]);
  		ResultSet rs1=stmt.executeQuery();
  		while(rs1.next())
  		{
  			return "unsuccessful";
  		}
      	stmt=connect.prepareStatement("insert into users (Name,Phone_no,Email,Location,Password) values(?,?,?,?,?)"); 
      		
  	      stmt.setString(1,arr[0]);//1 specifies the first parameter in the query  
  	      stmt.setString(2,arr[1]);
  	      stmt.setString(3,arr[2]);
  	      stmt.setString(4,arr[3]);
  	      stmt.setString(5,arr[4]);
  	      stmt.executeUpdate();
  	      
  	      
  	    
  	      stmt=connect.prepareStatement("select * from users where Phone_no=?");
  	      stmt.setString(1,arr[1]);
  	      rs1=stmt.executeQuery();
  	      
  	      while(rs1.next())
	      {
  	    	currentUserId=String.valueOf(rs1.getInt(1));
	      }
  	      stmt=connect.prepareStatement("insert into Worthiness (U_ID,claimed_false,actual_false,reports,fake_reports) values(?,?,?,?,?)");
	      stmt.setString(1,currentUserId);
	      stmt.setInt(2,0);
	      stmt.setInt(3,0);
	      stmt.setInt(4,0);
	      stmt.setInt(5,0);
	      stmt.executeUpdate();
  	      
  	      return("successful");
  	  }
  	  else if(ch==3)
  	  {
  		  //new report
  		  
  		  int id=Integer.parseInt(currentUserId);
  		  
  		  PreparedStatement stmt=connect.prepareStatement("insert into report_new (Name,Age,Height,Gender,Location,Description,Photo,U_ID) values(?,?,?,?,?,?,?,?)"); 
  	      stmt.setString(1,arr[0]);//1 specifies the first parameter in the query
  	      stmt.setString(2,arr[1]);
  	      stmt.setString(3,arr[2]);
  	      stmt.setString(4,arr[3]);
  	      stmt.setString(5,arr[4]);
  	      stmt.setString(6,arr[5]);
  	      stmt.setString(7,arr[6]);
  	      stmt.setInt(8,id);
  	      stmt.executeUpdate();
  	     
  	     id=Integer.parseInt(currentUserId);
  	     
  	    stmt=connect.prepareStatement("select * from worthiness where U_ID="+id);
  	    ResultSet rs1=stmt.executeQuery();
  	    
  	    int present=0,reports=0;
  	    
	  	  while(rs1.next())
	      {
	    	present=1;
	    	reports=rs1.getInt(4);
	      }
	  	  if(present==1)
	  	  {
	  		  reports++;
	  		stmt=connect.prepareStatement("update worthiness set reports="+reports+" where U_ID="+id);
	  		stmt.executeUpdate();
	  	  }
	  	  else
	  	  {
	  		
	  		stmt=connect.prepareStatement("insert into worthiness (U_ID,claimed_false,actual_false,reports,fake_reports) values(?,?,?,?,?)");
	  		stmt.setInt(1,id);
	  		stmt.setInt(2,0);
	  		stmt.setInt(3,0);
	  		stmt.setInt(4,1);
	  		stmt.setInt(5,0);
	  		stmt.executeUpdate();
	  		
	  	  }
  	      return "successful";
  	  }
  	  else if(ch==4)
  	  {
  		  //update report
  		PreparedStatement stmt=connect.prepareStatement("select * from report_new where R_ID="+arr[0]);
  		ResultSet rs1=stmt.executeQuery();
  		while(!rs1.next())
  		{
  			return "unsuccessful";
  		}
		stmt=connect.prepareStatement("insert into report_update (R_ID,Location,Description) values(?,?,?)"); 
		stmt.setString(1,arr[0]);//1 specifies the first parameter in the query  
		stmt.setString(2,arr[1]);
	    stmt.setString(3,arr[2]);
	    stmt.executeUpdate(); 
	    return("successful");
      }
  	  else if(ch==5)
  	  {//fake
  		  //Assuming I have R_ID,U_ID
  		ResultSet r1=statement.executeQuery("select * from report_new where R_ID="+arr[0]);
  		while(!r1.next())
  		{
  			return "unsuccessful";
  		}
  		double fno=1;
  		while(r1.next())
  			fno=r1.getInt(1);
  		
  		int Rid=Integer.parseInt(arr[0]);
  		int id=Integer.parseInt(currentUserId);
  		PreparedStatement stmt=connect.prepareStatement("insert into fake_reporters (R_ID,Fake_user_ID,F_Desc) values(?,?,?)");
  		stmt.setInt(1, Rid);
  		stmt.setInt(2, id);
  		stmt.setString(3,arr[1]);
  		stmt.executeUpdate();
  		
  		
  		ResultSet r2=statement.executeQuery("select claimed_false,actual_false,reports, fake_reports from Worthiness where U_ID="+id);
  		double r_claimed=0,r_reported=1;
  		int no_of_claimed=0,no_of_actual=0,no_of_reports=0,no_of_fake_reports=0;
  		while(r2.next()) 
        {
       	 no_of_claimed=r2.getInt(1);
       	 no_of_actual=r2.getInt(2);
       	 no_of_reports=r2.getInt(3);
       	 no_of_fake_reports=r2.getInt(4);
        }
  		if(no_of_claimed>0)
  			r_claimed= (no_of_actual*1.0)/no_of_claimed;
  		
  		if(no_of_reports>0)
  			r_reported= 1-((no_of_fake_reports*1.0)/no_of_reports);
  		
  		
  		double x=r_claimed*0.5+r_reported*0.5;
  		
  		
  		fno=fno+x;
  		stmt=connect.prepareStatement("update report_new set fake_no="+fno+" where R_ID="+arr[0]);
  		stmt.executeUpdate();
  		no_of_claimed++;
  		id=Integer.parseInt(currentUserId);
  		stmt=connect.prepareStatement("Update Worthiness set claimed_false="+no_of_claimed+" where U_ID="+id);
  		stmt.executeUpdate();
  		
  		
  		 return("successful"); 
  	  }
  	  else if(ch==6)
  	  {
  		  //feed's report view
  		rep=new ArrayList<>();
  		  ResultSet rows=statement.executeQuery("select * from report_new ");//where location="+location);
	  		while(rows.next()) 
	        {
	       	 int Rid=rows.getInt(1);
	       	 //System.out.println(Rid);
	       	 String name=rows.getString(2);
	       	 String age=rows.getString(4);
	       	 String desc=rows.getString(8);
	       	 String gender=rows.getString(6);
	       	 String height=rows.getString(5);
	       	 String loc=rows.getString(7);
	       	 
	       	 String image=rows.getString(3);
	       	 
	       	 rep.add(new Report(Rid,name,height,age,desc,gender,loc,image));
	        }
	  		ResultSet row=statement.executeQuery("select count(*) from report_new");
	       	row.next();
	       	int rc=row.getInt(1);
	  		return String.valueOf(rc);
        }
      
       
  	  
  	else if(ch==7)
	  {//update feed's report view 
		/**ResultSet rs = statement.executeQuery("select * from Report where Age>=? and Age<=?");
		rs=statement.executeQuery("select count(*) FROM Report");
		rs.next();
	    int rowCount = rs.getInt(1);
		ResultSet rs1 = statement.executeQuery("select * from Report order by ID");
      while(rs1.next()) 
      {
     	 String id=rs1.getString(1);
     	 System.out.println(id);
     	 String name=rs1.getString(2);
     	 String age=rs1.getString(3);
     	 String desc=rs1.getString(4);
     	 String gender=rs1.getString(5);
     	 String height=rs1.getString(6);
     	 String weight=rs1.getString(7);
     	 rep.add(new Report(id,name,height,weight,age,desc,gender));
     	 
      }
    
     return String.valueOf(rowCount);**/
	  }
  	else if(ch==8)
	  {
  		// For getting Updates so as to print in Feed
  		upd=new ArrayList<>();
  		PreparedStatement stmt=connect.prepareStatement("select * from  report_update where R_ID=?"); 
  		stmt.setString(1,arr[0]);
  		int id=Integer.parseInt(arr[0]);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			 String Loc=rs.getString(2);
	       	 String Desc=rs.getString(3);
	       	 upd.add(new Report(id,Desc,Loc));
	       	
		}
		
		PreparedStatement stmt1=connect.prepareStatement("select count(*) FROM report_update where R_ID=?");
		stmt1.setString(1,arr[0]);
		rs=stmt1.executeQuery();
		rs.next();
	    int rowCount = rs.getInt(1);
	   
	    return String.valueOf(rowCount);
	  }
  	else if(ch==9)
  	{
  		//Admin
  		//Assuming I have ID
  		int id=Integer.parseInt(currentUserId);
  		ResultSet r1=statement.executeQuery("select Type from users where U_ID = "+id);
  		String Type="";
  		while(r1.next())
  			Type=r1.getString(1);
  		
  		if(Type.equals("Admin"))
  		{
  			rep=new ArrayList<>();
  			r1=statement.executeQuery("select * from report_new where fake_no>="+1);
  			while(r1.next()) 
	        {
	       	 int Rid=r1.getInt(1);
	       	 System.out.println(Rid);
	       	 String name=r1.getString(2);
	       	 String age=r1.getString(4);
	       	 String desc=r1.getString(8);
	       	 String gender=r1.getString(6);
	       	 String height=r1.getString(5);
	       	 String loc=r1.getString(7);
	       	 
	       	 String image=r1.getString(3);
	       	 rep.add(new Report(Rid,name,height,age,desc,gender,loc,image));
	       	 
	        }
  			if(rep.size()==0)
  				return "0";
  			ResultSet row=statement.executeQuery("select count(*) from report_new where fake_no>=1");
	       	row.next();
	       	int rc=row.getInt(1);
	  		return String.valueOf(rc);
  		}
  		else 
  			return "0";
  	}
  	else if(ch==10)
  	{
  		des=new ArrayList<>();
  		PreparedStatement stmt=connect.prepareStatement("select * from  fake_reporters where R_ID=?");
  		stmt.setString(1,arr[0]);
  		ResultSet rs = stmt.executeQuery();
  		while(rs.next()) 
        {
       	 String desc=rs.getString(3);
       	 des.add(desc);
        }
  		ResultSet row=statement.executeQuery("select count(*) from fake_reporters where R_ID="+arr[0]);
       	row.next();
       	int rc=row.getInt(1);
  		return String.valueOf(rc);
  	}
  	else if(ch==11)
  	{
  		String userID;
  		ResultSet row=statement.executeQuery("select * from report_new where R_ID="+arr[0]);
       	row.next();
       	userID=row.getString(9);
  		row=statement.executeQuery("select * from Worthiness where U_ID="+userID);
       	row.next();
       	int fk=row.getInt(5);
       	fk++;
       	
       	PreparedStatement stmt=connect.prepareStatement("Update Worthiness set fake_reports="+fk+" where U_ID="+userID);
  		stmt.executeUpdate();
       	
  		ArrayList<Integer>IDs;
  		IDs=new ArrayList<>();
  		row=statement.executeQuery("select * from fake_reporters where R_ID="+arr[0]);
  		while(row.next())
  		{
  			int a=row.getInt(2);
  			IDs.add(a);
  		}
  		for(int i=0;i<IDs.size();i++)
  		{
  			row=statement.executeQuery("select * from Worthiness where U_ID="+IDs.get(i));
  	       	row.next();
  	       	fk=row.getInt(3);
  	       	fk++;
  			stmt=connect.prepareStatement("Update Worthiness set actual_false="+fk+" where U_ID="+IDs.get(i));
  	  		stmt.executeUpdate();
  		}
  		
  		stmt=connect.prepareStatement("delete from fake_reporters where R_ID="+arr[0]);
  		stmt.executeUpdate();
  		stmt=connect.prepareStatement("delete from report_update where R_ID="+arr[0]);
  		stmt.executeUpdate();
  		stmt=connect.prepareStatement("delete from report_new where R_ID="+arr[0]);
  		stmt.executeUpdate();
  		return "deleted";
  	}
  	else if(ch==12)
  	{
  		
  		
  		PreparedStatement stmt=connect.prepareStatement("delete from fake_reporters where R_ID="+arr[0]);
  		stmt.executeUpdate();
  		stmt=connect.prepareStatement("update report_new set fake_no=0 where R_ID="+arr[0]);
  		stmt.executeUpdate();
  		return "Discard";
  	}
    }
    return "ok";
  }

//	else if (connect==null)
//	  return "not connected";
//	
//	else
//		return ("entry unsuccessful");
//	return null;
//    
//}
//}
//
//  
//  private void close() {
//	    try {
//	      if (resultSet != null) {
//	        resultSet.close();
//	      }
//
//	      if (statement != null) {
//	        statement.close();
//	      }
//
//	      if (connect != null) {
//	        connect.close();
//	      }
//	    } catch (Exception e) {
//
//	    }
//	  }
}