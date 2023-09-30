package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maCTDH;
	private DonHang donHang;
	private Sach sach;
	private int soLuong;
	private double giaBia;
	private double giamGia;
	private double giaBan;
	private double vat;
	private double tongTien;

	public ChiTietDonHang() {

	}

	public ChiTietDonHang(String maCTDH, DonHang donHang, Sach sach, int soLuong, double giaBia, double giamGia,
			double giaBan, double vat, double tongTien) {

		this.maCTDH = maCTDH;
		this.donHang = donHang;
		this.sach = sach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		this.vat = vat;
		this.tongTien = tongTien;
	}

	public String getMaCTDH() {
		return maCTDH;
	}

	public void setMaCTDH(String maCTDH) {
		this.maCTDH = maCTDH;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Objects.equals(maCTDH, other.maCTDH);
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maCTDH=" + maCTDH + ", donHang=" + donHang + ", sach=" + sach + ", soLuong=" + soLuong
				+ ", giaBia=" + giaBia + ", giamGia=" + giamGia + ", giaBan=" + giaBan + ", vat=" + vat + ", tongTien="
				+ tongTien + "]";
	}
	
	
}
