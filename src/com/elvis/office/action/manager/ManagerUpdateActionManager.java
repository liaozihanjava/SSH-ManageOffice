package com.elvis.office.action.manager;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Repository;

import com.elvis.office.pojo.User;
import com.elvis.office.service.common.UserServiceCommon;
import com.elvis.util.MD5Code;
import com.elvis.util.action.AbstractAction;

@Repository
@InterceptorRef("managerStack")
@ParentPackage("root")
@Namespace("/pages/jsp/manager/manager")
@Results(value = {
		@Result(name = "updatePasswordVF", location = "/pages/jsp/manager/manager/manager_password_edit.jsp"),
		@Result(name = "manager.updatePre", location = "/pages/jsp/manager/manager/manager_manager_update.jsp")})
@Action("ManagerUpdateAction")
public class ManagerUpdateActionManager extends AbstractAction {

	private static String updatePasswordRule = "newpassword:string|oldpassword:string";
	@Resource
	private UserServiceCommon userService;
	private String newpassword;
	private String oldpassword;
	private File photo;
	private String photoContentType;
	private User user = new User();

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public User getUser() {
		return user;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String updatePassword() {
		User user = (User) super.getSession().getAttribute("manager");
		try {
			if (this.userService.updatePassword(user.getUserid(), new MD5Code().getMD5ofStr(this.oldpassword),
					new MD5Code().getMD5ofStr(this.newpassword))) {
				super.setMsgAndUrl("user.passwordupdate.success", "login.page");
			} else {
				super.setMsgAndUrl("user.passwordupdate.failure", "login.page");
			}
			super.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward.page";
	}

	public String updatePre() {
		User user = (User) super.getSession().getAttribute("manager");
		try {
			super.getRequest().setAttribute("user", this.userService.updatePre(user.getUserid()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manager.updatePre";
	}

	public String update() {
		User user = (User) super.getSession().getAttribute("manager");
		this.user.setUserid(user.getUserid());
		if (this.photo != null) {
			if (this.photo.length() > 0) {
				if ("nophoto.jpg".equals(this.user.getPhoto())) {
					this.user.setPhoto(super.createSingleFileName(this.photoContentType));
				}
			}
		}
		try {
			if (this.userService.update(this.user)) {
				if (this.photo != null && this.photo.length() > 0) {
					String filePath = super.getApplication().getRealPath("/upload/user/") + this.user.getPhoto();
					if (super.saveSingleFile(filePath, this.photo)) {
						user.setPhoto(this.user.getPhoto());
						super.getSession().setAttribute("admin", user);
					}
				}
				super.setMsgAndUrl("update.success.msg", "admin.user.update.action");
			} else {
				super.setMsgAndUrl("update.failure.msg", "admin.user.update.action");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward.page";
	}

	@Override
	public String getTypeName() {
		return "项目经理";
	}

}
