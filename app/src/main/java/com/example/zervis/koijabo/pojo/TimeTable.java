package com.example.zervis.koijabo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeTable {

    @SerializedName("Day")
    @Expose
    private String Day;
    @SerializedName("StartTime")
    @Expose
    private Integer StartTime;
    @SerializedName("EndTime")
    @Expose
    private Integer EndTime;

    /**
     *
     * @return
     *     The Day
     */
    public String getDay() {
        return Day;
    }

    /**
     *
     * @param Day
     *     The Day
     */
    public void setDay(String Day) {
        this.Day = Day;
    }

    /**
     *
     * @return
     *     The StartTime
     */
    public Integer getStartTime() {
        return StartTime;
    }

    /**
     *
     * @param StartTime
     *     The StartTime
     */
    public void setStartTime(Integer StartTime) {
        this.StartTime = StartTime;
    }

    /**
     *
     * @return
     *     The EndTime
     */
    public Integer getEndTime() {
        return EndTime;
    }

    /**
     *
     * @param EndTime
     *     The EndTime
     */
    public void setEndTime(Integer EndTime) {
        this.EndTime = EndTime;
    }

}
