package com.hxh.hxh_test.hxh.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum ResultCode implements Serializable {

    SUCCESS(0, "成功"),
    EXCEPTION(1, "系统出错啦"),
    CONN_ERR(2, "连接失败"),
    PARAM_EMPTY(3, "缺少参数"),
    PAPAM_ILLEGAL(4, "参数格式非法"),
    DATA_EMPTY(5, "数据缺失"),
    DATA_NOT_FOUND(6, "没有找到匹配的数据"),
    CONDITION_NOT_MATCH(7, "没有找到匹配的数据"),
    DATA_ILLEGAL(8, "数据格式非法"),
    DATA_ERROR(9, "数据格式非法"),
    ERROR(10, "操作失败"),
    OPERATION_UNSUPPORTED(11, "当前版本不支持的操作"),
    LOGIN_REQUIRED(12, "需要登录"),
    SERVER_NOT_START(13, "服务器未启动"),
    TOKEN_ILLEGAL(14, "token验证不通过"),
    SERVER_RESTRICTED(15, "服务器维护中");

    private static final long serialVersionUID = 3952740639419677143L;

    private static final int CODE_SUCCESS = 0;

    private String developDetail = "";

    private String onlineDetail = "";

    private int developCode = 0;

    private int onlineCode = 0;

    //策划还没有配置对应的错误码
    private boolean isDeveloping = true;

    private ResultCode(int developCode, String developDetail) {
        this.developCode = developCode;
        this.developDetail = developDetail;
    }

    private ResultCode(int developCode, String developDetail, int onlineCode, String onlineDetail) {
        this.developCode = developCode;
        this.developDetail = developDetail;
        this.onlineCode = onlineCode;
        this.onlineDetail = onlineDetail;
        this.isDeveloping = false;
    }

    private ResultCode(int developCode, String developDetail, String onlineDetail) {
        this.developCode = developCode;
        this.developDetail = developDetail;
        this.onlineCode = developCode;
        this.onlineDetail = onlineDetail;
        this.isDeveloping = false;
    }

    private ResultCode(int developCode, String developDetail, int onlineCode) {
        this.developCode = developCode;
        this.developDetail = developDetail;
        this.onlineCode = onlineCode;
        this.onlineDetail = developDetail;
        this.isDeveloping = false;
    }

    public String getDevelopDetail() {
        return developDetail;
    }

    public void setDevelopDetail(String developDetail) {
        this.developDetail = developDetail;
    }

    public String getOnlineDetail() {
        return onlineDetail;
    }

    public void setOnlineDetail(String onlineDetail) {
        this.onlineDetail = onlineDetail;
    }

    public int getDevelopCode() {
        return developCode;
    }

    public void setDevelopCode(int developCode) {
        this.developCode = developCode;
    }

    public int getOnlineCode() {
        return onlineCode;
    }

    public void setOnlineCode(int onlineCode) {
        this.onlineCode = onlineCode;
    }

    public boolean isDeveloping() {
        return isDeveloping;
    }

    public void setDeveloping(boolean isDeveloping) {
        this.isDeveloping = isDeveloping;
    }

    private static Map<Integer, ResultCode> developCodeCache = new HashMap<>();

    private static Map<Integer, ResultCode> onlineCodeCache = new HashMap<>();

    static {
        Set<Integer> codeSet = new HashSet<>();
        for (ResultCode errCode : values()) {
            if (codeSet.contains(errCode.getDevelopCode())) {
                new Exception("存在相同的错误码" + errCode.getDevelopCode()).printStackTrace();
            } else {
                codeSet.add(errCode.getDevelopCode());
            }

            developCodeCache.put(errCode.getDevelopCode(), errCode);
            if (!errCode.isDeveloping) {
                onlineCodeCache.put(errCode.getOnlineCode(), errCode);
            }
        }
    }

    /**
     * * 约定小于等于0为成功
     */
    public boolean isSuccess() {
        return developCode <= CODE_SUCCESS;
    }

    public boolean isNotSuccess() {
        return developCode > CODE_SUCCESS;
    }

    public static ResultCode of(int code) {
        ResultCode resultCode = onlineCodeCache.get(code);
        if (resultCode != null && !resultCode.isDeveloping) {
            return resultCode;
        }
        return developCodeCache.get(code);
    }

    public static ResultCode ofOnlineCode(int code) {
        return onlineCodeCache.get(code);
    }

    @Override
    public String toString() {
        return String.format("developCode=%s,onlineCode=%s, developDetail=%s, onlineDetail=%s", developCode, onlineCode, developDetail, onlineDetail);
    }

    public String getDetail() {
        return isDeveloping ? developDetail : onlineDetail;
    }

    public Map<String, Object> transToParamMap() {
        HashMap<String, Object> retMap = new HashMap<String, Object>();
        if (isDeveloping) {
            retMap.put("code", developCode);
            retMap.put("detail", developDetail);
        } else {
            retMap.put("code", onlineCode);
            retMap.put("detail", onlineDetail);
        }
        return retMap;
    }

}