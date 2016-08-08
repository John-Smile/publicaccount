package com.publicaccount.dao.mapper;

import com.publicaccount.dao.entity.PushException;
import com.publicaccount.dao.entity.PushExceptionExample;
import java.util.List;

public interface PushExceptionMapper {
    int countByExample(PushExceptionExample example);

    int deleteByExample(PushExceptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PushException record);

    int insertSelective(PushException record);

    List<PushException> selectByExample(PushExceptionExample example);

    PushException selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PushException record);

    int updateByPrimaryKey(PushException record);
}