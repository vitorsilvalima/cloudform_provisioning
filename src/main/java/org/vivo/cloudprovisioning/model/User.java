package org.vivo.cloudprovisioning.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User
{
	String name;
	String login;
	String pwd;
	String group;
	public User()
	{
	}
	public User(String name, String login, String pwd, String group) {
		super();
		this.name = name;
		this.login = login;
		this.pwd = pwd;
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
}
