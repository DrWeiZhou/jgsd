package edu.puxianxingyuan.jgsd.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

/** 代表发起某次共修的团体组织
 * Created by 周炜 on 2017/4/2.
 */
@Entity
public class Organization {

    private Integer id;

    private String orgName;

    private String orgDescription;

    @OneToOne
    @JoinColumn(name = "adminId", referencedColumnName = "id")
    private Administrator administrator; //管理员

    @OneToMany(mappedBy = "organization")
    private Set<Practice> orgPractices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Set<Practice> getOrgPractices() {
        return orgPractices;
    }

    public void setOrgPractices(Set<Practice> orgPractices) {
        this.orgPractices = orgPractices;
    }
}
