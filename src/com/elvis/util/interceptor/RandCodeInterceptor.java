package com.elvis.util.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RandCodeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String rand = (String) invocation.getInvocationContext().getSession().get("rand");
		String code = ServletActionContext.getRequest().getParameter("code");
		if(code!=null){
			if(code.equalsIgnoreCase(rand)){
				return invocation.invoke();
			}else{
				ServletActionContext.getRequest().setAttribute("msg", "验证码输入错误！");
				ServletActionContext.getRequest().setAttribute("url", "/login.jsp");
			}
		}else{
			ServletActionContext.getRequest().setAttribute("msg", "验证码不能为空！");
			ServletActionContext.getRequest().setAttribute("url", "/login.jsp");
		}
		return "forward.page";
	}

}
