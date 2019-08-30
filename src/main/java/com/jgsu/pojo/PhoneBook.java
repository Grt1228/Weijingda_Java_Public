package com.jgsu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author grt
 */
@Data
public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 8919788523002035967L;
    private Long pkId;

    private String phoneBookId;

    private String phoneName;

    private String phoneNumber;

    private String phoneLevel;

    private String status;

    private Date createTime;

    private Date modifiedTime;

    private String openid;

    public PhoneBook() {
    }

    public PhoneBook(Long pkId, String phoneBookId, String phoneName, String phoneNumber, String phoneLevel, String status, Date createTime, Date modifiedTime, String openid) {
        this.pkId = pkId;
        this.phoneBookId = phoneBookId;
        this.phoneName = phoneName;
        this.phoneNumber = phoneNumber;
        this.phoneLevel = phoneLevel;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.openid = openid;
    }
}