package com.excel.domain.sheet.calcchain;

import lombok.Data;

@Data
public class CalcChainItem {
    private Integer r;
    private Integer c;
    private Integer index;
    private String[] func;
    private String color;
    private String parent;
    private Integer times;
}
