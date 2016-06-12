package com.example.phuc.quanlybo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;


public class UserDetail {
    private String statusID;
    private String statusName;
    private Map data;

    public String getStatusID(){
        return statusID;
    }

    public String getStatusName(){
        return statusName;
    }

    public Map getData(){
        return data;
    }

    public void setStatusID(String statusID){
        this.statusID = statusID;
    }

    public void setStatusName(String statusName){
        this.statusName = statusName;
    }

    public void setData(Map data){
        this.data = data;
    }

}