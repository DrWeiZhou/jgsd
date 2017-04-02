package edu.puxianxingyuan.jgsd.domain;

import edu.puxianxingyuan.jgsd.util.DateUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 周炜 on 2017/3/31.
 */
@Entity
public class GeneratedRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne
            @JoinColumn(name = "practiceId",columnDefinition = "id")
    Practice practice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime = DateUtil.changeLocale(new Date());

    @Temporal(TemporalType.DATE)
    private Date theDate = DateUtil.getYesterDate(DateUtil.changeLocale(new Date())); //代表是哪一天的修行记录


}
