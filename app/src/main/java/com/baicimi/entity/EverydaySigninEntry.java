package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/25.
 * 积分商城 每日签到 实体类
 */
public class EverydaySigninEntry {
    private String signinNumber;//获取到的积分数量
    private boolean state;//是否签到状态
    private boolean notreachState;//未到达签到时间状态
    private String signinDate;//日期


    public EverydaySigninEntry(String signinNumber, boolean state, String signinDate) {
        this.signinNumber = signinNumber;
        this.state = state;
        this.signinDate = signinDate;
    }

    public EverydaySigninEntry(String signinNumber, boolean state, boolean notreachState, String signinDate) {
        this.signinNumber = signinNumber;
        this.state = state;
        this.notreachState = notreachState;
        this.signinDate = signinDate;
    }


    public boolean isNotreachState() {
        return notreachState;
    }

    public void setNotreachState(boolean notreachState) {
        this.notreachState = notreachState;
    }

    public String getSigninNumber() {
        return signinNumber;
    }

    public void setSigninNumber(String signinNumber) {
        this.signinNumber = signinNumber;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSigninDate() {
        return signinDate;
    }

    public void setSigninDate(String signinDate) {
        this.signinDate = signinDate;
    }
}
