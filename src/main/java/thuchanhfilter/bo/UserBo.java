package thuchanhfilter.bo;

import thuchanhfilter.bean.UserBean;
import thuchanhfilter.dao.UserDao;

public class UserBo {
	UserDao userDao = new UserDao();
	public UserBean login(String user, String pass) {
		   return userDao.login(user, pass);
	   }
}
