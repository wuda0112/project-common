package com.wuda.admin.db.model;

import com.wuda.admin.db.ResourceConnectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class DataSourceAnalysisImpl implements DataSourceAnalysis {

    @Autowired
    private DataSourceDetector dataSourceDetector;
    @Autowired
    private DataSourceAdaptor dataSourceAdaptor;

    @Override
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
