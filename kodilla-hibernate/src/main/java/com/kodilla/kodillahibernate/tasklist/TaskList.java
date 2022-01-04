package com.kodilla.kodillahibernate.tasklist;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TASKLISTS")
public final class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList(int id, String listName, String description) {
        this.id = id;
        this.listName = listName;
        this.description = description;
    }

    public TaskList() {

    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "LIST_NAME")
    public String getListName() {
        return listName;
    }

    @NotNull
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
