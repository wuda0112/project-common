package com.wuda.admin.db.service;

import com.wuda.admin.db.ResourceConnectionInfo;
import com.wuda.admin.db.datasource.DataSourceAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceConnectionServiceImpl implements ResourceConnectionService {

    @Autowired
    private DataSourceAnalysis dataSourceAnalysis;

    @Override
    public List<ResourceConnectionInfo> getDataSourceInfo() {
        return dataSourceAnalysis.getDataSourceInfo();
    }
}
