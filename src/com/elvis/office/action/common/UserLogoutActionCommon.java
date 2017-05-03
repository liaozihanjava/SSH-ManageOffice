package com.elvis.office.action.common;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Repository;

import com.elvis.util.action.AbstractAction;

@Repository
@ParentPackage("root")
@Namespace("/")
@Action("UserLogout")
public class UserLogoutActionCommon extends AbstractAction {
public String logout(){
	super.getSession().invalidate();
	super.setMsgAndUrl("user.logout.msg", "login.page");
	return "forward.page";
}
	
	
	@Override
	public String getTypeName() {
		return null;
	}

}
