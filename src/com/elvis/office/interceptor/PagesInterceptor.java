package com.elvis.office.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PagesInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> map = invocation.getInvocationContext().getSession();
		ServletActionContext.getRequest().setAttribute("msg", "您还未登陆，请先登录");
		ServletActionContext.getRequest().setAttribute("url", "/login.jsp");
		if (map.get("admin") == null) {
			if (map.get("manager") == null) {
				if (map.get("emp") == null) {
					return "forward.page";
				} else {
					return invocation.invoke();
				}
			} else {
				return invocation.invoke();
			}
		} else {
			return invocation.invoke();
		}
	}

}
