package za.co.placd.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vusa
 */
public class JobsDTO implements Serializable {

    private Long id;
    private Date datePosted;
    private String title;
    private String summary;
    private String description;
    private Integer payRate;
    private String payPeriod;
    private Date dateClosing;
    private Long postedby;

    public JobsDTO() {
    }

    /**
     * @return the datePosted
     */
    public Date getDatePosted() {
        return datePosted;
    }

    /**
     * @param datePosted the datePosted to set
     */
    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPayRate() {
        return payRate;
    }

    public void setPayRate(Integer payRate) {
        this.payRate = payRate;
    }


    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }


    /**
     * @return the dateClosing
     */
    public Date getDateClosing() {
        return dateClosing;
    }

    /**
     * @param dateClosing the dateClosing to set
     */
    public void setDateClosing(Date dateClosing) {
        this.dateClosing = dateClosing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
     * @return the postedby
     */
    public Long getPostedby() {
        return postedby;
    }

    /**
     * @param postedby the postedby to set
     */
    public void setPostedby(Long postedby) {
        this.postedby = postedby;
    }
}
