package com.wuda.admin.db.model;

import com.wuda.admin.db.ResourceConnectionInfo;

import javax.sql.DataSource;
import java.util.List;

/**
 * 分析{@link DataSource},获取数据库连接信息,
 * 以及被连接的数据库的信息.
 *
 * @author wuda
 */
public interface DataSourceAnalysis {

    /**
     * 获取系统中所有{@link DataSource}的基本信息.
     *
     * @return info
     */
    List<ResourceConnectionInfo> getDataSourceInfo();
}
