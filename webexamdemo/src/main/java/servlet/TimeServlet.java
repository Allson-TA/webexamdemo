package servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
//	這宣告了一個名為TimeServlet的類別，它繼承自HttpServlet類別，表示這是一個Servlet
//	{ 照裡面可以放多種 }
@WebServlet(urlPatterns = {"/servlet/time","/servlet/today"})

//	這宣告了一個名為TimeServlet的類別，它繼承自HttpServlet類別，表示這是一個Servlet
public class TimeServlet extends HttpServlet {

//	用戶端瀏覽器發送GET請求到"/servlet/time"時，這個方法將被呼叫
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//	PrintWriter 主要用於將資料寫回到HTTP響應 (瀏覽器)
		PrintWriter out = resp.getWriter();	//	得到寫出的物件
		out.print("Time :" + new Date());
		out.close();
	}
}

 

/*
* 在一個Servlet中，當你需要將文字資料傳送給瀏覽器，
* 你可以使用PrintWriter物件。這個物件可以將文字、HTML標記、JSON資料或其他類型的資料寫回到HTTP響應，
* 並且這些資料會在客戶端的瀏覽器上顯示。
*/
