package in.co.rays.ctl;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.LoginBean;
import in.co.rays.model.DataValidator;
import in.co.rays.model.LoginModel;

@WebServlet(urlPatterns = "/login")

public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String pwd = req.getParameter("pwd");
		String uri = (String) req.getParameter("uri");

		LoginBean bean = new LoginBean();
		bean.setLogin(login);
		bean.setPassword(pwd);

		HttpSession session = req.getSession();

		DataValidator d = new DataValidator();

		if (d.isNull(login)) {
			req.setAttribute("err1", "Login is Required...!!");

			if (d.isNull(pwd)) {
				req.setAttribute("err2", "Pass is Required...!!");
			}
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
			rd.forward(req, resp);

		}

		else {

			LoginModel model = new LoginModel();
			try {
				LoginBean bean1 = model.authenticate(bean);
				session.setAttribute("user", bean1.getFirstName());
				if (!(bean1 == null)) {

					System.out.println("uri =" + uri);

					if (uri == null || "null".equalsIgnoreCase(uri)) {
						System.out.println("i am here");
						resp.sendRedirect("wel.do");
					} else {

						resp.sendRedirect(uri);

					}
				} else {

					RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
					req.setAttribute("err", "Invalid Login And Password...!!");
					rd.forward(req, resp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}