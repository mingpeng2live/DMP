package com.admaster.dmp.service.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admaster.dmp.domain.platform.Audience;
import com.admaster.dmp.mapper.platform.AudienceMapper;
import com.admaster.dmp.service.BaseService;

/**
 * 人群服务
 * @author pengming
 * @Date  2015年11月2日 下午12:04:07
 */
@Service
public class AudienceService extends BaseService {

	@Autowired
	private AudienceMapper audienceMapper;
	
	public Audience selectByPrimaryKey(Long id){
		return audienceMapper.selectByPrimaryKey(id);
	}
	
	public int updateAudienceById(Audience audience) {
		return audienceMapper.updateByPrimaryKeySelective(audience);
	}
	
	public int updateAudienceAll(Audience audience, String schema) {
		audience = selectByPrimaryKey(1l);
		audience.setDescription("aa");
		int a = audienceMapper.updateByPrimaryKeySelective(audience);
		
//		if (true) {
//			throw new RuntimeException("aaa");
//		}
		return a;
	}

	/**
	 * @param a
	 * @return
	 */
	public int updateTow() {
		Audience audience = selectByPrimaryKey(2l);
		audience.setDescription("bb");
		int a =  audienceMapper.updateByPrimaryKeySelective(audience);
//		if (true) {
//			throw new RuntimeException("bbb");
//		}
		return a;
	}
	
}
