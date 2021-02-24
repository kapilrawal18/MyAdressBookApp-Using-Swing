/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myadressbookapp.service;

import myadressbookapp.model.User;

/**
 *
 * @author kapil.rawal
 */
public interface UserService {
    
    public void registerUser(User user);
    public User authenticateUser(String userName, String password);
}
