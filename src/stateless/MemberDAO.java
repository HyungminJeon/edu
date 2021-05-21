package stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	PreparedStatement psmt = null;
	Connection conn;
	ResultSet rs;
	
	public MemberDAO() { //생성자
//		DataSource ds = DataSource.getInstance();
//		conn = ds.getConnection();
		//connection pool을 활용해서 connection 객체
		try {
		InitialContext ic = new InitialContext(); //InitialContext:  리소스 풀을 관리해주는 객체
		javax.sql.DataSource ds =  (DataSource) ic.lookup("java:comp/env/jdbc/myoracle"); //java:comp/env : 톰캣 위치
		conn = ds.getConnection();
		
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}
	

	public List<Member> getMemberList() {
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getInt("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public Member checkInfo(String id, String pwd) {
		
		Member mem = new Member();
		
		String sql = "select * from member where MEMBER_ID = ? and member_pwd =?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
			mem.setMemberAge(rs.getInt("member_age"));
			mem.setMemberId(rs.getInt("member_id"));
			mem.setMemberName(rs.getString("member_name"));
			mem.setMemberPwd(rs.getString("member_pwd"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}
	
	//한건 조회
	
	public Member getMember(String id) {
//		int mid = 0;
//		Member mem = new Member();
//		mid = Integer.parseInt(id);
//		
//		String sql = "select * from member where MEMBER_ID = ? and member_pwd ='?'";
		
		Member mem = new Member();
		
		String sql = "select * from member where MEMBER_ID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
			mem.setMemberAge(rs.getInt("member_age"));
			mem.setMemberId(rs.getInt("member_id"));
			mem.setMemberName(rs.getString("member_name"));
			mem.setMemberPwd(rs.getString("member_pwd"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}
	
	
	
	public void insertMember(Member mem) {
		String sql = "insert into member values(?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	

	public void close() {
		if (rs != null) {
		try {
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
		if (rs != null) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		if (rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	}
	



}
