package com.elvis.util.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {
public String getUrl(String key){
	return super.getText(key);
}
public String getMsg(String key){
	return super.getText(key, new String[]{this.getTypeName()});
}
public abstract String getTypeName();
public HttpServletRequest getRequest(){
	return ServletActionContext.getRequest();
}
public HttpServletResponse getResponse(){
	return ServletActionContext.getResponse();
}
public HttpSession getSession(){
	return this.getRequest().getSession();
}
public ServletContext getApplication(){
	return ServletActionContext.getServletContext();
}
public void setMsgAndUrl(String msgKey,String urlKey){
	this.getRequest().setAttribute("msg", this.getMsg(msgKey));
	this.getRequest().setAttribute("url", this.getUrl(urlKey));
}
public void print(Object obj){
	try {
		this.getResponse().getWriter().print(obj);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
