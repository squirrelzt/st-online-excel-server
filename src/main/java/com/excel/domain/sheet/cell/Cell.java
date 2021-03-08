package com.excel.domain.sheet.cell;

import lombok.Data;

@Data
public class Cell {
    /**
     * 行
     */
    private String r;

    /**
     * 列
     */
    private String c;
    private CellV v;
}
