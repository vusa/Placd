package za.co.placd.server.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

@Entity
@Table(name = "app_users")
@NamedQueries({
    @NamedQuery(name = "AppUsers.byLoginAndPassword", query = "SELECT a FROM AppUsers a WHERE a.login=:login AND a.password=:password")
})
public class AppUsers implements Serializable {

    @Id
    @TableGenerator(name = "AppUsersTab", table = "id_gen",
    pkColumnName = "id_name", valueColumnName = "id_val",
    pkColumnValue = "appuser", allocationSize = 5)
    @GeneratedValue(generator = "AppUsersTab", strategy = GenerationType.TABLE)
    private Long id;
    private String login;
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "auth_type")
    private AuthType authType;
    private String password;
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date dob;
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date lastLogin;
    private boolean active;

    public AppUsers() {
    }

    public AppUsers(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the authType
     */
    public AuthType getAuthType() {
        return authType;
    }

    /**
     * @param authType the authType to set
     */
    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
