package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.LoginBean;
import in.co.rays.model.LoginModel;

@WebServlet(urlPatterns = "/list.do")

public class UserListCtl extends HttpServlet {
	private static String NEXT = "next";
	private static String SEARCH = "search";
	private static String PREVIOUS = "previous";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LoginBean bean = new LoginBean();
		// bean.setFirstName("Nisha");
		LoginModel model = new LoginModel();

		try {

			List<LoginBean> list = model.search(bean, 1, 10);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			req.setAttribute("list", list);
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String fname = req.getParameter("fname");
		int pageNo = Integer.parseInt(req.getParameter("page"));
		System.out.println(pageNo);

		LoginBean bean = new LoginBean();
		bean.setFirstName(fname);
		LoginModel model = new LoginModel();
		try {

			pageNo = (pageNo == 0) ? 1 : pageNo;
			int pageSize = 10;

			if (op.equals(SEARCH)) {
				pageNo = 1;

			}

			if (op.equals(NEXT)) {

				pageNo++;
			}

			if (op.equals(PREVIOUS)) {

				pageNo--;
			}

			List<LoginBean> list = model.search(bean, pageNo, pageSize);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			req.setAttribute("list", list);
			req.setAttribute("page", pageNo);
			rd.forward(req, resp);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
