package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		 
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT * FROM Department WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()){
				
				Department department = iniciateDepartment(rs);
				return department;
			}
			
			return null;
			
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}
		finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Department iniciateDepartment(ResultSet rs) throws SQLException {

		Department department = new Department();
		department.setId(rs.getInt("Id"));
		department.setName(rs.getString("Name"));
		
		return department;
	}

	@Override
	public List<Department> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT * FROM Department ORDER BY Id");
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Department department = iniciateDepartment(rs);
				list.add(department);
			}
			
			return list;
			
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
		}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

}
