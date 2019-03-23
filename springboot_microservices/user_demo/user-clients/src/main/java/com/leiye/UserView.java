package com.leiye;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 接口仅开放部分属性
 * @author ucs_yelei
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserView {

	private long id;
    private String forename;
    private String surname;
    private String organisation;
    private List<String> notifications;
    private long points;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public List<String> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}
	public long getPoints() {
		return points;
	}
	public void setPoints(long points) {
		this.points = points;
	}
    
}
