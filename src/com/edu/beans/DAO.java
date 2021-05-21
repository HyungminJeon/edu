package com.edu.beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	
	//Data Access Object
	public static Connection connect() {  
		Connection conn = null;
		try {
			InitialContext ic = new InitialContext();//서버단에서 db소스 관리해주는 객체 lookup 객체를 가지고 있음
			//ds 데이터 풀 관리 객체
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("연결성공!!");
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
