package com.pm.dmp.audience.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pm.dmp.BaseController;
import com.pm.dmp.domain.platform.Audience;
import com.pm.dmp.exception.BaseException;
import com.pm.dmp.service.platform.AudienceService;

/**
 * 人群
 * @author pengming
 * @Date  2015年11月2日 下午12:02:44
 */
@RestController
@RequestMapping("audience")
public class AudienceController extends BaseController {

	@Autowired
	private AudienceService audienceService;
	
	@RequestMapping("getAudience")
	public Audience getAudienceById(
			@RequestParam(value = "id", required = true) Long id
			){
		String msg = getMessage("audience.audienceUse.medium");
		logger.info(msg);
		return audienceService.selectByPrimaryKey(id);
	}
	

	@RequestMapping("getAudiences")
	public Audience getAudienceByIdaa(
			@RequestParam(value = "id", required = true) Long id
			) throws BaseException {
		String msg = getMessage("audience.audienceUse.medium");
		logger.info(msg);
		if (StringUtils.isNotEmpty(msg)){
			throw new BaseException("5000", "娇滴滴教大家发哦高级");
		}
		return audienceService.selectByPrimaryKey(id);
	}
	

	@RequestMapping("getAudiencen")
	public Audience getAudienceByIdbb(
			@RequestParam(value = "id", required = true) Long id
			) throws BaseException {
		String msg = getMessage("audience.audienceUse.medium");
		logger.info(msg);
		if (StringUtils.isNotEmpty(msg)){
			throw new NullPointerException("空异常");
		}
		return audienceService.selectByPrimaryKey(id);
	}
	
}
