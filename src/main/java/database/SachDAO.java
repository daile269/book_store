package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO implements DAOInterface<Sach> {
	
	
	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> data_sach = new ArrayList<>();
		Connection con = JDBCUntil.getConnection();
		
		String sql = "SELECT * FROM sach";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String maTacGia = rs.getString("maTacGia");
				
				int namXuatBan = rs.getInt("namXuatBan");
				int soLuong = rs.getInt("soLuong");
				String maTheLoai = rs.getString("maTheLoai");
				String ngonNgu = rs.getString("ngonNgu");
				double giaNhap = rs.getDouble("giaNhap");
				double giaBan = rs.getDouble("giaBan");
				String moTa = rs.getString("moTa");
				
				TacGia tgia = new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, ""));
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(maTheLoai, ""));
				Sach sach = new Sach(maSach, tenSach, tgia, namXuatBan, soLuong, theLoai, ngonNgu, giaNhap, giaBan, moTa);
				data_sach.add(sach);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUntil.closeConnection(con);
		return data_sach;
	}

	@Override
	public Sach selectById(Sach t) {
		Connection con = JDBCUntil.getConnection();
		Sach sach = null;
		String sql = "SELECT * FROM sach WHERE maSach=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, t.getMaSach());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				int soLuong = rs.getInt("soLuong");
				String maTheLoai = rs.getString("maTheLoai");
				String ngonNgu = rs.getString("ngonNgu");
				double giaNhap = rs.getDouble("giaNhap");
				double giaBan = rs.getDouble("giaBan");
				String moTa = rs.getString("moTa");
				
				TacGia tgia = new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, ""));
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(maTheLoai, ""));
				sach = new Sach(maSach, tenSach, tgia, namXuatBan, soLuong, theLoai, ngonNgu, giaNhap, giaBan, moTa);
				return sach;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUntil.closeConnection(con);
		return sach;
	}

	@Override
	public int insert(Sach t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "INSERT INTO sach(maSach,tenSach,maTacGia,namXuatBan,soLuong,maTheLoai,ngonNgu,giaNhap,giaBan,moTa)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaSach());
			ps.setString(2, t.getTenSach());
			ps.setString(3, t.getTacGia().getMaTacGia());
			ps.setInt(4, t.getNamXuatBan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getTheLoai().getMaTheLoai());
			ps.setString(7, t.getNgonNgu());
			ps.setDouble(8, t.getGiaNhap());
			ps.setDouble(9, t.getGiaBan());
			ps.setString(10, t.getMoTa());
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
	public int insertAll(ArrayList<Sach> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Sach t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "DELETE FROM sach"
				+ " WHERE maSach=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaSach());
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
	public int update(Sach t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE sach"
				+ "	SET tenSach=?,maTacGia=?,namXuatBan=?,soLuong=?,maTheLoai=?,ngonNgu=?,giaNhap=?,giaBan=?,mota=?"
				+ " WHERE maSach=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(10, t.getMaSach());
			ps.setString(1, t.getTenSach());
			ps.setString(2, t.getTacGia().getMaTacGia());
			ps.setInt(3, t.getNamXuatBan());
			ps.setInt(4, t.getSoLuong());
			ps.setString(5, t.getTheLoai().getMaTheLoai());
			ps.setString(6, t.getNgonNgu());
			ps.setDouble(7, t.getGiaNhap());
			ps.setDouble(8, t.getGiaBan());
			ps.setString(9, t.getMoTa());
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
		SachDAO sach = new SachDAO();
		ArrayList<Sach> ds = sach.selectAll();
		for (Sach sach2 : ds) {
			System.out.println(sach2.toString());
		}
//		Sach sach1 = new Sach();
//		sach1.setMaSach("S01");
//		Sach rs = sach.selectById(sach1);
//		System.out.println(rs.toString());
//		TacGia tg = new TacGia();
//		tg.setMaTacGia("TG04");
//		TheLoai tl = new TheLoai();
//		tl.setMaTheLoai("TL04");
//		Sach sach2 = new Sach("S04", "The Explosive Child", tg, 2021, 15, tl, "French", 50000, 56000, "Đứa trẻ bùng nổ");
		//sach.insert(sach2);
		//sach.delete(sach2);
		//sach.update(sach2);
	}
}
