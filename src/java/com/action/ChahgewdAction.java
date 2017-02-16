/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.bean.UserBean;
import com.dao.UserDao;
import com.form.chahgewdForm;
import com.util.MessageUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author brass
 */
public class ChahgewdAction extends DispatchAction {

 
 
public ActionForward gotoPageChangePassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("gotoPageChangePassword");
    }



public ActionForward gotoPageChangeComp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
   
        String fwdSuccess = "";

        chahgewdForm changPwdForm = (chahgewdForm) form;
        UserDao userDao = new UserDao();

        UserBean userBean = (UserBean) request.getSession().getAttribute("userLogin");

        if (changPwdForm.getNewpassword()  == null || changPwdForm.getConfpassword().equals("")
                || changPwdForm.getConfpassword()== null || changPwdForm.getConfpassword().equals("")) {

            request.setAttribute("msgLoginFail", MessageUtil.messageError("Fail Input Value", "Please Input New Password & Confirm New Password."));

            HttpSession session = request.getSession();
            session.removeAttribute("msgLoginSuccess");

            fwdSuccess = "gotoPageChangePassword";

        } else if (!changPwdForm.getNewpassword().equals(changPwdForm.getNewpassword())
                && changPwdForm.getNewpassword()!= null && changPwdForm.getNewpassword()!= null) {

            request.setAttribute("msgLoginFail", MessageUtil.messageError("Fail Change Password", "New Password or Confirm Password Incorrect.Please try again."));

            HttpSession session = request.getSession();
            session.removeAttribute("msgLoginSuccess");

            fwdSuccess = "gotoPageChangePassword";
        } else {
            System.out.println("else equals  : " + userBean.getUser_id());

            userBean.setPassword(changPwdForm.getNewpassword());
            userBean.setUpdateby(userBean.getUsername());
            userBean.setUser_id(userBean.getUser_id());

            userDao.updatePwdByID(userBean);
            request.getSession().setAttribute("userLogin", userBean);
            request.setAttribute("msgLoginSuccess", MessageUtil.messageSuccess("Success Change Password", "Change Password is Success"));

            HttpSession session = request.getSession();
            session.removeAttribute("msgLoginFail");

            fwdSuccess = "gotoPageChangePassword";
        }
        return mapping.findForward(fwdSuccess);
    }
}
