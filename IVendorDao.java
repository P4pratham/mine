package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	Vendor validateUser(String email,String pass);
	List<Vendor> listVendors();
	String registerVendor(Vendor v);
	String deleteVendor(int id);
}
