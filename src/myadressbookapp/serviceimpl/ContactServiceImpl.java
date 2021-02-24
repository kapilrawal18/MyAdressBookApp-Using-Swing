/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myadressbookapp.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import myadressbookapp.db.DBUtil;
import myadressbookapp.model.Contact;
import myadressbookapp.service.ContactService;

/**
 *
 * @author kapil.rawal
 */
public class ContactServiceImpl implements ContactService {

    @Override
    public Vector<Vector> getAllContacts(int uid) {
        try {
            String sql = "select contactId,name,email,phoneNo,address,groupType from contact where userId='" + uid + "'";
            ResultSet rs = DBUtil.select(sql);
            Vector<Vector> data = new Vector<Vector>();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(false);
                row.add(rs.getInt("contactId"));
                row.add(rs.getString("name"));
                row.add(rs.getString("phoneNo"));
                row.add(rs.getString("email"));
                row.add(rs.getString("address"));
                row.add(rs.getString("groupType"));
                data.add(row);
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(ContactServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveNewContact(Contact c) {
        String sql = "insert into contact (userId,name,phoneNo,email,address,groupType) values('" + c.getUserId() + "','" + c.getName() + "','" + c.getPhone() + "','" + c.getEmail() + "','" + c.getAddress() + "','" + c.getGroupType() + "')";
        DBUtil.update(sql);
    }

    @Override
    public void deleteContact(Integer cid) {
        String sql = "delete from contact where contactId='" + cid + "'";
        System.out.println(sql);
        DBUtil.update(sql); // DML operation
    }

    @Override
    public Vector<Vector> search(String key, int userId) {
        try {
            String sql = "select contactId,name,phoneNo,email,address,groupType from contact where userId='" + userId + "' and name like ('%" + key + "%')or phoneNo like('%" + key + "%')";
            ResultSet rs = DBUtil.select(sql);
            Vector<Vector> data = new Vector<Vector>();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(false);
                row.add(rs.getInt("contactId"));
                row.add(rs.getString("name"));
                row.add(rs.getString("phoneNo"));
                row.add(rs.getString("email"));
                row.add(rs.getString("address"));
                row.add(rs.getString("groupType"));
                data.add(row);
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(ContactServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
