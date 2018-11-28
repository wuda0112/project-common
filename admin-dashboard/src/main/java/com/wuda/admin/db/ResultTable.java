package com.wuda.admin.db;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 任意找一款mysql可视化客户端软件,会发现显示的结果都是一张表格,因此取名"结果表格".
 *
 * @author wuda
 */
@Data
public class ResultTable {

    /**
     * 列名.
     */
    private List<String> columnNames;
    /**
     * rows.
     */
    private List<Map<String, String>> rows;
}
