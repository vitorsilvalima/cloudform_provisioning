package org.vivo.cloudprovisioning.factory;

import java.util.ArrayList;
import java.util.List;

import org.vivo.cloudprovisioning.model.User;
public class UserFactory 
{
	private List<User> users;
	public UserFactory()
	{
		users = new ArrayList<User>();
    	users.add(new User("Vitor","vlima","Windows8-19","user"));
    	users.add(new User("Jose","jose","Windows8-19","user"));    
    	users.add(new User("Wilson","wilson","Windows8-19","user"));    
    	users.add(new User("Diego","diego","Windows8-19","user"));    
	}
	public List<User> getList()
	{
		return users;
	}
	public List<User> getUserByName(String login)
	{
		List<User>uLogins = new ArrayList<>();
		for (User u : users)
		{
			if(u.getLogin().equals(login))
			{
				uLogins.add(u);
			}
		}
		return uLogins;
	}
}
