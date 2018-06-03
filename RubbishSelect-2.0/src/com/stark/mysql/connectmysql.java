package com.stark.mysql;

import java.sql.*;

public class connectmysql {
	Connection conn=null;
	Statement stmt=null;
	String url="jdbc:mysql://bj-cdb-j7kbnabp.sql.tencentcdb.com:63591";
	String username="root";
	String password="CSY15987";
	String NUM,teaname,DBNAME,TABLE;
	String line1="id",line2;
	String sql;
	String error=null;

	
	public connectmysql(String DBname,String Table) {
		DBNAME=DBname;
		TABLE=Table;
		connect();
	}
	
	public void connect(){
		try{
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				error="驱动加载失败";
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(url, username, password);
			stmt=conn.createStatement();
			sql="use "+DBNAME;
			stmt.executeUpdate(sql);
		}catch (SQLException e) {
			error="MySQL连接错误";
	        e.printStackTrace();
		}
	}
	
	public void insert(String No,String name){
		NUM=No;
		teaname=name;
		sql="insert into "+TABLE+"("+line1+","+line2+") "+"valus('"+NUM+"','"+teaname+"')";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error="Mysql插入错误";
			e.printStackTrace();
		}
	}
	
	public String geterror(){
		return error;
	}
	
	public String search(String NO){
		NUM=NO;
		String result=" ";
		sql="select * from "+TABLE+" where "+line1+"='"+NUM+"'";
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				result=rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error="Mysql查询错误";
			e.printStackTrace();
		}
		return result;
	}
}
