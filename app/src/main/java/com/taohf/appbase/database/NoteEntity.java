package com.taohf.appbase.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Note表
 * Created by hongfei.tao on 2017/4/27 16:58.
 */
@Entity
public class NoteEntity {

    @Id
    private int id;

    @NotNull
    private String title;
    @NotNull
    private String author;
    private String dateTime;
    private String note;
    @Generated(hash = 825657905)
    public NoteEntity(int id, @NotNull String title, @NotNull String author,
            String dateTime, String note) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateTime = dateTime;
        this.note = note;
    }
    @Generated(hash = 734234824)
    public NoteEntity() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDateTime() {
        return this.dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }

}
