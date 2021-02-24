/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myadressbookapp.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myadressbookapp.db.DBUtil;
import myadressbookapp.model.User;
import myadressbookapp.service.UserService;

/**
 *
 * @author kapil.rawal
 */
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(User user) {
        String sql = "INSERT INTO USER (name,email,phoneNo,address,loginName,password)"
                + "VALUES('" + user.getName() + "','" + user.getPhone() + "','" + user.getEmail() + "',"
                + "'" + user.getAddress() + "','" + user.getUserName() + "','" + user.getPassword() + "')";
        System.out.println(sql);
        DBUtil.update(sql);
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User authenticateUser(String userName, String password) throws RuntimeException{
        String sql = "select userId,name from user where loginName='" + userName + "' and password='" + password + "'";
        System.out.println("sql--->" + sql);
        ResultSet rs = DBUtil.select(sql);
        try {
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String uName = rs.getString("name");
                User u = new User();
                u.setUserId(userId);
                u.setUserName(uName);
                return u;
            } else {
                throw new RuntimeException("Please Provide Valid User Name or Password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

