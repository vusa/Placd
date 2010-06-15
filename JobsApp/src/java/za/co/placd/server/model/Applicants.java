package za.co.placd.server.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "applicants")
public class Applicants implements Serializable {

    @Id
    private Integer appUser;
    private String name;
    private String surname;
    private String summary;
    private String cvPath;
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date lastUpdate;
    private int expectedMinimunSalary;
    private boolean showContactDetails;
    private String tags;

    /**
     * @return the appUser
     */
    public Integer getAppUser() {
        return appUser;
    }

    /**
     * @param appUser the appUser to set
     */
    public void setAppUser(Integer appUser) {
        this.appUser = appUser;
    }

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
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the cvPath
     */
    public String getCvPath() {
        return cvPath;
    }

    /**
     * @param cvPath the cvPath to set
     */
    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    /**
     * @return the lastUpdate
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the expectedMinimunSalary
     */
    public int getExpectedMinimunSalary() {
        return expectedMinimunSalary;
    }

    /**
     * @param expectedMinimunSalary the expectedMinimunSalary to set
     */
    public void setExpectedMinimunSalary(int expectedMinimunSalary) {
        this.expectedMinimunSalary = expectedMinimunSalary;
    }

    /**
     * @return the showContactDetails
     */
    public boolean isShowContactDetails() {
        return showContactDetails;
    }

    /**
     * @param showContactDetails the showContactDetails to set
     */
    public void setShowContactDetails(boolean showContactDetails) {
        this.showContactDetails = showContactDetails;
    }

    /**
     * @return the tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String tags) {
        this.tags = tags;
    }
}
