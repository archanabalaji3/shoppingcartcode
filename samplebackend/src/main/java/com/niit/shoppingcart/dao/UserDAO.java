package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.User;

public interface UserDAO {
	
		public boolean save(User user);                         //create new user
		public boolean update(User user);                       //update existing user
		public User get(String emailID);                        // get the user details
		public boolean delete(String emailID);                  //delete the user details
		public List<User> list();                               //get all user details
		public User validate(String emailID, String password);  //validate user with emailID and password
		
}
