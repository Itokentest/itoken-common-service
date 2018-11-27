package com.funtl.itoken.common.service;

import com.funtl.itoken.common.domain.BaseDomain;
import com.github.pagehelper.PageInfo;

/**
 * <p>Title: BaseService</p>
 * <p>Description: </p>
 *
 * @author wgw
 * @version 1.0.0
 * @date 2018/11/21 19:35
 */
public interface BaseService<T extends BaseDomain> {
    int insert(T t, String createBy);

    int delete(T t);

    int update(T t, String updateBy);

    T selectOne(T t);

    int count(T t);

    PageInfo<T> page(int pageNum, int pageSize, T t);
}
