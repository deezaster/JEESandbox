package ch.x3m.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.x3m.beans.OrderManagerBean;

/**
 * Servlet implementation class OrderList
 */
@WebServlet(name = "OrderList", urlPatterns = { "/OrderList" })
public class OrderList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	OrderManagerBean bean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderList() {
		super();
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		return "Short description";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet OrderList</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet OrderList at "
					+ request.getContextPath() + "</h1>");
			out.println("<p>Total Orders:" + bean.countOrders() + "</p>");

			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

}
