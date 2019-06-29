package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;

import java.util.List;

import org.hibernate.*;

@Repository
public class VendorDaoImpl implements IVendorDao {
	// dependency
	@Autowired // byType
	private SessionFactory sf;

	public VendorDaoImpl() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	@Override
	public Vendor validateUser(String email, String pass) {
		String jpql = "select v from Vendor v where v.email=:em and v.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pa", pass)
				.getSingleResult();
	}

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v where v.role=:role";
		return sf.getCurrentSession().
				createQuery(jpql, Vendor.class).
				setParameter("role", "vendor").getResultList();
	}

	@Override
	public String registerVendor(Vendor v) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(v);
		return null;
	}

	@Override
	public String deleteVendor(int id) {
		// TODO deleting vendor by id from btn
		 Vendor v=sf.getCurrentSession().get(Vendor.class,id);
		sf.getCurrentSession().delete(v);
		return null;
	}

}
