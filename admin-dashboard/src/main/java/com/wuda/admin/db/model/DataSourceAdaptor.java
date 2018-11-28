package com.wuda.admin.db.model;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * data source 适配器.根据传入的{@link DataSource}实例,判断具体是哪种类型实现.
 *
 * @author wuda
 */
@Component
public class DataSourceAdaptor {

    /**
     * 返回当前的{@link DataSource}的具体类型.
     *
     * @param dataSource
     *         data source 实例
     * @return 具体的类型
     * @throws UnknownDataSourceException
     *         当前data source无法处理
     */
    public DataSourceIndividual adapt(DataSource dataSource) throws UnknownDataSourceException {
        if (dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource) {
            return new DataSourceTomcat(dataSource);
        }
        throw new UnknownDataSourceException();
    }
}
