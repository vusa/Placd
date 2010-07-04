package za.co.placd.shared.dto;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author vusa
 */
public class GroupsDTO implements Serializable {
    private String name;
    private Set<String> permissions;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the permissions
     */
    public Set<String> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
