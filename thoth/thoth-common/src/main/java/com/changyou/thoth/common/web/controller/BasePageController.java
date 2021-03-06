package com.changyou.thoth.common.web.controller;

import com.alibaba.fastjson.JSON;
import com.changyou.thoth.common.model.PageInfo;
import com.changyou.thoth.common.model.PageRestResultBuilder;
import com.changyou.thoth.common.model.RestResult;
import com.changyou.thoth.common.web.dto.PageInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wujun on 2017/02/25.
 *
 * @author wujun
 * @since 2017/02/25
 */
public abstract class BasePageController<T> extends BaseController {

    @RequestMapping("/list")
    public RestResult listPage(PageInfoDto pageInfoDto) {
        logger.debug("listPage pageInfoDto: {}", pageInfoDto);
        PageInfo<T> pageInfo = this.listPageInfo(PageInfo.<T>build(pageInfoDto));
        logger.debug("listPage {}", JSON.toJSONString(pageInfo));
        return PageRestResultBuilder.builder().success(pageInfo).build();
    }

    public abstract PageInfo<T> listPageInfo(PageInfo<T> pageInfo);
}
