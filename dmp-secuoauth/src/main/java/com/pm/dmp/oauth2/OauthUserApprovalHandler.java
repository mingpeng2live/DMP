package com.pm.dmp.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;

import com.pm.dmp.domain.oauth2.OauthClientDetails;
import com.pm.dmp.service.OauthService;

/**
 * check 当前 clientId（即appkey）对应是否需要授权操作后才能获取到code
 * @author pengming
 * @Description 
 *
 * @Date  2015年11月15日 上午11:23:30
 */
public class OauthUserApprovalHandler extends TokenStoreUserApprovalHandler {

    private OauthService oauthService;

    public OauthUserApprovalHandler() {
    }


    /**
     * <p>
     * {@link AuthorizationEndpoint Authorization End point} 
     * 上述类中方法是获取 auth_code 的请求处理，其中会调用本方法进行处理
     * 在登录完成后判断是否需要手动点击授权处理，如果为true 则直接通过
     * 如果false 上述AuthorizationEndpoint类中会转发到手动授权界面
     * </p>
     */
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        if (super.isApproved(authorizationRequest, userAuthentication)) {
            return true;
        }
        if (!userAuthentication.isAuthenticated()) {
            return false;
        }

        OauthClientDetails clientDetails = oauthService.loadOauthClientDetails(authorizationRequest.getClientId());
        return clientDetails != null && clientDetails.trusted();
    }

    public void setOauthService(OauthService oauthService) {
        this.oauthService = oauthService;
    }
}