/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.UserBean;
import com.util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author brass
 */
public class UserDao {

    public void insert(UserBean userBean) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection con = null;
        con = dbConnect.openNewConnection();
        String sql = "insert into tbl_user values(?,?,?,?,?,?,?,?,?,?,sysdate(),?,sysdate()";
        PreparedStatement p = null;
        int i = 0;
        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, 0);
            p.setString(2, userBean.getUsername());
            p.setString(3, userBean.getPassword());
            p.setString(4, userBean.getFname());
            p.setString(5, userBean.getLname());
            p.setString(6, userBean.getPosition());
            p.setInt(7, userBean.getPhone());
            p.setString(8, userBean.getEmail());
            p.setString(9, userBean.getAddress());
            p.setString(10, userBean.getCreatby());
            p.setString(11, userBean.getUpdateby());
            p.executeUpdate();

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletebyuserID(int user_id) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection con = null;
        con = dbConnect.openNewConnection();
        String sql = "delete from tbl_user where user_id = ?";
        PreparedStatement p = null;
        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, user_id);
            p.executeUpdate();
        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int update(UserBean userBean) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection c = (Connection) dbConnect.openNewConnection();
        StringBuilder sql = new StringBuilder(50);
        sql.append("update tbl_user set ");
        sql.append("fname=?, lname=?, position=?, phone=?, email=?, address=?, status=?,updateby=? ,updated=sysdate()");
        sql.append("where user_id=?");
        PreparedStatement p = null;
        int chk = 0;
        try {
            p = (PreparedStatement) c.prepareCall(sql.toString());
            p.setString(1, userBean.getFname());
            p.setString(2, userBean.getLname());
            p.setString(3, userBean.getPosition());
            p.setInt(4, userBean.getPhone());
            p.setString(5, userBean.getEmail());
            p.setString(6, userBean.getAddress());
            p.setString(7, userBean.getStatus());
            p.setString(8, userBean.getUpdateby());
            p.setInt(9, userBean.getUser_id());
            chk = p.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                p.close();
                dbConnect.closeConnection(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(chk);
        }
        return chk;
    }

    public void updatePwdByID(UserBean userBean) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "update tbl_user  set  password=?, updated=sysdate(),updateby=? where user_id=?";

        PreparedStatement p = null;
        int i = 0;
        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(++i, userBean.getPassword());
            p.setString(++i, userBean.getUsername());
            p.setInt(++i, userBean.getUser_id());
            p.executeUpdate();

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<UserBean> selectAll() throws Exception {
        UserBean userBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = (Connection) dbConnect.openNewConnection();
        String sql = "select * from tbl_user";
        PreparedStatement p = null;
        ArrayList<UserBean> userList = new ArrayList<UserBean>();

        try {
            p = (PreparedStatement) con.prepareStatement(sql);

            rs = p.executeQuery();

            while (rs.next()) {
                userBean = new UserBean();
                userBean = new UserBean();
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setUsername(rs.getString("username"));
                userBean.setPassword(rs.getString("password"));
                userBean.setFname(rs.getString("fname"));
                userBean.setLname(rs.getString("lname"));
                userBean.setPosition(rs.getString("position"));
                userBean.setPhone(rs.getInt("phone"));
                userBean.setEmail(rs.getString("email"));
                userBean.setAddress(rs.getString("address"));
                userBean.setStatus(rs.getString("status"));
                userBean.setCreatby(rs.getString("creatby"));
                userBean.setCreated(rs.getString("created"));
                userBean.setUpdateby(rs.getString("updateby"));
                userBean.setUpdated(rs.getString("updated"));
                userList.add(userBean);
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userList;

    }
    
     public UserBean selectByUsernameAndPassword(String username, String password) throws Exception {
        UserBean userBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "select * from  tbl_user  where  username = ? and password = ? and status = '1'";
        PreparedStatement p = null;

        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, password);
            rs = p.executeQuery();

            while (rs.next()) {
                userBean = new UserBean();
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setUsername(rs.getString("username"));
                userBean.setPassword(rs.getString("password"));
                userBean.setFname(rs.getString("fname"));
                userBean.setLname(rs.getString("lname"));
                userBean.setPosition(rs.getString("position"));
                userBean.setPhone(rs.getInt("phone"));
                userBean.setEmail(rs.getString("email"));
                userBean.setAddress(rs.getString("address"));
                userBean.setStatus(rs.getString("status"));
                userBean.setCreatby(rs.getString("creatby"));
                userBean.setCreated(rs.getString("created"));
                userBean.setUpdateby(rs.getString("updateby"));
                userBean.setUpdated(rs.getString("updated"));
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userBean;

    }
     
      public UserBean selectByUserId(int user_id) throws Exception {
        UserBean userBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "select * from  tbl_user  where  user_id = ?";
        PreparedStatement p = null;

        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, user_id);
            rs = p.executeQuery();

            while (rs.next()) {
                userBean = new UserBean();
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setUsername(rs.getString("username"));
                userBean.setPassword(rs.getString("password"));
                userBean.setFname(rs.getString("fname"));
                userBean.setLname(rs.getString("lname"));
                userBean.setPosition(rs.getString("position"));
                userBean.setPhone(rs.getInt("phone"));
                userBean.setEmail(rs.getString("email"));
                userBean.setAddress(rs.getString("address"));
                userBean.setStatus(rs.getString("status"));
                userBean.setCreatby(rs.getString("creatby"));
                userBean.setCreated(rs.getString("created"));
                userBean.setUpdateby(rs.getString("updateby"));
                userBean.setUpdated(rs.getString("updated"));
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userBean;

    }
}
