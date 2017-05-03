package com.elvis.office.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminPagesInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> map = invocation.getInvocationContext().getSession();
		ServletActionContext.getRequest().setAttribute("msg", "您的身份有误，请重新登录");
		ServletActionContext.getRequest().setAttribute("url", "/login.jsp");
		if (map.get("admin") == null) {
			return "forward.page";
		} else {
			return invocation.invoke();
		}
	}

}
