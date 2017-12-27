package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/27.
 */
public class LogisticsEvaluateFragmentSecondParticularsEntry {
    private String content;
    private int imageFirst;
    private int imageSecond;
    private boolean imageState;
    private String userName;
    private boolean replyState;


    public LogisticsEvaluateFragmentSecondParticularsEntry(String content, int imageFirst, int imageSecond, boolean imageState, String userName, boolean replyState) {
        this.content = content;
        this.imageFirst = imageFirst;
        this.imageSecond = imageSecond;
        this.imageState = imageState;
        this.userName = userName;
        this.replyState = replyState;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageFirst() {
        return imageFirst;
    }

    public void setImageFirst(int imageFirst) {
        this.imageFirst = imageFirst;
    }

    public int getImageSecond() {
        return imageSecond;
    }

    public void setImageSecond(int imageSecond) {
        this.imageSecond = imageSecond;
    }

    public boolean isImageState() {
        return imageState;
    }

    public void setImageState(boolean imageState) {
        this.imageState = imageState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isReplyState() {
        return replyState;
    }

    public void setReplyState(boolean replyState) {
        this.replyState = replyState;
    }
}
