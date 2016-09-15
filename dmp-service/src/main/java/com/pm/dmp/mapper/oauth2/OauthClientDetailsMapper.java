package com.pm.dmp.mapper.oauth2;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pm.dmp.domain.oauth2.OauthClientDetails;

public interface OauthClientDetailsMapper {

    OauthClientDetails findOauthClientDetails(String clientId);

    List<OauthClientDetails> findAllOauthClientDetails();

    void updateOauthClientDetailsArchive(@Param("clientId") String clientId, @Param("archive") boolean archive);

    void saveOauthClientDetails(OauthClientDetails clientDetails);
}
