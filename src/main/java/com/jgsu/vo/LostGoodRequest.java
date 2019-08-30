package com.jgsu.vo;

import lombok.Data;

/**
 * 描述:
 * 失物招领request
 *
 * @author grt
 * @create 2018-05-01 17:28
 */
@Data
public class LostGoodRequest extends PageRequest{

    private String lostGoodId;
    /**
     * openid
     */
    private String openid;
    /**
     * '记录的有效状态,1-有效,0-无效'
     */
    private String status;
    /**
     * '物品的类型,1-发布捡到物品,2-发布寻找物品'
     */
    private String goodType;
    /**
     * '失物招领状态,01-完成,02-未完成'
     */
    private String goodStatus;


}