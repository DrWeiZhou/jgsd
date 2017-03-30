package edu.puxianxingyuan.jgsd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 周炜 on 2017/3/30.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer userId;

    private String userName;
    private String password;

    private String realName;

    private Integer recordType;

    private Integer dailyJgsdXZ;
    private Integer dailyJgsdBZM;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getDailyJgsdXZ() {
        return dailyJgsdXZ;
    }

    public void setDailyJgsdXZ(Integer dailyJgsdXZ) {
        this.dailyJgsdXZ = dailyJgsdXZ;
    }

    public Integer getDailyJgsdBZM() {
        return dailyJgsdBZM;
    }

    public void setDailyJgsdBZM(Integer dailyJgsdBZM) {
        this.dailyJgsdBZM = dailyJgsdBZM;
    }
}
