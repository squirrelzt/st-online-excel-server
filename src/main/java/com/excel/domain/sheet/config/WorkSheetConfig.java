package com.excel.domain.sheet.config;

import lombok.Data;

@Data
public class WorkSheetConfig {
    /**
     * 合并单元格
     */
    private Merge merge;

    /**
     * 表格行高
     */
    private Rowlen rowlen;

    /**
     * /表格列宽
     */
    private Columnlen columnlen;

    /**
     * 隐藏行
     */
    private Rowhidden rowhidden;

    /**
     * 隐藏列
     */
    private Colhidden colhidden;

    /**
     * 边框
     */
    private BorderInfo borderInfo;

    /**
     * 工作表保护
     */
    private Authority authority;
}
