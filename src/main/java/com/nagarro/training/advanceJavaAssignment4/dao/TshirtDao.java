package com.nagarro.training.advanceJavaAssignment4.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nagarro.training.advanceJavaAssignment4.model.Tshirt;
import com.nagarro.training.advanceJavaAssignment4.model.TshirtSearchIp;

public class TshirtDao {
	private static SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public static void truncateTshirt() {
		Session session = sf.openSession();
		
		session.createSQLQuery("truncate table Tshirt").executeUpdate();

	}

	public static void saveTshirt(Tshirt tshirt) {
		// TODO Auto-generated method stub

		try {

			Session session = sf.openSession();
			session.beginTransaction();
			session.saveOrUpdate(tshirt);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Tshirt> getTshirtlist(TshirtSearchIp inp) {

		Session session = sf.openSession();

		String query = "from Tshirt where color=:color and gender=:gender and size=:size";

		Query q = session.createQuery(query);

		q.setParameter("color", inp.getColor());
		q.setParameter("gender", inp.getGender());
		q.setParameter("size", inp.getSize());

		List<Tshirt> matchedTshirts = q.list();
		
		return matchedTshirts;
	}

}
