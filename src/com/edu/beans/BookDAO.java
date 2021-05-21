package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
//전체 리스트, 신규입력, 수정, 삭제 - DBMS
	
	//한건 조회
	public BookBean getBook(String title) {
		BookBean book = new BookBean();
		String sql = "select * from book where title = ?";
		conn = DAO.connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book;
	}
	//전체 리스트 여러건 조회
	public List<BookBean> getBookList() {
		List<BookBean> list = new ArrayList<BookBean>();
		String sql = "select * from book";
		conn = DAO.connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close();
		}
		return list;
	}
	
	//저자별 책 조회
	public List<BookBean> getBooksByAuthor(String author) {
		List<BookBean> list = new ArrayList<BookBean>();
		conn = DAO.connect();
		String sql = "select * from book where author = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, author);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				list.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public void insert(BookBean book) {
		conn = DAO.connect();
		String sql = "insert into book values (?,?,?)";
		System.out.println(book.getTitle());
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	
	public void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
