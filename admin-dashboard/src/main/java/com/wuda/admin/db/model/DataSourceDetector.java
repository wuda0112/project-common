package com.wuda.admin.db.model;

import com.wuda.common.lang.util.SpringApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 探测当前应用中的{@link DataSource},因为一个项目中可能有多个数据源.
 *
 * @author wuda
 */
@Component
public class DataSourceDetector {

    @Autowired
    private SpringApplicationContextUtil springApplicationContextUtil;

    /**
     * 获取当前应用中配置的所有{@link DataSource DataSource}实例.
     *
     * @return key - bean name , value - Data Source实例
     */
    public Map<String, DataSource> getAll() {
        return springApplicationContextUtil.getApplicationContext().getBeansOfType(DataSource.class);
    }
}
