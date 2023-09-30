package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	
	
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> data_ctdh = new ArrayList<ChiTietDonHang>();
		
		Connection con = JDBCUntil.getConnection();
		
		String sql = "SELECT * FROM chitietdonhang";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maCTDH = rs.getString("maCTDH");
				
				String maDonHang = rs.getString("maDonHang");
				String maSach = rs.getString("maSach");
				int soLuong = rs.getInt("soLuong");
				double giaBia = rs.getDouble("giaBia");
				double giamGia = rs.getDouble("giamGia");
				double giaBan = rs.getDouble("giaBan");
				double vat = rs.getDouble("vat");
				double tongTien = rs.getDouble("tongTien");
				
				DonHang donhang = new DonHangDAO().selectById(new DonHang(maDonHang,new KhachHang(), "", "", "", "", "", 0, 0, null, null));
				Sach sach = new SachDAO().selectById(new Sach(maSach, "", new TacGia(), 0, 0, new TheLoai(), "", 0, 0, ""));
				
				ChiTietDonHang ctdh = new ChiTietDonHang(maCTDH, donhang, sach, soLuong, giaBia, giamGia, giaBan, vat, tongTien);
				data_ctdh.add(ctdh);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUntil.closeConnection(con);
		return data_ctdh;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		Connection con = JDBCUntil.getConnection();
		ChiTietDonHang ctdh = null;
		String sql = "SELECT * FROM chitietdonhang WHERE maCTDH=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaCTDH());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maCTDH = rs.getString("maCTDH");
				String maDonHang = rs.getString("maDonHang");
				String maSach = rs.getString("maSach");
				int soLuong = rs.getInt("soLuong");
				double giaBia = rs.getDouble("giaBia");
				double giamGia = rs.getDouble("giamGia");
				double giaBan = rs.getDouble("giaBan");
				double vat = rs.getDouble("vat");
				double tongTien = rs.getDouble("tongTien");
				
				DonHang donhang = new DonHangDAO().selectById(new DonHang(maDonHang,new KhachHang(), "", "", "", "", "", 0, 0, null, null));
				Sach sach = new SachDAO().selectById(new Sach(maSach, "", new TacGia(), 0, 0, new TheLoai(), "", 0, 0, ""));
				
				ctdh = new ChiTietDonHang(maCTDH, donhang, sach, soLuong, giaBia, giamGia, giaBan, vat, tongTien);
				
				JDBCUntil.closeConnection(con);
				return ctdh;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "INSERT INTO chitietdonhang(maCTDH,maDonHang,maSach,soLuong,giaBia,giamGia,giaBan,vat,tongTien)"
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaCTDH());
			ps.setString(2, t.getDonHang().getMaDonHang());
			ps.setString(3, t.getSach().getMaSach());
			ps.setInt(4, t.getSoLuong());
			ps.setDouble(5, t.getGiaBia());
			ps.setDouble(6, t.getGiamGia());
			ps.setDouble(7, t.getGiaBan());
			ps.setDouble(8, t.getVat());
			ps.setDouble(9, t.getTongTien());
			int rs =  ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "DELETE FROM chitietdonhang"
				+ " WHERE maCTDH=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaCTDH());
			int rs =  ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public int update(ChiTietDonHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE chitietdonhang"
				+ " SET maDonHang=?,maSach=?,soLuong=?,giaBia=?,giamGia=?,giaBan=?,giaBan=?,tongTien=?"
				+ " WHERE maCTDH=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t.getDonHang().getMaDonHang());
			ps.setString(2, t.getSach().getMaSach());
			ps.setInt(3, t.getSoLuong());
			ps.setDouble(4, t.getGiaBia());
			ps.setDouble(5, t.getGiamGia());
			ps.setDouble(6, t.getGiaBan());
			ps.setDouble(7, t.getVat());
			ps.setDouble(8, t.getTongTien());
			ps.setString(9, t.getMaCTDH());
			int rs =  ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
//		ArrayList<ChiTietDonHang> ds = ctdh.selectAll();
//		for (ChiTietDonHang chiTietDonHang : ds) {
//			System.out.println(chiTietDonHang.toString());
//		}
//		ChiTietDonHang ctdh1 = new ChiTietDonHang();
//		ctdh1.setMaCTDH("CTDH02");
//		ChiTietDonHang rs = ctdh.selectById(ctdh1);
//		System.out.println(rs.toString());
		DonHang dh = new DonHang("DH02", null, null, null, null, null, null, 0, 0, null, null);
		Sach sach = new Sach("S03", null, null, 0, 0, null, null, 0, 0, null);
		ChiTietDonHang ctdh1 = new ChiTietDonHang("CTDH03", dh, sach, 150, 25000, 2000, 30000, 0, 5000);
		ctdh.insert(ctdh1);
//		ctdh.delete(ctdh1);
//		ctdh.update(ctdh1);
	}
}
