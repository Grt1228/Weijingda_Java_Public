package com.jgsu.vo.message;

import com.jgsu.vo.PageRequest;
import lombok.Data;

/**
 * 描述:
 * 留言板
 *
 * @author grt
 * @create 2018-09-02 18:15
 */
@Data
public class MessageRequest extends PageRequest {
    /**
     * 状态值
     */
    private String status;
    /**
     * 用户id
     */
    private String loginName;
    /**
     * openid
     */
    private String openid;
}