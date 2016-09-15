package com.pm.dmp.domain.platform;

import java.io.Serializable;
import java.util.Date;

public class Audience implements Serializable {
    private Long id;

    private Long version;

    private Date dateCreated;

    private String description;

    private Date lastUpdated;

    private String name;

    private String type;

    private Long status;

    private Boolean isSelfGrouped;

    private String dataSourceType;

    private Integer statFrequency;

    private Integer remainFrequency;

    /** 数据来源设备类型 pc, mobile */
    private String device;

    private String rules;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Boolean getIsSelfGrouped() {
        return isSelfGrouped;
    }

    public void setIsSelfGrouped(Boolean isSelfGrouped) {
        this.isSelfGrouped = isSelfGrouped;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType == null ? null : dataSourceType.trim();
    }

    public Integer getStatFrequency() {
        return statFrequency;
    }

    public void setStatFrequency(Integer statFrequency) {
        this.statFrequency = statFrequency;
    }

    public Integer getRemainFrequency() {
        return remainFrequency;
    }

    public void setRemainFrequency(Integer remainFrequency) {
        this.remainFrequency = remainFrequency;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }
}