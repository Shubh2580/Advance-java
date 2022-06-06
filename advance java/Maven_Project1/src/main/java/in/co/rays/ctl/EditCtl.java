package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.LoginBean;
import in.co.rays.model.LoginModel;

@WebServlet(urlPatterns = "/edit.do")
public class EditCtl extends HttpServlet {

	private static String BACK = "back";
	private static String UPDATE = "update";
	private static String EDIT = "edit";
	private static String DELETE = "delete";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		System.out.println(op);
		int id = Integer.parseInt(req.getParameter("id"));
		//System.out.println(id);

		LoginBean bean = new LoginBean();
		bean.setId(id);
		LoginModel model = new LoginModel();

		if (op.equals(EDIT)) {

			try {
				LoginBean bean1 = model.findByPk(bean);

				RequestDispatcher rd = req.getRequestDispatcher("EditView.jsp");
				req.setAttribute("data", bean1);
				rd.forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals(DELETE)) {
			try {
				model.delete(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher rd = req.getRequestDispatcher("SucessFullyView.jsp");

			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");

		if (op.equals(UPDATE)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			LoginBean bean = new LoginBean();
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String login = req.getParameter("login");
			String pwd = req.getParameter("pwd");
			String gender = req.getParameter("gender");
			String dob = req.getParameter("dob");
			String mob = req.getParameter("mob");
			int id = Integer.parseInt(req.getParameter("id"));

			bean.setFirstName(fname);
			bean.setLastName(lname);
			bean.setLogin(login);
			bean.setPassword(pwd);
			bean.setGender(gender);

			try {
				bean.setDob(sdf.parse(dob));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			bean.setMobileNo(mob);
			bean.setId(id);
			LoginModel model = new LoginModel();
			try {
				model.update(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (op.equals(BACK)) {
			resp.sendRedirect("list");

		}
	}
}
/*
 * LoginBean bean = new LoginBean();
 * 
 * int id = Integer.parseInt(req.getParameter("id"));
 * 
 * bean.setId(id); LoginModel model = new LoginModel(); try {
 * model.delete(bean); } catch (Exception e) { // TODO Auto-generated catch
 * block e.printStackTrace(); }
 * 
 * RequestDispatcher rd = req.getRequestDispatcher("SucessFullyView.jsp");
 * req.setAttribute("sucess", "Successfully Deleted...!!"); rd.forward(req,
 * resp); }
 */
