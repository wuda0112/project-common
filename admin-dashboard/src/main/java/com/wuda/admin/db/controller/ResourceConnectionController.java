package com.wuda.admin.db.controller;

import com.wuda.admin.PathConstant;
import com.wuda.admin.db.ResourceConnectionInfo;
import com.wuda.admin.db.service.ResourceConnectionService;
import com.wuda.common.lang.response.CommonResultDesc;
import com.wuda.common.lang.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = PathConstant.CONTEXT_ADMIN + PathConstant.RESOURCE_CONNECTION)
public class ResourceConnectionController {

    @Autowired
    private ResourceConnectionService resourceConnectionService;

    @RequestMapping(path = PathConstant.FUNC_DATA_SOURCE)
    public Result<List<ResourceConnectionInfo>> getDataSources() {
        List<ResourceConnectionInfo> list = resourceConnectionService.getDataSourceInfo();
        return new Result<>(CommonResultDesc.OK, list);
    }

}
