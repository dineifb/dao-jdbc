package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
		
		System.out.println("----- TEST 1: seller findById -----");
		Department department = departmentDao.findById(4);
		System.out.println(department);
		System.out.println();
		
		System.out.println("----- TEST 3: seller findAll -----");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		System.out.println();
		
		
		sc.close();
	}

}
