package com.wuda.admin.db.service;

import com.wuda.admin.db.ResourceConnectionInfo;

import java.util.List;

/**
 * 资源链接service.
 *
 * @author wuda
 */
public interface ResourceConnectionService {

    /**
     * 获取数据库{@link javax.sql.DataSource DataSource}信息.
     *
     * @return db data source
     */
    List<ResourceConnectionInfo> getDataSourceInfo();
}
