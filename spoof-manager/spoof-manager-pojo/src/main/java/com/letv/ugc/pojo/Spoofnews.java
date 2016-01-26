package com.letv.ugc.pojo;

public class Spoofnews {
    private Long id;

    private Long parentId = -1l;

    private Integer isParent = 0;

    private String title;

    private String imageurl = " ";

    private String content = " ";

    private String targeturl;

    private String targetcontent;

    private String summary = " ";

    private String comment = " ";

    private String targetsummary;

    private String parentTitile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTargeturl() {
        return targeturl;
    }

    public void setTargeturl(String targeturl) {
        this.targeturl = targeturl == null ? null : targeturl.trim();
    }

    public String getTargetcontent() {
        return targetcontent;
    }

    public void setTargetcontent(String targetcontent) {
        this.targetcontent = targetcontent == null ? null : targetcontent.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getTargetsummary() {
        return targetsummary;
    }

    public void setTargetsummary(String targetsummary) {
        this.targetsummary = targetsummary == null ? null : targetsummary.trim();
    }

    public String getParentTitile() {
        return parentTitile;
    }

    public void setParentTitile(String parentTitile) {
        this.parentTitile = parentTitile == null ? null : parentTitile.trim();
    }
}