package za.co.placd.server.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="experience")
public class Experience implements Serializable {
    @Id
    private Long id;
    @ManyToOne
    private Applicants applicant;
    private String text;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateStart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Applicants getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicants applicant) {
        this.applicant = applicant;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
