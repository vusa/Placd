package za.co.placd.server.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "messages")
public class Messages {

    @Id
    private Long id;
    @ManyToOne
    private AppUsers toUser;
    @ManyToOne
    private AppUsers fromUser;
    private String subject;
    private Long inReplyTo;
    private String message;
    private boolean opened;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timeSent;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the inReplyTo
     */
    public Long getInReplyTo() {
        return inReplyTo;
    }

    /**
     * @param inReplyTo the inReplyTo to set
     */
    public void setInReplyTo(Long inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    /**
     * @return the timeSent
     */
    public Date getTimeSent() {
        return timeSent;
    }

    /**
     * @param timeSent the timeSent to set
     */
    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    /**
     * @return the toUser
     */
    public AppUsers getToUser() {
        return toUser;
    }

    /**
     * @param toUser the toUser to set
     */
    public void setToUser(AppUsers toUser) {
        this.toUser = toUser;
    }

    /**
     * @return the fromUser
     */
    public AppUsers getFromUser() {
        return fromUser;
    }

    /**
     * @param fromUser the fromUser to set
     */
    public void setFromUser(AppUsers fromUser) {
        this.fromUser = fromUser;
    }
}
