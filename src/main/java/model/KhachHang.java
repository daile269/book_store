package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoVaTen;
	private String gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKiNhanTin;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiGhiHoaDon;
	private String maXacThuc;
	private Date thoiGianXacThuc;
	private boolean trangThaiXacThuc;
	private String duongDanAnh;
	public KhachHang() {

	}
	
	
	
	

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			Date ngaySinh, String soDienThoai, String email, boolean dangKiNhanTin, String diaChi,
			String diaChiNhanHang, String diaChiGhiHoaDon, String maXacThuc, Date thoiGianXacThuc,
			boolean trangThaiXacThuc, String duongDanAnh) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNhanTin = dangKiNhanTin;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiGhiHoaDon = diaChiGhiHoaDon;
		this.maXacThuc = maXacThuc;
		this.thoiGianXacThuc = thoiGianXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.duongDanAnh = duongDanAnh;
	}





	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			Date ngaySinh, String soDienThoai, String email, boolean dangKiNhanTin, String diaChi,
			String diaChiNhanHang, String diaChiGhiHoaDon, String maXacThuc, Date thoiGianXacThuc,
			boolean trangThaiXacThuc) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNhanTin = dangKiNhanTin;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiGhiHoaDon = diaChiGhiHoaDon;
		this.maXacThuc = maXacThuc;
		this.thoiGianXacThuc = thoiGianXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}





	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			Date ngaySinh, String soDienThoai, String email, boolean dangKiNhanTin, String diaChi,
			String diaChiNhanHang, String diaChiGhiHoaDon) {

		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNhanTin = dangKiNhanTin;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiGhiHoaDon = diaChiGhiHoaDon;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDangKiNhanTin() {
		return dangKiNhanTin;
	}

	public void setDangKiNhanTin(boolean dangKiNhanTin) {
		this.dangKiNhanTin = dangKiNhanTin;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiGhiHoaDon() {
		return diaChiGhiHoaDon;
	}

	public void setDiaChiGhiHoaDon(String diaChiGhiHoaDon) {
		this.diaChiGhiHoaDon = diaChiGhiHoaDon;
	}
	

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}


	public Date getThoiGianXacThuc() {
		return thoiGianXacThuc;
	}

	public void setThoiGianXacThuc(Date thoiGianXacThuc) {
		this.thoiGianXacThuc = thoiGianXacThuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}


	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	

	public String getDuongDanAnh() {
		return duongDanAnh;
	}

	public void setDuongDanAnh(String duongDanAnh) {
		this.duongDanAnh = duongDanAnh;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", dangKiNhanTin=" + dangKiNhanTin + ", diaChi=" + diaChi
				+ ", diaChiNhanHang=" + diaChiNhanHang + ", diaChiGhiHoaDon=" + diaChiGhiHoaDon + "]";
	}
	
	
}
