package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
	
	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> data_tacGia = new ArrayList<TacGia>();
		
		Connection con = JDBCUntil.getConnection();
		String sql = "SELECT * FROM tacgia";
		try {
			
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");
				
				TacGia tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				data_tacGia.add(tacGia);
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data_tacGia;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia tg = null;
		Connection con = JDBCUntil.getConnection();
			
		try {
			String sql = "SELECT * FROM tacgia WHERE maTacGia =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");
				
				tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return tg;
	}

	@Override
	public int insert(TacGia t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "INSERT INTO tacgia(maTacGia,hoVaTen,ngaySinh,tieuSu)"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			pst.setString(2, t.getHoVaTen());
			pst.setDate(3, t.getNgaySinh());
			pst.setString(4, t.getTieuSu());
			int rs = pst.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TacGia> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TacGia t) {
		Connection con = JDBCUntil.getConnection();
		
		String sql = "DELETE FROM tacgia"
				+ " WHERE maTacGia=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			int rs = pst.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
				
				
		return 0;
	}

	@Override
	public int update(TacGia t) {
		Connection con = JDBCUntil.getConnection();
		
		String sql = "UPDATE tacgia"
				+ " SET hovaTen=?, ngaySinh=?,tieuSu=?"
				+ " WHERE maTacGia=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getHoVaTen());
			pst.setDate(2, t.getNgaySinh());
			pst.setString(3, t.getTieuSu());
			pst.setString(4, t.getMaTacGia());
			int rs = pst.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	public static void main(String[] args) {
//		TacGiaDAO tgd = new TacGiaDAO();
//		ArrayList<TacGia> ds = tgd.selectAll();
//		for (TacGia tacGia : ds) {
//			System.out.println(tacGia.toString());
//		}
//		TacGia tg1 = new TacGia();
//		tg1.setMaTacGia("TG01");
//		TacGia tg_rs =tgd.selectById(tg1);
//		System.out.println(tg_rs.toString());
//		TacGia tg2 = new TacGia("TG04", "Lê Bảo Linh", Date.valueOf("2016-03-28"), "Tác giả mới thêm vào");
//		tgd.insert(tg2);
		//tgd.update(tg2);
		//tgd.delete(tg2);
	}
}
