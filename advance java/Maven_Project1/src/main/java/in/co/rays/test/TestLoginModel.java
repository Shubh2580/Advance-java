package in.co.rays.test;



import in.co.rays.bean.LoginBean;
import in.co.rays.model.LoginModel;

public class TestLoginModel {
	public static void main(String[] args) throws Exception {
		testAuthenticate();
	}
	

	
private static void testAuthenticate() throws Exception {
	LoginBean bean = new LoginBean();
	

     bean.setLogin("nishamehta565@gmail.com");
		bean.setPassword("pass123");
		
		LoginModel model = new LoginModel();
		
		
	
		
		LoginBean bean1 = null;
		try {
			bean1 = model.authenticate(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bean1 == null) {
			System.out.println("Invalid User");
		} else {
			System.out.println("Congratulations....!!!");
		}

	}

		
}



