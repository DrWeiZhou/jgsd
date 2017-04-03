package edu.puxianxingyuan.jgsd.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

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

    @Column(nullable=false,columnDefinition="INT default 0")
    private Integer dailyJgsdXZ = 0;
    @Column(nullable=false,columnDefinition="INT default 0")
    private Integer dailyJgsdBZM = 0;

    @OneToMany(targetEntity = Record.class, mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Record> jgsdRecords;

    public Set<Record> getJgsdRecords() {
        return jgsdRecords;
    }

    public void setJgsdRecords(Set<Record> jgsdRecords) {
        this.jgsdRecords = jgsdRecords;
    }

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
