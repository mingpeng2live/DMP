package com.admaster.dmp.mapper.platform;

import com.admaster.dmp.domain.platform.Audience;

public interface AudienceMapper {
    /**
     * 根据主键删除
     * @param id
     * @return 受影响条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增数据
     * @param record
     * @return 受影响条数
     */
    int insertSelective(Audience record);

    /**
     * 根据主键查询数据
     * @param id
     * @return 
     */
    Audience selectByPrimaryKey(Long id);

    /**
     * 根据主键修改数据
     * @param record
     * @return 受影响条数
     */
    int updateByPrimaryKeySelective(Audience record);
}