package util;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory(String filename) {
		Configuration c = new Configuration().configure(filename);
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
		return c.buildSessionFactory(sr);
	}

	public static Session getSession() {
		return sessionFactory("hibernate.cfg.xml").openSession();
	}
	/* *********************
	 *     OTHER TOOLS
	 * *********************/
	public static boolean doesUsernameExist(String username) {
		Session session = HibernateUtil.getSession();
		String hqlQuery = "from A_USERS where U_USERNAME = :username";
		Query query = session.createQuery(hqlQuery);
		query.setString("username", username);
		ArrayList<String> list = (ArrayList<String>) query.list();
		if(list.size() == 0) {
			return false;
		}
		return true;
	}
}