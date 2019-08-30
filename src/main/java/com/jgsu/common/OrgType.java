package com.jgsu.common;

/**
 * 描述:
 * 用户所属组织
 * 组织编号,1本科，2研究生，3教师，4专科'
 * @author guorutao
 * @create 2018-05-03 14:13
 */
public enum OrgType {
    UNDERGRADUATE(1,"本科"),
    POSTGRADUATE(2,"研究生"),
    TEACHER(3,"教师"),
    SPECIALIST(4,"专科");

    private Integer code;
    private String name;

    OrgType( Integer code,String name) {
        this.name = name;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static OrgType getValueByCode(Integer code){
        OrgType[] values = OrgType.values();
        for(OrgType o : values){
            if(o.getCode().equals(code)){
                return o;
            }
        }
        return null;
    }
}
