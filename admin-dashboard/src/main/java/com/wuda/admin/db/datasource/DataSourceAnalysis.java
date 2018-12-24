package com.wuda.admin.db.datasource;

import com.wuda.admin.db.ResourceConnectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 分析{@link DataSource},获取数据库连接信息,
 * 以及被连接的数据库的信息.
 *
 * @author wuda
 */
@Component
public class DataSourceAnalysis {

    @Autowired
    private DataSourceDetector dataSourceDetector;
    @Autowired
    private DataSourceAdaptor dataSourceAdaptor;

    /**
     * 获取系统中所有{@link DataSource}的基本信息.
     *
     * @return info
     */
    public List<ResourceConnectionInfo> getDataSourceInfo() {
        Map<String, DataSource> dataSourceMap = dataSourceDetector.getAll();
        if (dataSourceMap == null || dataSourceMap.isEmpty()) {
            return null;
        }
        Set<Map.Entry<String, DataSource>> entrySet = dataSourceMap.entrySet();
        List<ResourceConnectionInfo> list = new ArrayList<>(entrySet.size());
        for (Map.Entry<String, DataSource> entry : entrySet) {
            ResourceConnectionInfo info = new ResourceConnectionInfo();
            info.setSpringBeanName(entry.getKey());
            try {
                DataSourceIndividual individual = dataSourceAdaptor.adapt(entry.getValue());
                info.setDesc(individual.getDesc());
                info.setVariableMap(individual.getInfo());
            } catch (UnknownDataSourceException e) {
                info.setDesc(e.getMessage());
            }
            list.add(info);
        }
        return list;
    }
}
