/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

/**
 *
 * @author brass
 */
public class NewsBean {
    private int news_id;
    private String type_N;
    private String name_N;
    private String file_N;
    private String time_N;
    private String creatby;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getType_N() {
        return type_N;
    }

    public void setType_N(String type_N) {
        this.type_N = type_N;
    }

    public String getName_N() {
        return name_N;
    }

    public void setName_N(String name_N) {
        this.name_N = name_N;
    }

    public String getFile_N() {
        return file_N;
    }

    public void setFile_N(String file_N) {
        this.file_N = file_N;
    }

    public String getTime_N() {
        return time_N;
    }

    public void setTime_N(String time_N) {
        this.time_N = time_N;
    }

    public String getCreatby() {
        return creatby;
    }

    public void setCreatby(String creatby) {
        this.creatby = creatby;
    }
    
}
