package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//	1.設定編碼 (才可以看中文)
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//	文件格式 設定UTF-8-->給瀏覽器看得
		resp.setContentType("text/html;charset=UTF-8");	//	html可以讓瀏覽器看的到標籤
		//	resp.setContentType("text/plain;charset=UFT-8");	//	plain代表純文字
		
		//	回應物件
		PrintWriter out = resp.getWriter();
		
		//	2.取得h , w參數
		String hstr = req.getParameter("h");
		String wstr = req.getParameter("w");
		
		//	預防有人亂控白
		if(hstr == null || wstr == null) {
			
			//	回應內容
			out.print("請在網址列上輸入身高體重");	//	條件成立 : 在瀏覽器上輸出的內容
			return;
		}
		
		//	3.計算BMI
		double h = Double.parseDouble(hstr);	//	文字字串要轉型
		double w = Double.parseDouble(wstr);	//	文字字串要轉型
		double bmi = w / Math.pow(h/100,2);
		
		//	4.回應內容
		out.print("BMI = " + bmi);
		
	}
}
