package com.codecool.generali.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity(name = "Calls")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ZonedDateTime actualDate;

    public Call() {
    }

    public Call(ZonedDateTime actualDate) {
        this.actualDate = actualDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getActualDate() {
        return actualDate;
    }

    public void setActualDate(ZonedDateTime actualDate) {
        this.actualDate = actualDate;
    }
}
