package com.jgsu.service;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Cet;
import com.jgsu.vo.CetVo; /**
 * 描述:
 * cetService
 *
 * @author grt
 * @create 2018-03-04 17:40
 */
public interface ICetService {

    ServerResponse<Cet> getCetScore(CetVo cetVo);

    ServerResponse getCetCheckCode();

}