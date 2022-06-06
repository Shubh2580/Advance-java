package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.LoginBean;
import in.co.rays.model.DataValidator;
import in.co.rays.model.LoginModel;

@WebServlet(urlPatterns = "/forget")

public class ForgetPasswordCtl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		LoginBean bean = new LoginBean();

		bean.setLogin(login);
		
DataValidator d = new DataValidator();
		

		if (d.isNull(login)) {
			req.setAttribute("err1", "Login is Required...!!");
			
       RequestDispatcher rd = req.getRequestDispatcher("InvalidView.jsp");
		rd.forward(req, resp);

	} 
	else {
LoginModel model = new LoginModel();
		try {
			LoginBean bean1 = model.findByLogin(bean);
			if (!(bean1 == null)) {
				RequestDispatcher rd = req.getRequestDispatcher("PasswordView.jsp");
				req.setAttribute("pass", bean1.getPassword());
				rd.forward(req, resp);
			} else {
				
				resp.sendRedirect("InvalidView.jsp");

			}}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	}}


