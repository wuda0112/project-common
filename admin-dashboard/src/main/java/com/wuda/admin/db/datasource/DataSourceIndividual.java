package com.wuda.admin.db.datasource;

import java.util.Map;

/**
 * {@link javax.sql.DataSource}的实现有很多种,针对具体的每种{@link javax.sql.DataSource},
 * 给出不同的处理.
 *
 * @author wuda
 */
public interface DataSourceIndividual {

    /**
     * data source的简单描述.
     *
     * @return desc
     */
    String getDesc();

    /**
     * 获取此data source的信息,由于每种具体的data source的实现不一样,
     * 所保持的信息也不一样,因此使用map作为返回值.
     *
     * @return info
     */
    Map<String, Object> getInfo();
}
