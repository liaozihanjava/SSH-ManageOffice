package com.elvis.util.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("root")
@Namespace("/")
@Action("CheckCode")
public class CheckCodeAction extends AbstractAction {

	private String code;
	public void setCode(String code) {
		this.code = code;
	}
	
	public void check(){
		String rand = (String) super.getSession().getAttribute("rand");
			/*try {
				ServletActionContext.getResponse().getWriter().print(rand.equalsIgnoreCase(code));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		super.print(rand.equalsIgnoreCase(code));
		
	}
	@Override
	public String getTypeName() {
		return null;
	}

	@Override
	public String getDefaultColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnData() {
		// TODO Auto-generated method stub
		return null;
	}

}
