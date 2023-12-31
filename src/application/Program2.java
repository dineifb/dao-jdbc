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
		
		System.out.println("----- TEST 1: Department findById -----");
		Department department = departmentDao.findById(4);
		System.out.println(department);
		System.out.println();
		
		System.out.println("----- TEST 2: Department findAll -----");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		System.out.println();
		
		
		System.out.println("----- TEST 3: Department insert -----");
		department = new Department(null,"Technical");
		departmentDao.insert(department);
		System.out.println("Inserted ! New id = " + department.getId());
		System.out.println();
		
		System.out.println("----- TEST 4: Department update -----");
		department = departmentDao.findById(2);
		department.setName("Logistic");
		departmentDao.update(department);
		System.out.println("Update completed !");
		System.out.println();
		
		System.out.println("----- TEST 5: Department delete -----");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		System.out.println();
		
		sc.close();
	}

}
