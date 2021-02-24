/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myadressbookapp.service;

import java.util.Vector;
import myadressbookapp.model.Contact;

/**
 *
 * @author kapil.rawal
 */
public interface ContactService {
    
    public Vector<Vector> getAllContacts(int uid);
    public void saveNewContact(Contact c);
    public void deleteContact(Integer cid);
    public Vector<Vector> search(String key, int userId);
}
