package sqlite_mulesoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class create_movie_table {
	public static void main(String[] args) {
		 try {
			 Class.forName("org.sqlite.JDBC");
			 String dbURL ="jdbc:sqlite:movies.db";
			 Connection conn=DriverManager.getConnection(dbURL);
			 if(conn!=null) {
				 System.out.println("connection established successful");
				Statement st=conn.createStatement();				
				int n=st.executeUpdate("create table movies(mov_name text primary key ,actor text,actress text,year int)");
				System.out.println("table created sucessfully ");
				 
			
				
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
