package thuchanhfilter.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import thuchanhfilter.bean.UserBean;

public class UserDao {
	public UserBean login(String user, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select * from useraccount\r\n"
					+ "where username = ? and password = ?";
			PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, user);
    		cmd.setString(2, pass);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String username = rs.getString("username");
    			String password = rs.getString("password");
    			String role = rs.getString("role");
				return new UserBean(id, username, password, role);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
