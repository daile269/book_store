package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {
	
	@Override
	public ArrayList<KhachHang> selectAll() {
		 ArrayList<KhachHang> data_khachHang = new ArrayList<>();
		 Connection con = JDBCUntil.getConnection();
		 String sql = "SELECT * FROM khachhang";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh = rs.getString("gioiTinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Boolean dangKiNhanTin = rs.getBoolean("dangKiNhanTin");
				String diaChi = rs.getString("diaChi");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String diaChiGhiHoaDon = rs.getString("diaChiGhiHoaDon");
				
				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, ngaySinh, soDienThoai, email, dangKiNhanTin, diaChi, diaChiNhanHang, diaChiGhiHoaDon);
				
				data_khachHang.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JDBCUntil.closeConnection(con);
		return data_khachHang;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang khachHang = null;
		Connection con = JDBCUntil.getConnection();
		 String sql = "SELECT* FROM khachhang WHERE maKhachHang=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaKhachHang());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh = rs.getString("gioiTinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Boolean dangKiNhanTin = rs.getBoolean("dangKiNhanTin");
				String diaChi = rs.getString("diaChi");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String diaChiGhiHoaDon = rs.getString("diaChiGhiHoaDon");
				String maXacThuc = rs.getString("maXacThuc");
				Date thoiGianXacThuc = rs.getDate("thoiGianXacThuc");
				Boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				String duongDanAnh = rs.getString("duongDanAnh");
				khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, ngaySinh, soDienThoai, email, dangKiNhanTin, diaChi, diaChiNhanHang, diaChiGhiHoaDon,maXacThuc,thoiGianXacThuc,trangThaiXacThuc,duongDanAnh);
				JDBCUntil.closeConnection(con);
				return khachHang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public KhachHang kiemTraDangNhap(KhachHang t) {
		KhachHang khachHang = null;
		Connection con = JDBCUntil.getConnection();
		 String sql = "SELECT* FROM khachhang WHERE tenDangNhap=? and matKhau=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenDangNhap());
			ps.setString(2, t.getMatKhau());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh = rs.getString("gioiTinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Boolean dangKiNhanTin = rs.getBoolean("dangKiNhanTin");
				String diaChi = rs.getString("diaChi");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String diaChiGhiHoaDon = rs.getString("diaChiGhiHoaDon");
				
				khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, ngaySinh, soDienThoai, email, dangKiNhanTin, diaChi, diaChiNhanHang, diaChiGhiHoaDon);
				JDBCUntil.closeConnection(con);
				return khachHang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean kiemTraTenDangNhap(String tenDN) {
		boolean kq = false;
		Connection con = JDBCUntil.getConnection();
		 String sql = "SELECT* FROM khachhang WHERE tenDangNhap=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tenDN);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			 JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}
	
	
	
	
	@Override
	public int insert(KhachHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "INSERT INTO khachhang(maKhachHang,tenDangNhap,matKhau,hoVaTen,gioiTinh,ngaySinh,soDienThoai,email,dangKiNhanTin,diaChi,diaChiNhanHang,diaChiGhiHoaDon)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaKhachHang());
			ps.setString(2, t.getTenDangNhap());
			ps.setString(3, t.getMatKhau());
			ps.setString(4, t.getHoVaTen());
			ps.setString(5, t.getGioiTinh());
			ps.setDate(6, t.getNgaySinh());
			ps.setString(7, t.getSoDienThoai());
			ps.setString(8, t.getEmail());
			ps.setBoolean(9, t.isDangKiNhanTin());
			ps.setString(10, t.getDiaChi());
			ps.setString(11, t.getDiaChiNhanHang());
			ps.setString(12, t.getDiaChiGhiHoaDon());
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
	public int insertAll(ArrayList<KhachHang> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "DELETE FROM khachhang"
				+ " WHERE maKhachHang=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaKhachHang());
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
	public int update(KhachHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE khachhang"
				+ " SET tenDangNhap=?,matKhau=?,hoVaTen=?,gioiTinh=?,ngaySinh=?,soDienThoai=?,email=?,dangKiNhanTin=?,diaChi=?,diaChiNhanHang=?,diaChiGhiHoaDon=?"
				+ " WHERE maKhachHang=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t.getTenDangNhap());
			ps.setString(2, t.getMatKhau());
			ps.setString(3, t.getHoVaTen());
			ps.setString(4, t.getGioiTinh());
			ps.setDate(5, t.getNgaySinh());
			ps.setString(6, t.getSoDienThoai());
			ps.setString(7, t.getEmail());
			ps.setBoolean(8, t.isDangKiNhanTin());
			ps.setString(9, t.getDiaChi());
			ps.setString(10, t.getDiaChiNhanHang());
			ps.setString(11, t.getDiaChiGhiHoaDon());
			ps.setString(12, t.getMaKhachHang());
			int rs = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int updateVerifyMail(KhachHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE khachhang"
				+ " SET maXacThuc=?,thoiGianXacThuc=?,trangThaiXacThuc=?"
				+ " WHERE maKhachHang=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t.getMaXacThuc());
			ps.setDate(2, t.getThoiGianXacThuc());
			ps.setBoolean(3, t.isTrangThaiXacThuc());
			ps.setString(4, t.getMaKhachHang());
			int rs = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateImage(KhachHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE khachhang"
				+ " SET duongDanAnh=?"
				+ " WHERE maKhachHang=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t.getDuongDanAnh());
			ps.setString(2, t.getMaKhachHang());
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
		KhachHangDAO khachHang = new KhachHangDAO();
//		ArrayList<KhachHang> ds = khachHang.selectAll();
//		for (KhachHang khachHang2 : ds) {
//			System.out.println(khachHang2.toString());
//		}
//		KhachHang kh = new KhachHang();
//		kh.setMaKhachHang("KH01");
//		KhachHang rs = khachHang.selectById(kh);
//		System.out.println(rs);
//		System.out.println(khachHang.kiemTraTenDangNhap("use1r"));
		
		
		KhachHang kh2 = new KhachHang("KH03", "user", "1235a", "Lê Bảo Dương", "Nam", Date.valueOf("2016-03-25"), "0692368499", "adiw@gmail.com", true, "Hà Nội", "Xã Kỳ Sơn", "Đà Lạt");
		
		Date currentTime = new java.sql.Date(new java.util.Date().getTime()) ;
		System.out.println(currentTime);
		Calendar c = Calendar.getInstance();
		c.setTime(currentTime);
		c.add(Calendar.DATE, 1);
		Date timeVerify = new Date(c.getTimeInMillis());
		System.out.println(timeVerify);
//		kh2.setMaXacThuc("165126");
//		kh2.setThoiGianXacThuc(timeVerify);
//		kh2.setTrangThaiXacThuc(true);
//		khachHang.insert(kh2);
//		khachHang.delete(kh2);
//		khachHang.updateVerifyMail(kh2);
	}

}
