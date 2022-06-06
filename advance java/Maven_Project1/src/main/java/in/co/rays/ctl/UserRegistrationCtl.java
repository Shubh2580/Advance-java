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
import in.co.rays.model.DataValidator;
import in.co.rays.model.LoginModel;

@WebServlet(urlPatterns = "/reg")

public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String login = req.getParameter("login");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String mob = req.getParameter("mob");
		// String[] address = null;

		LoginBean bean = new LoginBean();

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

		String FirstNamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String LastNamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String passreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		String mobreg = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
		if (fname == null || fname.trim().length() == 0) {
			req.setAttribute("err1", "First Name is required...!!");

			if (lname == null || lname.trim().length() == 0) {
				req.setAttribute("err2", "Last Name is required...!!");

			}
			if (login == null || login.trim().length() == 0) {
				req.setAttribute("err3", "Login is Required...!!");

			}
			if (pwd == null || pwd.trim().length() == 0) {
				req.setAttribute("err4", "password is Required...!!");

			}

			if (gender == null) {
				req.setAttribute("err5", "gender is required");

			}
			if (dob == null) {
				req.setAttribute("err6", "Date of birth is required");

			}

			if (mob == null || mob.trim().length() == 0) {
				req.setAttribute("err7", "Mobile Number is Required...!!");

			}
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);
		}

		else if (!(fname.matches(FirstNamereg))) {

			req.setAttribute("err1", "please enter correct first name");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);

		}

		else if (!(lname.matches(LastNamereg))) {

			req.setAttribute("err2", "please enter correct last name");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);
		}

		else if (!(login.matches(emailreg))) {

			req.setAttribute("err3", "please enter correct email");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);

		}

		else if (!(pwd.matches(passreg))) {

			req.setAttribute("err4", "please enter correct password");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);

		}

		else if (!(mob.matches(mobreg))) {

			req.setAttribute("err7", "please enter Digits");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);

		}

		else {

			LoginModel model = new LoginModel();

			try {
				model.add(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");

			rd.forward(req, resp);
		}

	}
}

/*
 * DataValidator d = new DataValidator();
 * 
 * if(d.isNull(fname)) { req.setAttribute("err1","first name is required");
 * if(d.isNull(lname)) { req.setAttribute("err2", "last name is required");
 * 
 * }if(d.isNull(login)) { req.setAttribute("err3", "login is required");
 * 
 * }if(d.isNull(pwd)) { req.setAttribute("err4", "password is required");
 * 
 * }if(d.isNull(gender)) { req.setAttribute("err5", "gender is required");
 * 
 * }if(d.isNull(dob)) { req.setAttribute("err6", " date of birth is required");
 * 
 * }if(d.isNull(mob)) { req.setAttribute("err7", "mobile number is required"); }
 * RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
 * rd.forward(req, resp); } else {
 * 
 * LoginModel model = new LoginModel();
 * 
 * 
 * 
 * RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
 * 
 * rd.forward(req, resp); try { model.add(bean); } catch (Exception e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } }
 * 
 * }
 */
