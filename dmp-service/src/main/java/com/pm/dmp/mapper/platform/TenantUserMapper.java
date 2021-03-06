package com.pm.dmp.mapper.platform;

import com.pm.dmp.domain.platform.TenantUser;

public interface TenantUserMapper {
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
    int insertSelective(TenantUser record);

    /**
     * 根据主键查询数据
     * @param id
     * @return 
     */
    TenantUser selectByPrimaryKey(Long id);

    /**
     * 根据主键修改数据
     * @param record
     * @return 受影响条数
     */
    int updateByPrimaryKeySelective(TenantUser record);
    
    TenantUser selectByUserName(String userName);
}