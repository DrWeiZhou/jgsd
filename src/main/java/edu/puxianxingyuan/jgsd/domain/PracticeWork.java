package edu.puxianxingyuan.jgsd.domain;

import javax.persistence.*;
import java.io.Serializable;

/**  共修信息表，记录共修中每门功课的目标数量等信息
 * Created by 周炜 on 2017/4/2.
 */
@Entity
public class PracticeWork {
    @Embeddable
    public static class Id implements Serializable {

        @Column(name="practiceId")
        protected Integer practiceId;

        @Column(name="workId")
        protected Integer workId;

        public Id(){}

        public Id(Integer practiceId, Integer workId){
            this.practiceId = practiceId;
            this.workId = workId;
        }

        public boolean equals(Object o){
            if(o!=null && o instanceof PracticeUserWork.Id){
                PracticeUserWork.Id that = (PracticeUserWork.Id) o;
                return this.practiceId.equals(that.practiceId) && this.workId.equals(that.workId);
            }
            return false;
        }

        public int hashCode(){
            return practiceId.hashCode() + workId.hashCode();
        }

        public Integer getPracticeId() {
            return practiceId;
        }

        public Integer getWorkId() {
            return workId;
        }
    }

    @EmbeddedId
    protected PracticeUserWork.Id id = new PracticeUserWork.Id();

    private Integer targetNum = SystemBasics.DEFAULT_WORK_TARGET; //某次共修中的某功课的目标

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    protected User User;

    @ManyToOne
    @JoinColumn(name="practiceId",insertable = false, updatable = false)
    protected Practice practice;

    @ManyToOne
    @JoinColumn(name="workId",insertable = false, updatable = false)
    protected Work work;

    public PracticeWork(){}

    public PracticeWork(Practice practice, Work work){
        this.practice = practice;
        this.work = work;

        this.id.practiceId = practice.getId();
        this.id.workId = work.getId();
    }

}
