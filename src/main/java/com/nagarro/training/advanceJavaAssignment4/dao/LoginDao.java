package com.nagarro.training.advanceJavaAssignment4.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagarro.training.advanceJavaAssignment4.controller.TshirtCsvFileReader;
import com.nagarro.training.advanceJavaAssignment4.model.LoginModel;

public class LoginDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public boolean validator(LoginModel login) {

		try {

			Session session = sf.openSession();
			LoginModel lgDb = (LoginModel) session.load(LoginModel.class, login.getUsername());

			if (lgDb != null && lgDb.getPassword().equals(login.getPassword())) {
				System.out.println(lgDb.getUsername()+" logged in");
				session.close();
				return true;
			} else {
				System.out.println(login.getUsername()+"  "+lgDb.getUsername());
				session.close();
				return false;
			}
			

		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
		


	}
}
