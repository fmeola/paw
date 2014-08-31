package usermanager;

import model.User;

public interface UserManager {

	public User getUser(String username); 

	public Boolean correctLogin(String username, String password);

}
