/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.NewsBean;
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
public class NewsDao {
    
    public void insert(NewsBean newsBean) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection con = null;
        con = dbConnect.openNewConnection();
        String sql = "insert into tbl_news values(?,?,?,?,?,?)";
        PreparedStatement p = null;
        int i = 0;
        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, 0);
            p.setString(2, newsBean.getType_N());
            p.setString(3, newsBean.getName_N());
            p.setString(4, newsBean.getFile_N());
            p.setString(5, newsBean.getTime_N());
            p.setString(6, newsBean.getCreatby());
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

    public void deletebyID(int news_id) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection con = null;
        con = dbConnect.openNewConnection();
        String sql = "delete from tbl_news where news_id = ?";
        PreparedStatement p = null;
        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, news_id);
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

    public int update(NewsBean newsBean) throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection c = (Connection) dbConnect.openNewConnection();
        StringBuilder sql = new StringBuilder(50);
        sql.append("update tbl_news set ");
        sql.append("type_N=?, name_N=?, file_N=?, time_N=?, creatby_N=?");
        sql.append("where news=_id=?");
        PreparedStatement p = null;
        int chk = 0;
        try {
            p = (PreparedStatement) c.prepareCall(sql.toString());
            p.setString(1, newsBean.getType_N());
            p.setString(2, newsBean.getName_N());
            p.setString(3, newsBean.getFile_N());
            p.setString(4, newsBean.getTime_N());
            p.setString(5, newsBean.getCreatby());
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


    public ArrayList<NewsBean> selectAll() throws Exception {
        NewsBean newsBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = (Connection) dbConnect.openNewConnection();
        String sql = "select * from tbl_news ";
        PreparedStatement p = null;
        ArrayList<NewsBean> userList = new ArrayList<NewsBean>();

        try {
            p = (PreparedStatement) con.prepareStatement(sql);

            rs = p.executeQuery();

            while (rs.next()) {
                newsBean = new NewsBean();
                newsBean.setNews_id(rs.getInt("news_id"));
                newsBean.setType_N(rs.getString("type_N"));
                newsBean.setName_N(rs.getString("name_N"));
                newsBean.setFile_N(rs.getString("file_N"));
                newsBean.setTime_N(rs.getString("time_N"));
                newsBean.setCreatby(rs.getString("creatby"));
                userList.add(newsBean);
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
    
     
      public NewsBean selectById(int news_id) throws Exception {
        NewsBean newsBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "select * from  tbl_news  where  news_id = ?";
        PreparedStatement p = null;

        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setInt(1, news_id);
            rs = p.executeQuery();

            while (rs.next()) {
                newsBean = new NewsBean();
                newsBean.setNews_id(rs.getInt("news_id"));
                newsBean.setType_N(rs.getString("type_N"));
                newsBean.setName_N(rs.getString("name_N"));
                newsBean.setFile_N(rs.getString("file_N"));
                newsBean.setTime_N(rs.getString("time_N"));
                newsBean.setCreatby(rs.getString("creatby"));
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return newsBean;

    }
    public NewsBean selectBytype1(String type_N) throws Exception {
        NewsBean newsBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "select * from  tbl_news  where  type_N='ข่าวการเมือง'";
        PreparedStatement p = null;

        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, type_N);
            rs = p.executeQuery();

            while (rs.next()) {
                newsBean = new NewsBean();
                newsBean.setNews_id(rs.getInt("news_id"));
                newsBean.setType_N(rs.getString("type_N"));
                newsBean.setName_N(rs.getString("name_N"));
                newsBean.setFile_N(rs.getString("file_N"));
                newsBean.setTime_N(rs.getString("time_N"));
                newsBean.setCreatby(rs.getString("creatby"));
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return newsBean;

    }
    public NewsBean selectBytype2(String type_N) throws Exception {
        NewsBean newsBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "select * from  tbl_news  where  type_N='ข่าวทั่วไป'";
        PreparedStatement p = null;

        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, type_N);
            rs = p.executeQuery();

            while (rs.next()) {
                newsBean = new NewsBean();
                newsBean.setNews_id(rs.getInt("news_id"));
                newsBean.setType_N(rs.getString("type_N"));
                newsBean.setName_N(rs.getString("name_N"));
                newsBean.setFile_N(rs.getString("file_N"));
                newsBean.setTime_N(rs.getString("time_N"));
                newsBean.setCreatby(rs.getString("creatby"));
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return newsBean;

    }
    public NewsBean selectBytype3(String type_N) throws Exception {
        NewsBean newsBean = null;
        ResultSet rs = null;
        DBConnect dbConnect = new DBConnect();
        Connection con = dbConnect.openNewConnection();
        String sql = "select * from  tbl_news  where  type_N='ข่าวกรมขนส่ง'";
        PreparedStatement p = null;

        try {
            p = (PreparedStatement) con.prepareStatement(sql);
            p.setString(1, type_N);
            rs = p.executeQuery();

            while (rs.next()) {
                newsBean = new NewsBean();
                newsBean.setNews_id(rs.getInt("news_id"));
                newsBean.setType_N(rs.getString("type_N"));
                newsBean.setName_N(rs.getString("name_N"));
                newsBean.setFile_N(rs.getString("file_N"));
                newsBean.setTime_N(rs.getString("time_N"));
                newsBean.setCreatby(rs.getString("creatby"));
            }

        } finally {
            try {
                p.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return newsBean;

    }
}
