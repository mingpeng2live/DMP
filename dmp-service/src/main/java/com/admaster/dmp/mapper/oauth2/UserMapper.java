package com.admaster.dmp.mapper.oauth2;

import com.admaster.dmp.domain.oauth2.User;

public interface UserMapper {

    User findByGuid(String guid);

    void saveUser(User user);

    void updateUser(User user);

    User findByUsername(String username);

}