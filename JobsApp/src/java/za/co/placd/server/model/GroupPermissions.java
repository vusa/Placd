package za.co.placd.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vusa
 */
@Entity
@Table(name="group_permissions")
public class GroupPermissions implements Serializable {

    @Id
    Long id;
    @Enumerated(EnumType.STRING)
    Groups userGroup;
    @Enumerated(EnumType.STRING)
    Permissions permission;

    public GroupPermissions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permissions getPermission() {
        return permission;
    }

    public void setPermission(Permissions permission) {
        this.permission = permission;
    }

    public Groups getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Groups userGroup) {
        this.userGroup = userGroup;
    }
}
