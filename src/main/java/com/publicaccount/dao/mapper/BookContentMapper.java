package com.publicaccount.dao.mapper;

import com.publicaccount.dao.entity.BookContent;
import com.publicaccount.dao.entity.BookContentExample;
import java.util.List;

public interface BookContentMapper {
    int countByExample(BookContentExample example);

    int deleteByExample(BookContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookContent record);

    int insertSelective(BookContent record);

    List<BookContent> selectByExampleWithBLOBs(BookContentExample example);

    List<BookContent> selectByExample(BookContentExample example);

    BookContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookContent record);

    int updateByPrimaryKeyWithBLOBs(BookContent record);

    int updateByPrimaryKey(BookContent record);
}