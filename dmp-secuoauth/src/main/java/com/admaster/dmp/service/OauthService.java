package com.admaster.dmp.service;
import java.util.List;

import com.admaster.dmp.domain.oauth2.OauthClientDetails;
import com.admaster.dmp.dto.OauthClientDetailsDto;


public interface OauthService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}