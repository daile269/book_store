package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private KhachHang khachHang;
	private String diaChiHoaDon;
	private String diaChiNhanHang;
	private String trangThai;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private double soTienDaThanhToan;
	private double soTienConNo;
	private Date ngayDat;
	private Date ngayGiao;

	public DonHang() {

	}

	public DonHang(String maDonHang, KhachHang khachHang, String diaChiHoaDon, String diaChiNhanHang, String trangThai,
			String hinhThucThanhToan, String trangThaiThanhToan, double soTienDaThanhToan, double soTienConNo,
			Date ngayDat, Date ngayGiao) {

		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiHoaDon = diaChiHoaDon;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConNo = soTienConNo;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChiHoaDon() {
		return diaChiHoaDon;
	}

	public void setDiaChiHoaDon(String diaChiHoaDon) {
		this.diaChiHoaDon = diaChiHoaDon;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public double getSoTienDaThanhToan() {
		return soTienDaThanhToan;
	}

	public void setSoTienDaThanhToan(double soTienDaThanhToan) {
		this.soTienDaThanhToan = soTienDaThanhToan;
	}

	public double getSoTienConNo() {
		return soTienConNo;
	}

	public void setSoTienConNo(double soTienConNo) {
		this.soTienConNo = soTienConNo;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDonHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(maDonHang, other.maDonHang);
	}

	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", khachHang=" + khachHang + ", diaChiHoaDon=" + diaChiHoaDon
				+ ", diaChiNhanHang=" + diaChiNhanHang + ", trangThai=" + trangThai + ", hinhThucThanhToan="
				+ hinhThucThanhToan + ", trangThaiThanhToan=" + trangThaiThanhToan + ", soTienDaThanhToan="
				+ soTienDaThanhToan + ", soTienConNo=" + soTienConNo + ", ngayDat=" + ngayDat + ", ngayGiao=" + ngayGiao
				+ "]";
	}
	
}
