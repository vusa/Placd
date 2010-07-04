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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author vusa
 */
@Entity
@Table(name="jobs")
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "JobsTab", table = "id_gen",
    pkColumnName = "id_name", valueColumnName = "id_val",
    pkColumnValue = "jobs", allocationSize = 5)
    @GeneratedValue(generator = "JobsTab", strategy = GenerationType.TABLE)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="date_posted")
    private Date datePosted;
    private String title;
    private String summary;
    private String description;
    @Column(name="pay_rate")
    private Integer payRate;
    @Enumerated(EnumType.STRING)
    @Column(name="pay_period")
    private PayPeriod payPeriod;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="date_closing")
    private Date dateClosing;

    public Jobs() {
    }

    public Date getDateClosing() {
        return dateClosing;
    }

    public void setDateClosing(Date dateClosing) {
        this.dateClosing = dateClosing;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPayRate() {
        return payRate;
    }

    public void setPayRate(Integer payRate) {
        this.payRate = payRate;
    }

    public PayPeriod getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(PayPeriod payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Jobs)) {
            return false;
        }
        Jobs other = (Jobs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.placd.server.model.Jobs[id=" + id + "]";
    }
}
