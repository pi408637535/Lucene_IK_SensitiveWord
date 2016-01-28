package com.letv.ugc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.letv.ugc.pojo.Spoofnews;
import com.letv.ugc.pojo.SpoofnewsExample;

public interface SpoofnewsMapper {
    int countByExample(SpoofnewsExample example);

    int deleteByExample(SpoofnewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Spoofnews record);

    int insertSelective(Spoofnews record);

    List<Spoofnews> selectByExample(SpoofnewsExample example);

    Spoofnews selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Spoofnews record, @Param("example") SpoofnewsExample example);

    int updateByExample(@Param("record") Spoofnews record, @Param("example") SpoofnewsExample example);

    int updateByPrimaryKeySelective(Spoofnews record);

    int updateByPrimaryKey(Spoofnews record);
}