package com.example.notebook.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2018/10/14.
 */

public class User {
    private String name;
    private String phone;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        return time;
    }

    public void setTime(String time) { this.time = time; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
