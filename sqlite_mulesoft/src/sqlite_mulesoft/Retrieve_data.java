package sqlite_mulesoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Retrieve_data {
	public static void main(String[] args) {
		 try {
			 Class.forName("org.sqlite.JDBC");
			 String dbURL ="jdbc:sqlite:movies.db";
			 Connection conn=DriverManager.getConnection(dbURL);
			 if(conn!=null) {
				 System.out.println("connection established successful");
				Statement st=conn.createStatement();				
			
				 PreparedStatement pt=conn.prepareStatement("select * from movies ");
				 ResultSet rs=pt.executeQuery();
				 System.out.println("movie name\tactor name\tactress name\tyear");
				 System.out.println("________________________________________________");
				 while(rs.next()) {
					 System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		 }
				
				 
			
				
			 }
			 else {
				 System.out.println("not connected with database");
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	 }
}
