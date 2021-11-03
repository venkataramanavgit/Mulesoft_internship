package sqlite_mulesoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert_data_into_table {
	public static void main(String[] args) {
		 try {
			 Class.forName("org.sqlite.JDBC");
			 String dbURL ="jdbc:sqlite:movies.db";
			 Connection conn=DriverManager.getConnection(dbURL);
			 if(conn!=null) {
				System.out.println("connection established successful");
				
				
				Scanner sc=new Scanner(System.in);
				 System.out.println("Enter the movie name:");
				 String  movie_name=sc.next();
				 System.out.println("Enter the actor name:");
				 String  actor_name=sc.next();
				 System.out.println("Enter the actress name:");
				 String  actress_name=sc.next();
				 System.out.println("Enter the movie released year:");
				 int year=sc.nextInt();
				 
				PreparedStatement pt=conn.prepareStatement("insert into movies values(?,?,?,?)");
				 pt.setString(1, movie_name);
				 pt.setString(2, actor_name);
				 pt.setString(3, actress_name);
				 pt.setInt(4, year);
				 int n=pt.executeUpdate();
				 System.out.println(n);
				 
			
				
			 }
			 else {
				 System.out.println("not connected");
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	 }
}
