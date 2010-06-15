package za.co.placd.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qualifications")
public class Qualifications implements Serializable {

    @Id
    private Long id;
    @ManyToOne
    private Applicants applicant;
    private String text;
    private int rank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    public Applicants getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicants applicant) {
        this.applicant = applicant;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
}
