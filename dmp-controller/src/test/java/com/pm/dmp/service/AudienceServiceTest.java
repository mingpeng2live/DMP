package com.pm.dmp.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pm.dmp.db.MybatisDao;
import com.pm.dmp.db.SchemaContextHolder;
import com.pm.dmp.domain.platform.Audience;
import com.pm.dmp.domain.platform.TenantUser;
import com.pm.dmp.mapper.platform.TenantUserMapper;
import com.pm.dmp.rest.MessageSourceUtils;
import com.pm.dmp.service.platform.AudienceService;
import com.pm.dmp.util.JackSonSerializer;

/**
 * 
 * @author pengming
 * @Date  2015年11月2日 下午12:08:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring.xml")
public class AudienceServiceTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MybatisDao mybatisDao;
	@Autowired
	private AudienceService audienceService;
	@Autowired
	private ApplicationContext applicationContext;
	
    @Autowired
    TenantUserMapper userMapper;
    
	@Before
	public void testUp(){
		MessageSourceUtils.setApplicationContext(applicationContext);
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		Audience selectByPrimaryKey = audienceService.selectByPrimaryKey(1l);
		logger.info(JackSonSerializer.toStringNException(selectByPrimaryKey));
		String msg = MessageSourceUtils.getMessage("audience.audienceUse.medium");
		logger.info(msg);
		msg = MessageSourceUtils.getMessage("BindAuthenticator.badCredentials");
		logger.info(msg);
		SchemaContextHolder.setSchema("dev_dmp_intel");
		
		selectByPrimaryKey = audienceService.selectByPrimaryKey(2l);
		logger.info(JackSonSerializer.toStringNException(selectByPrimaryKey));
	}
	
	@Test
	public void testUpdateAudienceAll(){
		int a = audienceService.updateAudienceAll(null, "dev_dmp_intel");
		logger.info("a: " + a);
		SchemaContextHolder.setSchema("dev_dmp_intel");
		a += audienceService.updateTow();
		logger.info("a: " + a);
	}

	@Test
	public void testSelectByPrimaryKeyDao(){
//		Map<String, Object> parameterMap = new HashMap<String, Object>();
//		parameterMap.put("id", 1l);
//		Audience selectByPrimaryKey = mybatisDao.getSingleRow("com.admaster.dmp.mapper.platform.AudienceMapper.selectByPrimaryKey", parameterMap);
//		logger.info(JackSonSerializer.toStringNException(selectByPrimaryKey));
//		Audience selectByPrimaryKey = mybatisDao.getSingleRow("common.selectByPrimaryKeys", parameterMap);
//		logger.info(JackSonSerializer.toStringNException(selectByPrimaryKey));
		
//		TenantUser user = mybatisDao.getSingleRow("com.admaster.dmp.mapper.platform.TenantUserMapper.selectByUserName", "chenyuanqiang@admaster.com.cn");
//		logger.info(JackSonSerializer.toStringNException(user));
		TenantUser user = userMapper.selectByUserName("chenyuanqiang@admaster.com.cn");
		logger.info(JackSonSerializer.toStringNException(user));

	}
	
	public static void main(String[] args) {
		String a = null;
		boolean s = check(a);
        System.out.println(s);
	}
	
	  static boolean check(String s){
	        System.out.println(s);
	        System.out.println("check");
	        return true;
	    }

	    static boolean check(List<String> ss) {
	    	System.out.println(ss);
	        System.out.println("check list");
	        return true;
	    }
	
	
}
