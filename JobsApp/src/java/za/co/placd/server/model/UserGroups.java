package za.co.placd.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="user_groups")
@NamedQueries({@NamedQuery(name="UserGroups.byLogin", query="SELECT DISTINCT u.userGroup FROM UserGroups u WHERE u.appUser.login = :login")})
public class UserGroups implements Serializable{
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "login")
    private AppUsers appUser;
    @Enumerated(EnumType.STRING)
    private Groups userGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the appUser
     */
    public AppUsers getAppUser() {
        return appUser;
    }

    /**
     * @param appUser the appUser to set
     */
    public void setAppUser(AppUsers appUser) {
        this.appUser = appUser;
    }

    /**
     * @return the userGroup
     */
    public Groups getUserGroup() {
        return userGroup;
    }

    /**
     * @param userGroup the userGroup to set
     */
    public void setUserGroup(Groups userGroup) {
        this.userGroup = userGroup;
    }
}