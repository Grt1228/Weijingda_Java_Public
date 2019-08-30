package com.jgsu.vo.apptext;

import com.jgsu.vo.PageRequest;
import lombok.Data;

/**
 *
 */
@Data
public class AppTextRequest extends PageRequest {
    /**
     * 状态
     */
    private String status;
    /**
     * 文字类别
     */
    private String textType;

    /**
     * 文字类别
     */
    private String textTitle;
}
