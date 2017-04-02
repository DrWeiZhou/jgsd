package edu.puxianxingyuan.jgsd.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/** 代表某次共修
 * Created by 周炜 on 2017/4/2.
 */
@Entity
public class Practice {

    private Integer id;

    private String practiceName;

    private String practiceDescription;

    @ManyToOne
    @JoinColumn(name = "orgId", referencedColumnName = "id")
    private Organization organization;

    private Integer practiceType; //共修类型，1表示由组织生成的共修，2表示系统创建的个人日课
    private Integer workNumber; //实际共修的条目数量

//    private List<Work> practiceWorks = new ArrayList<Work>(); //共修内容，该List的大小应该总是5

//    private List<Integer> workTargets = new ArrayList<Integer>();//共修时每项功课的目标值

    private Integer reportTime; //第二天上报的时间，0为当天午夜12点

    private Boolean open; //共修是否进行中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getPracticeDescription() {
        return practiceDescription;
    }

    public void setPracticeDescription(String practiceDescription) {
        this.practiceDescription = practiceDescription;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(Integer practiceType) {
        this.practiceType = practiceType;
    }

    public Integer getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(Integer workNumber) {
        this.workNumber = workNumber;
    }

    public Integer getReportTime() {
        return reportTime;
    }

    public void setReportTime(Integer reportTime) {
        this.reportTime = reportTime;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
