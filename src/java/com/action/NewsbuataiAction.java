/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.bean.NewsBean;
import com.bean.UserBean;
import com.dao.NewsDao;
import com.dao.UserDao;
import com.form.NewsForm;
import com.util.FileUploadUtil;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author brass
 */
public class NewsbuataiAction extends DispatchAction {

  //เพิ่มข่าว
     public ActionForward insertnews(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         NewsForm newsform = (NewsForm)form;
         NewsDao dao = new NewsDao();
         NewsBean bean = new NewsBean();
         String msg = null;
         UserBean userbean = new UserBean();
         UserDao userdao = new UserDao();
         userbean =  (UserBean) request.getSession().getAttribute("userLogin");
         bean.setType_N(newsform.getType_N());
         bean.setName_N(newsform.getName_N());
         bean.setTime_N(newsform.getTime_N());
         bean.setCreatby(userbean.getFname());
         FileUploadUtil upload = new FileUploadUtil();
         FileOutputStream outputStream = null;
        FormFile file = null;
        String file1 = newsform.getFile_N().getFileName();
        if (file1.equals("")) {
            bean.setFile_N("ไม่มีไฟล์");
        } else {
            bean.setFile_N(upload.upload(newsform.getFile_N()));
        }
        try {
            dao.insert(bean);
            System.out.println("สำเร็จ");
            msg = "ok";
        } catch (Exception ex) {
            System.out.println("ลงทะเบียนไม่สำเร็จ");
            ex.printStackTrace();
            msg = "no";
        }
        request.getSession().setAttribute("msg", msg);
        return mapping.findForward("gotoinsertnews");
    }
    
  //เพิ่มข่าว
     public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         NewsForm newsform = (NewsForm)form;
         NewsDao dao = new NewsDao();
         NewsBean bean = new NewsBean();
         String msg = null;
         
        try {
            dao.deletebyID(newsform.getNews_id());
            System.out.println("สำเร็จ");
            msg = "ok";
        } catch (Exception ex) {
            System.out.println("ลงทะเบียนไม่สำเร็จ");
            ex.printStackTrace();
            msg = "no";
        }
         ArrayList<NewsBean> listbean = new ArrayList<NewsBean>();
        listbean = dao.selectAll();
        request.getSession().setAttribute("listnews", listbean);
         request.getSession().setAttribute("msg", msg);
        return mapping.findForward("todomanagementNews");
       
    }
}
