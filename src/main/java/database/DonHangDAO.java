package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang>{
	
	
	
	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> data_donHang = new ArrayList<DonHang>();
		 Connection con = JDBCUntil.getConnection();
		 String sql = "SELECT* FROM donhang";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonHang = rs.getString("maDonHang");
				
				String maKhachHang = rs.getString("maKhachHang");
				String diaChiHoaDon = rs.getString("diaChiHoaDon");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String trangThai = rs.getString("trangThai");
				String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
				String trangThaiThanhToan = rs.getString("trangThaiThanhToan");
				double soTienDaThanhToan = rs.getDouble("soTienDaThanhToan");
				double soTienConNo = rs.getDouble("soTienConNo");
				Date ngayDat = rs.getDate("ngayDat");
				Date ngayGiao = rs.getDate("ngayGiao");
				KhachHang khachhang = new KhachHangDAO().selectById(new KhachHang(maKhachHang, "", "", "", "", null, "", "", true, "", "", ""));
				
				DonHang donhang = new DonHang(maDonHang, khachhang, diaChiHoaDon, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConNo, ngayDat, ngayGiao);
				
				
				data_donHang.add(donhang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JDBCUntil.closeConnection(con);
		return data_donHang;
	}

	@Override
	public DonHang selectById(DonHang t) {
		
		DonHang donhang= null;
		Connection con = JDBCUntil.getConnection();
		 String sql = "SELECT* FROM donhang WHERE maDonHang=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaDonHang());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonHang = rs.getString("maDonHang");
				String maKhachHang = rs.getString("maKhachHang");
				String diaChiHoaDon = rs.getString("diaChiHoaDon");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String trangThai = rs.getString("trangThai");
				String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
				String trangThaiThanhToan = rs.getString("trangThaiThanhToan");
				double soTienDaThanhToan = rs.getDouble("soTienDaThanhToan");
				double soTienConNo = rs.getDouble("soTienConNo");
				Date ngayDat = rs.getDate("ngayDat");
				Date ngayGiao = rs.getDate("ngayGiao");
				
				KhachHang khachhang = new KhachHangDAO().selectById(new KhachHang(maKhachHang, "", "", "", "", null, "", "", false, "", "", ""));
				donhang = new DonHang(maDonHang, khachhang, diaChiHoaDon, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConNo, ngayDat, ngayGiao);
				JDBCUntil.closeConnection(con);
				return donhang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donhang;
	}

	@Override
	public int insert(DonHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "INSERT INTO donhang(maDonHang,maKhachHang,diaChiHoaDon,diaChiNhanHang,trangThai,hinhThucThanhToan,trangThaiThanhToan,soTienDaThanhToan,soTienConNo,ngayDat,ngayGiao)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaDonHang());
			ps.setString(2, t.getKhachHang().getMaKhachHang());
			ps.setString(3, t.getDiaChiHoaDon());
			ps.setString(4, t.getDiaChiNhanHang());
			ps.setString(5, t.getTrangThai());
			ps.setString(6, t.getHinhThucThanhToan());
			ps.setString(7, t.getTrangThaiThanhToan());
			ps.setDouble(8, t.getSoTienDaThanhToan());
			ps.setDouble(9, t.getSoTienConNo());
			ps.setDate(10, t.getNgayDat());
			ps.setDate(11, t.getNgayGiao());
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
	public int insertAll(ArrayList<DonHang> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DonHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "DELETE FROM donhang WHERE maDonHang=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaDonHang());
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
	public int update(DonHang t) {
		Connection con = JDBCUntil.getConnection();
		String sql = "UPDATE donhang"
				+ "	SET maKhachHang=?,diaChiHoaDon=?,diaChiNhanHang=?,trangThai=?,hinhThucThanhToan=?,trangThaiThanhToan=?,soTienDaThanhToan=?,soTienConNo=?,ngayDat=?,ngayGiao=?"
				+ "	WHERE maDonHang=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t.getKhachHang().getMaKhachHang());
			ps.setString(2, t.getDiaChiHoaDon());
			ps.setString(3, t.getDiaChiNhanHang());
			ps.setString(4, t.getTrangThai());
			ps.setString(5, t.getHinhThucThanhToan());
			ps.setString(6, t.getTrangThaiThanhToan());
			ps.setDouble(7, t.getSoTienDaThanhToan());
			ps.setDouble(8, t.getSoTienConNo());
			ps.setDate(9, t.getNgayDat());
			ps.setDate(10, t.getNgayGiao());
			ps.setString(11, t.getMaDonHang());
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
		DonHangDAO donhang = new DonHangDAO();
		ArrayList<DonHang> ds = donhang.selectAll();
		for (DonHang donHang2 : ds) {
			System.out.println(donHang2.toString());
		}
		DonHang dh1 = new DonHang();
		dh1.setMaDonHang("DH02");
		donhang.selectById(dh1);
		KhachHang kh1 = new KhachHang();
		kh1.setMaKhachHang("KH02");
		DonHang dh2 = new DonHang("DH03", kh1,"Hà Nội", "Hà Nội", "Đang xác thực", "COD", "Đã thanh toán", 10000, 50000, Date.valueOf("2020-08-25"), Date.valueOf("2020-09-02"));
		donhang.insert(dh2);
		donhang.delete(dh2);
		//donhang.update(dh2);
	}
}
