package com.pm.dmp.mapper.platform;

import com.pm.dmp.domain.platform.UserRole;

public interface UserRoleMapper {
    /**
     * 根据主键删除
     * @param key
     * @return 受影响条数
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(UserRole key);

    /**
     * 新增数据
     * @param record
     * @return 受影响条数
     *
     * @mbggenerated
     */
    int insertSelective(UserRole record);
    
    int selectCountById();
}