package com.pm.dmp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pm.dmp.dto.UserJsonDto;

/**
 * 
 * @author pengming
 * @Description 
 *
 * @Date  2015年11月13日 下午7:29:51
 */
public interface UserService extends UserDetailsService {

    UserJsonDto loadCurrentUserJsonDto();
}