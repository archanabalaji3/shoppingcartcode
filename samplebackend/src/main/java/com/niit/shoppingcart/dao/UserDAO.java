package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.User;

public interface UserDAO {

    public boolean save(User user);							//create new user
	public boolean update(User user);						//update the existing user
	public User get(String emailId);						//get the user details
	public boolean delete(String emailId);					//delete the user
	public List<User> list();								//gets all the users
    public User validate(String emailId, String password);  //Validate whether the credentials correct or not
	
}
