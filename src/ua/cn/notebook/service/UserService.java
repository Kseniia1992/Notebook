package ua.cn.notebook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.cn.notebook.connection.ConnectionDB;
import ua.cn.notebook.domain.Users;

/**
 * UserService class implements CRUD methods 
 * and methods of data selection.
 * @author Kseniia
 *
 */
public class UserService {
	
	/**
	 * Object for connection to data base
	 */	
	private Connection conn;

    /**
     * Constructor performs a database connection
     */
	public UserService() {
        conn = ConnectionDB.getConnection();
    }

	/**
	 * Adding new object to data base
	 * @param user object for adding
	 */
	public void addUser(Users user) {
		try {
            String sql = "INSERT INTO users(id, secondName, firstName, age, gender, phone)" +
            " VALUES (?, ?, ?, ?, ?, ? )"; 
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt(1, user.getId());
            ps.setString(2, user.getSecondName());
            ps.setString(3, user.getFirstName());    
            ps.setInt(4, user.getAge()); 
            ps.setString(5, user.getGender());
            ps.setString(6, user.getPhone());
            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Remove object from data base
	 * @param Id 
	 */
	public void removeUser(int Id) {
		 try {
             String sql = "DELETE FROM users WHERE id=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, Id);
             ps.executeUpdate();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	}

	/**
	 * Update object in data base
	 * @param user - object for updating
	 */
	public void editUser(Users user) {
		 try {
             String sql = "UPDATE users SET secondName=?, firstName=?, age=?, gender=?, phone=?" +
         " WHERE id=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, user.getSecondName());
             ps.setString(2, user.getFirstName());     
             ps.setInt(3, user.getAge());
             ps.setString(4, user.getGender());
             ps.setString(5, user.getPhone());
             ps.setInt(6, user.getId());
             ps.executeUpdate();       
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	}

	/**
	 * Selection of all objects from table
	 * @return users - list of all objects
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllUsers() {
		List users = new ArrayList();
        try {
                String sql = "SELECT * FROM users";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	Users user = new Users();
                	user.setId(rs.getInt("id"));
                	user.setSecondName(rs.getString("secondName"));
                	user.setFirstName(rs.getString("firstName"));
                	user.setAge(rs.getInt("age"));
                	user.setGender(rs.getString("gender"));
                	user.setPhone(rs.getString("phone"));
                	users.add(user);     
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return users;
	}

	/**
	 * Selection of users from data base by id 
	 * for determination of alloted object {@link#search.jsp}
	 * @param id 
	 * @return user - Users object
	 */
	 public Users getObjectById(int id) {
	       Users user = new Users();
	        try {
	                String sql = "SELECT * FROM users WHERE id=?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1, id);
	                ResultSet rs = ps.executeQuery();
	                if (rs.next()) {
	                	user.setId(rs.getInt("id"));
	                	user.setSecondName(rs.getString("secondName"));
	                	user.setFirstName(rs.getString("firstName"));
	                	user.setAge(rs.getInt("age"));
	                	user.setGender(rs.getString("gender"));
	                	user.setPhone(rs.getString("phone"));                           
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	}
	
	/**
	 * Selection of users from data base by id 
	 * @param id 
	 * @return users - list of users
	 */
	public List<Users> getUsersById(int id) {
		List<Users> users = new ArrayList<Users>();
	        try {
	                String sql = "SELECT * FROM users WHERE id=?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1, id);
	                ResultSet rs = ps.executeQuery();
	                while (rs.next()) {
	                	Users user = new Users();
	                	user.setId(rs.getInt("id"));
	                	user.setSecondName(rs.getString("secondName"));
	                	user.setFirstName(rs.getString("firstName"));
	                	user.setAge(rs.getInt("age"));
	                	user.setGender(rs.getString("gender"));
	                	user.setPhone(rs.getString("phone"));
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return users;
	}
	
	/**
	 * Selection of users from data base by surname
	 * @param secondName 
	 * @return users - list of users
	 */
	public List<Users> getUsersBySecondName(String secondName) {
		List<Users> users = new ArrayList<Users>();
        try {
                String sql = "SELECT * FROM users WHERE secondname LIKE ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+secondName+"%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	Users user = new Users();
                	user.setId(rs.getInt("id"));
                	user.setSecondName(rs.getString("secondName"));
                	user.setFirstName(rs.getString("firstName"));
                	user.setAge(rs.getInt("age"));
                	user.setGender(rs.getString("gender"));
                	user.setPhone(rs.getString("phone"));
                	users.add(user);     
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return users;
	}
	
	/**
	 * Selection of users from data base by name
	 * @param firstName 
	 * @return users - list of users
	 */
	public List<Users> getUsersByFirstName(String firstName) {
		List<Users> users = new ArrayList<Users>();
	        try {
	                String sql = "SELECT * FROM users WHERE firstName LIKE ?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, "%"+firstName+"%");
	                ResultSet rs = ps.executeQuery();
	                while (rs.next()) {
	                	Users user = new Users();
	                	user.setId(rs.getInt("id"));
	                	user.setSecondName(rs.getString("secondName"));
	                	user.setFirstName(rs.getString("firstName"));
	                	user.setAge(rs.getInt("age"));
	                	user.setGender(rs.getString("gender"));
	                	user.setPhone(rs.getString("phone"));
	                	users.add(user);
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return users;
	}

	/**
	 * Selection of users from data base by age
	 * @param age 
	 * @return users - list
	 */
	public List<Users> getUsersByAge(int age) {
		 List<Users> users = new ArrayList<Users>();
	        try {
	                String sql = "SELECT * FROM users WHERE age=?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1, age);
	                ResultSet rs = ps.executeQuery();
	                while (rs.next()) {
	                	Users user = new Users();
	                	user.setId(rs.getInt("id"));
	                	user.setSecondName(rs.getString("secondName"));
	                	user.setFirstName(rs.getString("firstName"));
	                	user.setAge(rs.getInt("age"));
	                	user.setGender(rs.getString("gender"));
	                	user.setPhone(rs.getString("phone"));
	                	users.add(user);
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return users;
	}

	/**
	 * Selection of users from data base by gender
	 * @param gender 
	 * @return users - list
	 */
	public List<Users> getUsersByGender(String gender) {
		 List<Users> users = new ArrayList<Users>();
	        try {
	                String sql = "SELECT * FROM users WHERE gender=?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, gender);
	                ResultSet rs = ps.executeQuery();
	                while (rs.next()) {
	                	Users user = new Users();
	                	user.setId(rs.getInt("id"));
	                	user.setSecondName(rs.getString("secondName"));
	                	user.setFirstName(rs.getString("firstName"));
	                	user.setAge(rs.getInt("age"));
	                	user.setGender(rs.getString("gender"));
	                	user.setPhone(rs.getString("phone"));
	                	users.add(user);
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return users;
	}

	/**
	 * Selection of users from data base by
	 * @param phone 
	 * @return users 
	 */
	public List<Users> getUsersByPhone(String phone) {
		 List<Users> users = new ArrayList<Users>();
	        try {
	                String sql = "SELECT * FROM users WHERE phone LIKE ?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, "%"+phone+"%");
	                ResultSet rs = ps.executeQuery();
	                while (rs.next()) {
	                	Users user = new Users();
	                	user.setId(rs.getInt("id"));
	                	user.setSecondName(rs.getString("secondName"));
	                	user.setFirstName(rs.getString("firstName"));
	                	user.setAge(rs.getInt("age"));
	                	user.setGender(rs.getString("gender"));
	                	user.setPhone(rs.getString("phone"));
	                	users.add(user);
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return users;
	}
}
