package com.pm.dmp.db;

import java.text.MessageFormat;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * 实现动态数据源切换逻辑
 *
 * @author pengming
 * @Date  2015年10月30日 上午11:19:19
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Map<Object, Object> _targetDataSources;
	
	private String url;
	private String username;
	private String password;
	private String driverClassName;

	/**
	 * 数据源为空或者为dataSource时，
	 * 自动切换至默认数据源，即在配置文件中定义的dataSource数据源
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		String dataSourceName = SchemaContextHolder.getSchema();
		if (StringUtils.isNotEmpty(dataSourceName) && !this._targetDataSources.containsKey(dataSourceName)) {
			this.selectDataSource(dataSourceName);
		}
		logger.debug("--------> use datasource " + dataSourceName);
		return dataSourceName;
	}

	
	/**
	 * @param schema
	 * @describe 不存在时创建新的数据源链接，并将新数据链接添加至缓存
	 */
	public void selectDataSource(String schema) {
		BoneCPDataSource dataSource = this.getDataSource(schema);
		if (null != dataSource)
			this.setDataSource(schema, dataSource);
	}

	/** 创建数据源连接池 */
	public BoneCPDataSource createDataSource(String driverClassName, String url,
			String username, String password) {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClassName);
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	/**
	 * @describe 查询serverId对应的数据源记录
	 * @param serverId
	 * @return
	 */
	public BoneCPDataSource getDataSource(String schema) {
		String schema_url = MessageFormat.format(this.getUrl(), schema);
		BoneCPDataSource dataSource = this.createDataSource(driverClassName, schema_url, username, password);
		return dataSource;
	}
	

	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		this._targetDataSources = targetDataSources;
		super.setTargetDataSources(this._targetDataSources);
		afterPropertiesSet();
	}

	public void addTargetDataSource(String key, BoneCPDataSource dataSource) {
		this._targetDataSources.put(key, dataSource);
		this.setTargetDataSources(this._targetDataSources);
	}

	/**
	 * 设置数据源，将当前线程的数据源切换至schema对应的数据库
	 * @param schema
	 * @param dataSource
	 */
	public void setDataSource(String schema, BoneCPDataSource dataSource) {
		this.addTargetDataSource(schema, dataSource);
		SchemaContextHolder.setSchema(schema);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
}