package com.wany.purplespider.bean;


import java.util.List;


public class ParadiseTeleplay {

    /**
     * 中文名
     */
    private String title;
    /**
     * 原名
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 编剧
     */
    private String scriptwriter;

    /**
     * 导演
     */
    private String director;

    /**
     * 主演
     */
    private String protagonist;

    /**
     * 首播日期
     */
    private String premiereDate;

    /**
     * 翻译
     */
    private String translate;

    /**
     * 小分类
     */
    private List<String> subClassification;

    /**
     * 地区
     */
    private String region;

    /**
     * 电视台
     */
    private String televisionStation;

    /**
     * 时间
     */
    private String date;

    /**
     * 单集片长
     */
    private String runningTime;

    /**
     * 类型
     */
    private String type;

    /**
     * 下一季
     */
    private String nextSeason;

    /**
     * 海报
     */
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public List<String> getSubClassification() {
        return subClassification;
    }

    public void setSubClassification(List<String> subClassification) {
        this.subClassification = subClassification;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelevisionStation() {
        return televisionStation;
    }

    public void setTelevisionStation(String televisionStation) {
        this.televisionStation = televisionStation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNextSeason() {
        return nextSeason;
    }

    public void setNextSeason(String nextSeason) {
        this.nextSeason = nextSeason;
    }

    @Override
    public String toString() {
        return "ParadiseTeleplay{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", scriptwriter='" + scriptwriter + '\'' +
                ", director='" + director + '\'' +
                ", protagonist='" + protagonist + '\'' +
                ", premiereDate='" + premiereDate + '\'' +
                ", translate='" + translate + '\'' +
                ", subClassification=" + subClassification +
                ", region='" + region + '\'' +
                ", televisionStation='" + televisionStation + '\'' +
                ", date='" + date + '\'' +
                ", runningTime='" + runningTime + '\'' +
                ", type='" + type + '\'' +
                ", nextSeason='" + nextSeason + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
