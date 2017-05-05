package com.elvis.util.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {
	private Integer cp = 1;
	private Integer ls = 5;
	private String col;
	private String kw;

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public Integer getCp() {
		return cp;
	}

	public Integer getLs() {
		return ls;
	}

	public String getCol() {
		if (this.col == null || "".equals(col)) {
			return this.getDefaultColumn();
		}
		return this.col;
	}

	public String getKw() {
		if (kw == ""||kw==null) {
			return "";
		}
		return kw;
	}

	public void setLs(Integer ls) {
		this.ls = ls;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public String getUrl(String key) {
		return super.getText(key);
	}

	public String getMsg(String key) {
		return super.getText(key, new String[] { this.getTypeName() });
	}

	public abstract String getTypeName();

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return this.getRequest().getSession();
	}

	public ServletContext getApplication() {
		return ServletActionContext.getServletContext();
	}

	public void handleSplit(Object allRecorders, String urlKey, String paramName,
			String paramValue) {
		this.getRequest().setAttribute("currentPage", this.getCp());
		this.getRequest().setAttribute("lineSize", this.getLs());
		this.getRequest().setAttribute("column", this.getCol());
		this.getRequest().setAttribute("keyWord", this.getKw());
		this.getRequest().setAttribute("url", this.getUrl(urlKey));
		this.getRequest().setAttribute("allRecorders", allRecorders);
		this.getRequest().setAttribute("columnData", this.getColumnData());
		this.getRequest().setAttribute("paramName", paramName);
		this.getRequest().setAttribute("paramValue", paramValue);
	} 
	
	public void setMsgAndUrl(String msgKey, String urlKey) {
		this.getRequest().setAttribute("msg", this.getMsg(msgKey));
		this.getRequest().setAttribute("url", this.getUrl(urlKey));
	}

	public void print(Object obj) {
		try {
			this.getResponse().getWriter().print(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String createSingleFileName(String contentType) {
		String fileExt = null;
		if ("image/bmp".equalsIgnoreCase(contentType)) {
			fileExt = "bmp";
		} else if ("image/jpg".equalsIgnoreCase(contentType)) {
			fileExt = "jpg";
		} else if ("image/jpeg".equalsIgnoreCase(contentType)) {
			fileExt = "jpg";
		} else if ("image/gif".equalsIgnoreCase(contentType)) {
			fileExt = "gif";
		} else if ("image/png".equalsIgnoreCase(contentType)) {
			fileExt = "png";
		}
		return UUID.randomUUID().toString() + "." + fileExt;
	}

	public boolean saveSingleFile(String filePath, File file) {
		boolean flag = false;
		File saveFile = new File(filePath);
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		OutputStream output = null;
		InputStream input = null;
		try {
			output = new FileOutputStream(saveFile);
			input = new FileInputStream(file);
			int temp = 0;
			byte[] data = new byte[1024];
			while ((temp = input.read(data)) != -1) {
				output.write(data, 0, temp);
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public abstract String getDefaultColumn();

	public abstract String getColumnData();

}
