package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.Email;
import util.RandomNumber;


@WebServlet("/views/khach-hang-view/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset=UTF-8");	
		
		String action = request.getParameter("action");
		
			if(action.equals("login")) {
				Login(request, response);
			}else if(action.equals("logout")) {
				Logout(request, response);
			}else if(action.equals("register")) {
				Register(request, response);
			}else if(action.equals("changePassword")) {
				ChangePassword(request, response);
			}else if(action.equals("changeInformation")) {
				ChangeInfomation(request, response);
			}else if(action.equals("verify")) {
				Verify(request, response);
			}else if(action.equals("changeAvatar")) {
				
				ChangeAvatar(request, response);
			}
			
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void Login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			
			// matKhau = EncodePass.toSha1(matKhau);
			
			KhachHang kh = new KhachHang();
			
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);
			KhachHangDAO khd = new KhachHangDAO();
			KhachHang khachHang = khd.kiemTraDangNhap(kh);
			String url = "";
			
			
			
			
			if(khachHang!= null) {
				HttpSession session =  request.getSession();
				session.setAttribute("khachHang", khachHang);
				
				url = "../index.jsp";
			}else {
				request.setAttribute("err_msg", "Tên đăng nhập hoặc mật khẩu chưa chính xác");
				url ="../khach-hang-view/login.jsp";
			}
			
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void Logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("../index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Register(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String tenDangNhap = request.getParameter("tenDangNhap");		
			String matKhau = request.getParameter("matKhau");
			String nhapLaiMatKhau = request.getParameter("nhapLaiMatKhau");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChi = request.getParameter("diaChi");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String diaChiGhiHoaDon = request.getParameter("diaChiGhiHoaDon");
			String soDienThoai = request.getParameter("soDienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			
			
			
			request.setAttribute("vl_hoVaTen", hoVaTen);
			request.setAttribute("vl_gioiTinh", gioiTinh);
			request.setAttribute("vl_ngaySinh", ngaySinh);
			request.setAttribute("vl_diaChi", diaChi);
			request.setAttribute("vl_diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("vl_diaChiGhiHoaDon", diaChiGhiHoaDon);
			request.setAttribute("vl_soDienThoai", soDienThoai);
			request.setAttribute("vl_email", email);
			request.setAttribute("vl_dongYNhanMail", dongYNhanMail);
			
			
			
			boolean checkErr= false;
			String url = "";
			KhachHangDAO kh = new KhachHangDAO();
			
			if(kh.kiemTraTenDangNhap(tenDangNhap)) {
				request.setAttribute("err_TDN", "Tên đăng nhập đã tồn tại, hãy chọn tên đăng nhập khác !");
				checkErr = true;
			}
			
			if(!matKhau.equals(nhapLaiMatKhau)) {
				request.setAttribute("err_MK", "Mật khẩu không khớp !");
				checkErr = true;
				
			}
//		Mã hóa mật khẩu
//		else {
//			matKhau = EncodePass.toSha1(matKhau);
//		}
			
			Pattern sdt_Pattern = Pattern.compile("\\d{10}");
			Matcher sdt_Matcher = sdt_Pattern.matcher(soDienThoai);	
			
			if(!sdt_Matcher.matches()) {
				checkErr = true;
				request.setAttribute("err_sdt", "Số điện thoại bao gồm 10 ký tự!");
			}
			
			Pattern email_Pattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
			Matcher email_Matcher = email_Pattern.matcher(email);
			if(!email_Matcher.matches()) {
				checkErr = true;
				request.setAttribute("err_email", "Email không hợp lệ!");
			}
			
			if(checkErr) {
				url = "../khach-hang-view/register.jsp";
			}else {
				String maKhachHang = tenDangNhap+ System.currentTimeMillis()+""; 
				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, Date.valueOf(ngaySinh), soDienThoai, email, dongYNhanMail!=null, diaChi, diaChiNhanHang, diaChiGhiHoaDon);
				if(kh.insert(khachHang)>0) {
					String RdNumber = RandomNumber.RandomNumber();
					
					// thoi gian
					Date currentTime = new java.sql.Date(new java.util.Date().getTime()) ;
					
					Calendar c = Calendar.getInstance();
					c.setTime(currentTime);
					c.add(Calendar.DATE, 1);
					Date timeVerify = new Date(c.getTimeInMillis());
					
					boolean trangThaiXacThuc = false;
					khachHang.setMaXacThuc(RdNumber);
					khachHang.setThoiGianXacThuc(timeVerify);
					khachHang.setTrangThaiXacThuc(trangThaiXacThuc);
					if(kh.updateVerifyMail(khachHang)>0) {
						Email.sendEmail(khachHang.getEmail(), "Xác thực tài khoản BookStore", getNoiDung(khachHang));
					}
				}
				url ="../khach-hang-view/success.jsp";
			}

			request.getRequestDispatcher(url).forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		private void ChangePassword(HttpServletRequest request, HttpServletResponse response) {
			try {
				String matKhauCu = request.getParameter("matKhauCu");
				String matKhauMoi = request.getParameter("matKhauMoi");
				String nhapLaiMatKhauMoi = request.getParameter("nhapLaiMatKhauMoi");
				
				KhachHangDAO khd = new KhachHangDAO();
				
				HttpSession session = request.getSession();
				KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
				if(!matKhauCu.equals(khachHang.getMatKhau())) {
					request.setAttribute("err_pass", "Mật khẩu cũ không chính xác");
					
				}else {
					if(!matKhauMoi.equals(nhapLaiMatKhauMoi)) {
						request.setAttribute("err_passAgain", "Mật khẩu không khớp");
					}else {
						khachHang.setMatKhau(matKhauMoi);
						khd.update(khachHang);
						request.setAttribute("success", "Đổi mật khẩu thành công");
					}
				}
				
				request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		private void ChangeInfomation(HttpServletRequest request, HttpServletResponse response) {
			
			try {
				
				
				
				String hoVaTen = request.getParameter("hoVaTen");
				String gioiTinh = request.getParameter("gioiTinh");
				String ngaySinh = request.getParameter("ngaySinh");
				String diaChi = request.getParameter("diaChi");
				String diaChiNhanHang = request.getParameter("diaChiNhanHang");
				String diaChiGhiHoaDon = request.getParameter("diaChiGhiHoaDon");
				String soDienThoai = request.getParameter("soDienThoai");
				String email = request.getParameter("email");
				String dongYNhanMail = request.getParameter("dongYNhanMail");
				
				
				
				request.setAttribute("vl_hoVaTen", hoVaTen);
				request.setAttribute("vl_gioiTinh", gioiTinh);
				request.setAttribute("vl_ngaySinh", ngaySinh);
				request.setAttribute("vl_diaChi", diaChi);
				request.setAttribute("vl_diaChiNhanHang", diaChiNhanHang);
				request.setAttribute("vl_diaChiGhiHoaDon", diaChiGhiHoaDon);
				request.setAttribute("vl_soDienThoai", soDienThoai);
				request.setAttribute("vl_email", email);
				request.setAttribute("vl_dongYNhanMail", dongYNhanMail);
				
				
				
				boolean checkErr= false;
				String url = "changeInformation.jsp";
				KhachHangDAO kh = new KhachHangDAO();
				
				
//			Mã hóa mật khẩu
//			else {
//				matKhau = EncodePass.toSha1(matKhau);
//			}
				
				Pattern sdt_Pattern = Pattern.compile("\\d{10}");
				Matcher sdt_Matcher = sdt_Pattern.matcher(soDienThoai);	
				
				if(!sdt_Matcher.matches()) {
					checkErr = true;
					request.setAttribute("err_sdt", "Số điện thoại bao gồm 10 ký tự!");
				}
				
				Pattern email_Pattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
				Matcher email_Matcher = email_Pattern.matcher(email);
				if(!email_Matcher.matches()) {
					checkErr = true;
					request.setAttribute("err_email", "Email không hợp lệ!");
				}
				
				if(checkErr) {
					url = "changeInformation.jsp";
				}else {
					HttpSession session = request.getSession();
					KhachHang khachHang = (KhachHang)session.getAttribute("khachHang");
					khachHang.setHoVaTen(hoVaTen);
					khachHang.setGioiTinh(gioiTinh);
					khachHang.setNgaySinh(Date.valueOf(ngaySinh));
					khachHang.setDiaChi(diaChi);
					khachHang.setDiaChiNhanHang(diaChiNhanHang);
					khachHang.setDiaChiGhiHoaDon(diaChiGhiHoaDon);
					khachHang.setSoDienThoai(soDienThoai);
					khachHang.setEmail(email);
					khachHang.setDangKiNhanTin(dongYNhanMail!=null);
					kh.update(khachHang);
					request.setAttribute("success", "Thay đổi thông tin thành công");
				}

				request.getRequestDispatcher(url).forward(request, response);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void Verify(HttpServletRequest request, HttpServletResponse response) {
			
			try {
				
				String maKhachHang = request.getParameter("maKhachHang");
				String maXacThuc = request.getParameter("maXacThuc");
				
					
				boolean checkErr= false;
				String url = "../khach-hang-view/verifyEmail.jsp";
				KhachHangDAO khDAO = new KhachHangDAO();
				
				String msg="";
			
				if(checkErr) {
					url = "../khach-hang-view/verifyEmail.jsp";
				}else {	
					KhachHang kh = new KhachHang();
					kh.setMaKhachHang(maKhachHang);
					KhachHang khachHang = khDAO.selectById(kh);
					if(khachHang!=null) {
						if(khachHang.getMaXacThuc().equals(maXacThuc)) {
							khachHang.setTrangThaiXacThuc(true);
							khDAO.updateVerifyMail(khachHang);
							 msg = "Xác thực tài khoản thành công";
						}else {
							 msg = "Xác thực tài khoản thất bại";
						}
					}else {
						 msg = "Khách hàng không tồn tại";
					}
							
					
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void ChangeAvatar(HttpServletRequest request, HttpServletResponse response) {
			
				try {
					KhachHang kh = new KhachHang();
					KhachHangDAO khDAO = new KhachHangDAO();
					
					javax.servlet.http.Part photo = request.getPart("duongDanAnh");
					String realPath = request.getServletContext().getRealPath("/avatar");
					String fileName = Path.of(photo.getSubmittedFileName()).getFileName().toString(); 
					System.out.println(realPath);
					System.out.println(fileName);
					// kh.setDuongDanAnh(fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
		
		public static String getNoiDung(KhachHang kh) {
			
			String link = "http://localhost:8080/BookStore/views/khach-hang-view/khach-hang?action=verify&maKhachHang="+kh.getMaKhachHang()+"&maXacThuc="+kh.getMaXacThuc();
			String content = "<p style=\"text-align: center;\"><strong>X&aacute;c thực t&agrave;i khoản</strong></p>\r\n"
					+ "<p>Ch&agrave;o "+kh.getHoVaTen()+", đ&acirc;y l&agrave; email x&aacute;c thực được gửi từ Đại L&ecirc;. Vui l&ograve;ng x&aacute;c thực bằng c&aacute;ch nhập m&atilde;: <strong>"+kh.getMaXacThuc() +" </strong> hoặc nhấp v&agrave;o đường link dưới đ&acirc;y:</p>\r\n"
					+ "<p><a href=\""+link+"</a></p>\r\n"
					+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y</p>";
			return content;
		}
}
