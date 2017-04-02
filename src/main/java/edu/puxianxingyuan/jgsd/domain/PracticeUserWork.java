package edu.puxianxingyuan.jgsd.domain;

import javax.persistence.*;
import java.io.Serializable;

/**  定课模板表，每次系统依据该表中的每一条记录生成Record表中的每一条定课(未上报)记录
 * 建议插入生成使用存储过程实现
 * Created by 周炜 on 2017/4/2.
 */
@Entity
public class PracticeUserWork {
    @Embeddable
    public static class Id implements Serializable {
        @Column(name="userId")
        protected Integer userId;

        @Column(name="practiceId")
        protected Integer practiceId;

        @Column(name="workId")
        protected Integer workId;

        public Id(){}

        public Id(Integer userId, Integer practiceId, Integer workId){
            this.userId = userId;
            this.practiceId = practiceId;
            this.workId = workId;
        }

        public boolean equals(Object o){
            if(o!=null && o instanceof Id){
                Id that = (Id) o;
                return this.userId.equals(that.userId)&&this.practiceId.equals(that.practiceId) && this.workId.equals(that.workId);
            }
            return false;
        }

        public int hashCode(){
            return userId.hashCode() + practiceId.hashCode() + workId.hashCode();
        }

        public Integer getUserId() {
            return userId;
        }

        public Integer getPracticeId() {
            return practiceId;
        }

        public Integer getWorkId() {
            return workId;
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    private Integer practiceType = 1; //功课记录类型，定课为1，非定课为2

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    protected User User;

    @ManyToOne
    @JoinColumn(name="practiceId",insertable = false, updatable = false)
    protected Practice practice;

	@ManyToOne
    @JoinColumn(name="workId",insertable = false, updatable = false)
    protected Work work;

    public PracticeUserWork(){}

    public PracticeUserWork(User User, Practice practice, Work work){
        this.User =  User;
        this.practice = practice;
        this.work = work;

        this.id.userId = User.getUserId();
        this.id.practiceId = practice.getId();
        this.id.workId = work.getId();
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public edu.puxianxingyuan.jgsd.domain.User getUser() {
        return User;
    }

    public void setUser(edu.puxianxingyuan.jgsd.domain.User user) {
        User = user;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public Integer getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(Integer practiceType) {
        this.practiceType = practiceType;
    }
}
