package com.chenjiacheng.data.access.samples.common.enums;

/**
 * Created by chenjiacheng on 2025/6/24 01:38
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public enum ProvinceEnum {
    BEIJING("110000", "beijing", "北京"),
    TIANJIN("120000", "tianjin", "天津"),
    SHANGHAI("310000", "shanghai", "上海"),
    CHONGQING("500000", "chongqing", "重庆"),
    HEBEI("130000", "hebei", "河北"),
    SHANXI("140000", "shanxi", "山西"),
    NEIMENGGU("150000", "neimenggu", "内蒙古"),
    LIAONING("210000", "liaoning", "辽宁"),
    JILIN("220000", "jilin", "吉林"),
    HEILONGJIANG("230000", "heilongjiang", "黑龙江"),
    JIANGSU("320000", "jiangsu", "江苏"),
    ZHEJIANG("330000", "zhejiang", "浙江"),
    ANHUI("340000", "anhui", "安徽"),
    FUJIAN("350000", "fujian", "福建"),
    JIANGXI("360000", "jiangxi", "江西"),
    SHANDONG("370000", "shandong", "山东"),
    HENAN("410000", "henan", "河南"),
    HUBEI("420000", "hubei", "湖北"),
    HUNAN("430000", "hunan", "湖南"),
    GUANGDONG("440000", "guangdong", "广东"),
    GUANGXI("450000", "guangxi", "广西"),
    HAINAN("460000", "hainan", "海南"),
    SICHUAN("510000", "sichuan", "四川"),
    GUIZHOU("520000", "guizhou", "贵州"),
    YUNNAN("530000", "yunnan", "云南"),
    XIZANG("540000", "xizang", "西藏"),
    SHAANXI("610000", "shaanxi", "陕西"),
    GANSU("620000", "gansu", "甘肃"),
    QINGHAI("630000", "qinghai", "青海"),
    NINGXIA("640000", "ningxia", "宁夏"),
    XINJIANG("650000", "xinjiang", "新疆"),
    TAIWAN("710000", "taiwan", "台湾"),
    XIANGGANG("810000", "xianggang", "香港"),
    AOMEN("820000", "aomen", "澳门"),
    ;
    private String code;
    private String name;

    private String desc;

    ProvinceEnum(String code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}
