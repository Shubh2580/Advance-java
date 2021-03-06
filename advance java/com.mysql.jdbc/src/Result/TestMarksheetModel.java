package Result;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		 testUpdate();
		// testDelete();
		// testGet();
		// testSearch();
		// testGetMeritList();

	}

	private static void testGetMeritList() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List<MarksheetBean> list = model.getMeritList();
		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollNo());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname());
			System.out.print("\t" + mb.getPhy());
			System.out.print("\t" + mb.getChem());
			System.out.println("\t" + mb.getMaths());
		}

	}

	private static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List<MarksheetBean> list = model.search();
		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollNo());
			System.out.print("\t" + mb.getFname());
			System.out.print(" " + mb.getLname());
			System.out.print("\t" + mb.getPhy());
			System.out.print("\t" + mb.getChem());
			System.out.println("\t" + mb.getMaths());

		}

	}

	private static void testGet() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo(111);

		MarksheetModel model = new MarksheetModel();
		List<MarksheetBean> list = model.get(bean);
		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollNo());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname());
			System.out.print("\t" + mb.getPhy());
			System.out.print("\t" + mb.getChem());
			System.out.println("\t" + mb.getMaths());

		}

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo(111);
		bean.setFname("Nirmal");
		bean.setLname("Sharma");
		bean.setPhy(71);
		bean.setChem(63);
		bean.setMaths(85);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		
        bean.setId(15);
		bean.setFname("Shakti");
		bean.setLname("Kapoor");
		bean.setPhy(78);
		bean.setChem(87);
		bean.setMaths(67);
		bean.setRollNo(109);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo(107);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

	}
}
