package com.pm.dmp.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.dmp.BaseController;
import com.pm.dmp.domain.platform.TenantUser;
import com.pm.dmp.service.platform.AudienceService;
import com.pm.dmp.util.JackSonSerializer;

/**
 * 人群
 * @author pengming
 * @Date  2015年11月2日 下午12:02:44
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private AudienceService audienceService;
	@Resource(name = "authenticationManager")
	private AuthenticationManager myAuthenticationManager;
	
    @RequestMapping(value="/login") 
	public TenantUser login(){
    	
    	logger.info(JackSonSerializer.toStringNException(myAuthenticationManager));
    	TenantUser t = new TenantUser();
    	t.setId(1l);
    	t.setNickname("login");
		return t;
	}
    
    @RequestMapping(value="/logout") 
    public TenantUser logout(){
    	TenantUser t = new TenantUser();
    	t.setId(2l);
    	t.setNickname("logout");
		return t;
    }
    
    @RequestMapping(value="/decription") 
    public TenantUser decription(){
    	TenantUser t = new TenantUser();
    	t.setId(3l);
    	t.setNickname("decription");
    	return t;
    }
	
    
    
//    @Autowired
//    private CwSysUserService cwSysUserService;
//    
//    @RequestMapping(value="/login",method=RequestMethod.POST) 
//    public LoginInfo login(
//    		@RequestParam(defaultValue="") String username,
//    		@RequestParam(defaultValue="") String password,
//    		HttpServletRequest request){
//        if(!checkValidateCode(request)){
//            return new LoginInfo().failed().msg("验证码错误！");
//        }
//        username = username.trim();
//        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
//         try {
//            Authentication authentication = myAuthenticationManager.authenticate(authRequest); //调用loadUserByUsername
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            HttpSession session = request.getSession();
//            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
//            return new LoginInfo().success().msg(authentication.getName());
//        } catch (AuthenticationException ex) {
//            return new LoginInfo().failed().msg("用户名或密码错误");
//        }
//    }
    
    
    
    /**
     * 验证码判断
     * @param request
     * @return
     */
    protected boolean checkValidateCode(HttpServletRequest request) {
        String result_verifyCode = request.getSession().getAttribute("verifyResult").toString(); // 获取存于session的验证值
       // request.getSession().setAttribute("verifyResult", null);  
        String user_verifyCode = request.getParameter("verifyCode");// 获取用户输入验证码
        if (null == user_verifyCode || !result_verifyCode.equalsIgnoreCase(user_verifyCode)) {
            return false;
        }
        return true;
    }
	
}
