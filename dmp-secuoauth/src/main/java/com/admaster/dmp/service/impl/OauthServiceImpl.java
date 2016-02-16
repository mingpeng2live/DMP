package com.admaster.dmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admaster.dmp.domain.oauth2.OauthClientDetails;
import com.admaster.dmp.dto.OauthClientDetailsDto;
import com.admaster.dmp.mapper.oauth2.OauthClientDetailsMapper;
import com.admaster.dmp.service.OauthService;

@Service("oauthService")
public class OauthServiceImpl implements OauthService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) {
        return oauthClientDetailsMapper.findOauthClientDetails(clientId);
    }

    @Override
    public List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos() {
        List<OauthClientDetails> clientDetailses = oauthClientDetailsMapper.findAllOauthClientDetails();
        return OauthClientDetailsDto.toDtos(clientDetailses);
    }

    @Override
    public void archiveOauthClientDetails(String clientId) {
        oauthClientDetailsMapper.updateOauthClientDetailsArchive(clientId, true);
    }

    @Override
    public OauthClientDetailsDto loadOauthClientDetailsDto(String clientId) {
        final OauthClientDetails oauthClientDetails = oauthClientDetailsMapper.findOauthClientDetails(clientId);
        return oauthClientDetails != null ? new OauthClientDetailsDto(oauthClientDetails) : null;
    }

    @Override
    public void registerClientDetails(OauthClientDetailsDto formDto) {
        OauthClientDetails clientDetails = formDto.createDomain();
        oauthClientDetailsMapper.saveOauthClientDetails(clientDetails);
    }
}