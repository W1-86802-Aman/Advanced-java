package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Util {
   public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
   public static final String DB_URL="jdbc:mysql://localhost:3306/adjava";
   public static final String DB_USER="W1_86802_Aman";
   public static final String DB_PASSWD="manager";
   
   static {
	   try {
		   Class.forName(DB_DRIVER);
	   }catch(ClassNotFoundException e){
		 e.printStackTrace();   
	   }
   }
   
   public static Connection getConnection() throws Exception {
	   Connection con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
	   return con;
   }
}
