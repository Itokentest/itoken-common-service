package com.funtl.itoken.common.service.impl;

import com.funtl.itoken.common.domain.BaseDomain;
import com.funtl.itoken.common.domain.TbPostsPost;
import com.funtl.itoken.common.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.MyMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * <p>Title: BaseServiceImpl</p>
 * <p>Description: </p>
 *
 * @author wgw
 * @version 1.0.0
 * @date 2018/11/21 19:38
 */

@Service
@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseDomain, D extends MyMapper> implements BaseService<T> {

    @Autowired
    private D dao;

    @Override
    @Transactional(readOnly = false)
    public int insert(T t, String createBy) {
        t.setCreateBy(createBy);
        t.setCreateDate(new Date());
        return dao.insert(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int delete(T t) {
        return dao.delete(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int update(T t, String updateBy) {
        t.setUpdateBy(updateBy);
        t.setUpdateDate(new Date());
        return dao.updateByPrimaryKey(t);
    }

    @Override
    public T selectOne(T t) {

        return (T) dao.selectOne(t);
    }

    @Override
    public int count(T t) {
        return dao.selectCount(t);
    }

    @Override
    public PageInfo<T> page(int pageNum, int pageSize, T t) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, pageSize);

        PageInfo<T> pageInfo = new PageInfo<>(dao.select(t));

        return pageInfo;
    }
}
