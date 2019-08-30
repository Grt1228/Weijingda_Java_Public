package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.AppText;
import com.jgsu.vo.apptext.AppTextRequest;

public interface IAppTextService {
    /**
     * 新增
     * @param appText
     * @return
     */
    ServerResponse insert(AppText appText);

    /**
     * 修改
     * @param appText
     * @return
     */
    ServerResponse update(AppText appText);

    /**
     * 查询列表
     * @param request
     * @return
     */
    ServerResponse<PageInfo> list(AppTextRequest request);
}
