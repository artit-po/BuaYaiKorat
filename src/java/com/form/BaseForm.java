/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form;

import com.bean.UserBean;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.chain.contexts.ServletActionContext;



/**
 *
 * @author kohun_000
 */
public class BaseForm extends org.apache.struts.action.ActionForm {
    
    private String todo;    
    private String msgError;
    private String msgInfo;
    private String msgSuccess;
    private String msgWarning;
    private UserBean userSession;

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public String getMsgSuccess() {
        return msgSuccess;
    }

    public void setMsgSuccess(String msgSuccess) {
        this.msgSuccess = msgSuccess;
    }

    public String getMsgWarning() {
        return msgWarning;
    }

    public void setMsgWarning(String msgWarning) {
        this.msgWarning = msgWarning;
    }
    
    public UserBean getUserSession( ){       
        return userSession;
    }
    
     public void setUserSession(HttpServletRequest request) {
         UserBean userBean = (UserBean)request.getSession().getAttribute("userLogin");
        if(userBean != null){
            this.userSession = userBean;
        }else{        
        this.userSession = null;
        }
    }
    
}
