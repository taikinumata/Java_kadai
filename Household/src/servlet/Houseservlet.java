package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HouseDAO;
import dto.House;


/**
 * Servlet implementation class Houseservlet
 */
@WebServlet("/Houseservlet")
public class Houseservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Houseservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("keyN");
		String key1 = request.getParameter("income");
		String key2 = request.getParameter("spending");

		//データベースから値を取得

			ArrayList<House> record = HouseDAO.record(key,key1,key2);



		//取得した値をリクエストスコープへ
		request.setAttribute("resultList", record);

		String view = "/WEB-INF/view/Record2.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
