package com.wutian.spring.spring_rent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room{
    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="ROOM_NAME")
    private String name;
    @Column(name="ROOM_NUMBER")
    private String number;
    @Column(name="BED_INFO")
    private String bedInfo;

    public long getId(){
        return this.id;
    }

    public void setId(final long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(final String name){
        this.name=name;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(final String number){
        this.number = number;
    }

    public String getBedInfo(){
        return this.bedInfo;
    }

    public void setBedInfo(final String bedInfo){
        this.bedInfo = bedInfo;
    }
}