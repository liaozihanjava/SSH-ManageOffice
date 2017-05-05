package com.elvis.office.action.admin;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Repository;

import com.elvis.office.service.admin.ActionServiceAdmin;
import com.elvis.util.action.AbstractAction;

@Repository
@InterceptorRef("adminStack")
@ParentPackage("root")
@Namespace("/pages/jsp/admin/role")
@Results(value = { @Result(name = "action.list", location = "/pages/jsp/admin/role/admin_action_list.jsp") })
@Action("ActionActionAdmin")
public class ActionActionAdmin extends AbstractAction {

	private static String updateRule = "action.title:string|action.url:string";
	private com.elvis.office.pojo.Action action = new com.elvis.office.pojo.Action();
	@Resource
	private ActionServiceAdmin actionServiceAdmin;

	public com.elvis.office.pojo.Action getAction() {
		return action;
	}

	public String list() {
		Map<String, Object> map;
		try {
			map = this.actionServiceAdmin.list(super.getCp(), super.getLs(), super.getCol(), super.getKw());
			super.handleSplit(map.get("actionCount"), "admin.action.split.url", null, null);
			super.getRequest().setAttribute("allActions", map.get("allActions"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "action.list";
	}

	public void update() {
		try {
			super.print(this.actionServiceAdmin.update(this.action));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getTypeName() {
		return "权限";
	}

	@Override
	public String getDefaultColumn() {
		return "title";
	}

	@Override
	public String getColumnData() {
		// TODO Auto-generated method stub
		return "权限标题:title|权限路径:url";
	}

}
