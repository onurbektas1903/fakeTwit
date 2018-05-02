package com.fakeTwit.entity;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "SIMPLE_MESSAGE")
// User ile many to many ilişkisi kurarak composition yapabilirdim ama basit tutmak için kullanıcı adı ve mesaj tutuyorum.
 // Kullanıcılar username bazında unique olacaktır.
public class UserMessage extends BaseEntity{
    private String message;
    private String sendBy;
    private Date createdTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @PreUpdate
    @PrePersist
    public void setDateTime() {
        if (createdTime==null) {
            createdTime = new Date();
        }
    }
}
