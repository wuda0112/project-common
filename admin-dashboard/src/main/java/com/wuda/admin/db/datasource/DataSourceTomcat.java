package com.wuda.admin.db.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * tomcat data source实现.
 *
 * @author wuda
 */
public class DataSourceTomcat implements DataSourceIndividual {

    private String key_idle_count = "idle_count";
    private String key_active_count = "active_count";
    private String key_borrowed_count = "borrowed_count";
    private String key_created_count = "created_count";
    private String key_initial_size = "initial_size";
    private String key_max_active = "max_active";
    private String key_current_size = "current_size";
    private String key_url = "url";
    private String key_username = "username";

    /**
     * data source instance.
     */
    private javax.sql.DataSource dataSourceInstance;

    /**
     * 不能自己new实例,只能由{@link DataSourceAdaptor#adapt(javax.sql.DataSource)}生成改类的实例.
     *
     * @param dataSourceInstance
     *         {@link javax.sql.DataSource}的实例
     */
    DataSourceTomcat(javax.sql.DataSource dataSourceInstance) {
        this.dataSourceInstance = dataSourceInstance;
    }

    @Override
    public String getDesc() {
        return "tomcat data source implement";
    }

    public Map<String, Object> getInfo() {
        org.apache.tomcat.jdbc.pool.DataSource tomcatDataSource = (DataSource) dataSourceInstance;
        Map<String, Object> map = new HashMap<>();
        map.put(key_idle_count, tomcatDataSource.getIdle() + " , the number of established but idle connections");
        map.put(key_active_count, tomcatDataSource.getActive() + " , number of connections in use by the application");
        map.put(key_borrowed_count, tomcatDataSource.getBorrowedCount() + " , the borrowed connection count");
        map.put(key_created_count, tomcatDataSource.getCreatedCount() + " , The total number of connections created by this pool");
        map.put(key_initial_size, tomcatDataSource.getInitialSize() + " , the number of connections that will be established when the connection pool is started");
        map.put(key_max_active, tomcatDataSource.getMaxActive() + " , The maximum number of active connections that can be allocated from this pool at the same time");
        map.put(key_current_size, tomcatDataSource.getSize() + " , the current size of the pool");
        map.put(key_url, tomcatDataSource.getUrl());
        map.put(key_username, tomcatDataSource.getUsername());
        return map;
    }
}
