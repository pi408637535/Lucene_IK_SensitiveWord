package com.letv.ugc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.letv.ugc.pojo.Version;
import com.letv.ugc.pojo.VersionExample;

public interface VersionMapper {
    int countByExample(VersionExample example);

    int deleteByExample(VersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Version record);

    int insertSelective(Version record);

    List<Version> selectByExample(VersionExample example);

    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);
    
    long getVersionMax();
    void insertVersion();
}