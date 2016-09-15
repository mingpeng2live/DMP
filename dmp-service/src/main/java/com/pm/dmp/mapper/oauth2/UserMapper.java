package com.pm.dmp.mapper.oauth2;

import com.pm.dmp.domain.oauth2.User;

public interface UserMapper {

    User findByGuid(String guid);

    void saveUser(User user);

    void updateUser(User user);

    User findByUsername(String username);

}