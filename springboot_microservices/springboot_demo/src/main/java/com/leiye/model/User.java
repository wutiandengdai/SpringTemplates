package com.leiye.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final long id;
    private final String forename;
    private final String surname;
    private final String organisation;
    private final List<String> notifications;
    private final long points;
    //Friends are deprecated and should not be used
    private final List<String> friends;

    /**
     * 根据ID随机生成用户
     * @param id
     */
    public User(int id) {
        String[] forenames = {"Alice", "Manjula", "Bartosz", "Mack"};
        String[] surnames = {"Smith", "Salvatore", "Jedrzejewski", "Scott"};
        String[] organisations = {"网金控股", "网金投资" ,"网金纽约", "网金伦敦"};

        forename = forenames[id%3];
        surname = surnames[id%4];
        organisation = organisations[id%4];
        notifications= new ArrayList<String>();
        notifications.add("恭喜，老板给你加薪了!");
        notifications.add("抱歉, 请忽略上一条信息-- 错误用户");
        points = id * 31 % 1000;

        //You have no friends
        friends = new ArrayList<String>();

        this.id = id;
    }

	public long getId() {
		return id;
	}

	public String getForename() {
		return forename;
	}

	public String getSurname() {
		return surname;
	}

	public String getOrganisation() {
		return organisation;
	}

	public List<String> getNotifications() {
		return notifications;
	}

	public long getPoints() {
		return points;
	}

	public List<String> getFriends() {
		return friends;
	}

}