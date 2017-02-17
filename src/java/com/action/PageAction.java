/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.bean.NewsBean;
import com.dao.NewsDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Artit Por
 */
public class PageAction extends DispatchAction {

    private final static String GOTOLOGINADMIN = "gotoLoginAdmin";

    public ActionForward gotoLoginAdmin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(GOTOLOGINADMIN);
    }
//    ไปหน้า  contact.jsp 
  public ActionForward gotoContact(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("gotoContact");
    }
  //    ไปหน้า จัดการข้อมูลลูกค้า 
  public ActionForward todomanagementUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("todomanagementUser");
    }
  //    ไปหน้า  จัดการข้อมูลข่าว
  public ActionForward todomanagementNews(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList<NewsBean> listbean = new ArrayList<NewsBean>();
        NewsDao newsdao = new NewsDao();
        listbean = newsdao.selectAll();
        request.getSession().setAttribute("listnews", listbean);
        return mapping.findForward("todomanagementNews");
    }
    //ไปหน้าเพิ่มข่าว
     public ActionForward gotoinsertnews(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("gotoinsertnews");
    }
     
     
}
