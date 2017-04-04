package edu.puxianxingyuan.jgsd.domain;

import edu.puxianxingyuan.jgsd.util.DateUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 周炜 on 2017/3/30.
 */
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime = DateUtil.changeLocale(new Date());

    @Temporal(TemporalType.DATE)
    private Date theDate = DateUtil.getTheDate(DateUtil.changeLocale(new Date())); //代表是哪一天的修行记录

    @Column(nullable=false,columnDefinition="INT default 0")
    private Integer dailyJgsdXZ = 0;
    @Column(nullable=false,columnDefinition="INT default 0")
    private Integer dailyJgsdBZM = 0;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
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
