package application;

import java.sql.Connection;
import java.util.Date;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		DB.closeConnection();
		
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		Seller seller = new Seller(21,"Bob","bob@gmail.com",new Date(),3000.0,obj);
		System.out.println(seller);
		
		SellerDao  sellerDao = DaoFactory.createSellerDao();
	}

}
