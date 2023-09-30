package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	
	
	
	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> data_theLoai = new ArrayList<>();
		
		Connection con = JDBCUntil.getConnection();
		
		String sql = "SELECT * FROM theloai";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				
				TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
				data_theLoai.add(tl);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUntil.closeConnection(con);
		return data_theLoai;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai tl = null;
		Connection con = JDBCUntil.getConnection();
		String sql = "SELECT * FROM theloai WHERE maTheLoai=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				
				tl = new TheLoai(maTheLoai, tenTheLoai); 
				JDBCUntil.closeConnection(con);
				return tl;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tl;
	}

	@Override
	public int insert(TheLoai t) {
		
		Connection con = JDBCUntil.getConnection();
		String sql = "INSERT INTO theloai(maTheLoai,tenTheLoai)"
				+ " VALUES(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			ps.setString(2, t.getTenTheLoai());
			int rs = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TheLoai t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "DELETE FROM theloai"
				+ "	WHERE maTheLoai=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			int rs = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(TheLoai t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE theloai"
				+ "	SET tenTheLoai=?"
				+ " WHERE maTheLoai=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenTheLoai());
			ps.setString(2, t.getMaTheLoai());
			int rs = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
//		TheLoaiDAO tl = new TheLoaiDAO();
//		ArrayList<TheLoai> ds = tl.selectAll();
//		for (TheLoai theLoai : ds) {
//			System.out.println(theLoai.toString());
//			
//		}
//		TheLoai tl1 = new TheLoai();
//		tl1.setMaTheLoai("TL03");
//		TheLoai tl_rs = tl.selectById(tl1);
//		System.out.println(tl_rs.toString());
//		TheLoai tl2 = new TheLoai("TL05", "Tiểu Thuyết");
//		//tl.insert(tl2);
//		//tl.delete(tl2);
//		tl.update(tl2);
	}
}
