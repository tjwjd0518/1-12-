package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean loginCheck(MemberDto dto) {
		String sql = "select count(*) from member where id=? and pw=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int ret = rs.getInt(1);
				if(ret == 1) {
					return true;
				} else {
					return false;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean registerCheck(MemberDto dto) {
		String sql = "insert into member(id, pw, name) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setNString(3, dto.getName());
			int rs = pstmt.executeUpdate();
			if(rs == 1) {return true;} 
			else {return false;}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
	ArrayList<MemberDto> memberList() {
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
		String sql = "select * from member where id !=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "admin");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				memberList.add(new MemberDto(id, pw, name, point));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
}
