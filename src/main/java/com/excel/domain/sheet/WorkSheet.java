package com.excel.domain.sheet;

import com.excel.domain.sheet.calcchain.CalcChainItem;
import com.excel.domain.sheet.cell.Cell;
import com.excel.domain.sheet.chart.ChartItem;
import com.excel.domain.sheet.config.WorkSheetConfig;
import com.excel.domain.sheet.dataverification.DataVerification;
import com.excel.domain.sheet.filter_select.FilterSelect;
import com.excel.domain.sheet.frozen.Frozen;
import com.excel.domain.sheet.image.ImageItem;
import com.excel.domain.sheet.luckysheet_alternateformat_save.LuckysheetAlternateformatSaveItem;
import com.excel.domain.sheet.luckysheet_alternateformat_save_modelCustom.LuckysheetAlternateformatSaveModelCustomItem;
import com.excel.domain.sheet.luckysheet_conditionformat_save.LuckysheetConditionformatSaveItem;
import com.excel.domain.sheet.luckysheet_select_save.LuckysheetSelectSave;
import com.excel.domain.sheet.pivottable.PivotTable;
import lombok.Data;

import java.util.List;

@Data
public class WorkSheet {

    /**
     * 工作表名称
     */
    private String name;

    /**
     * 工作表颜色
     */
    private String color;

    /**
     * 工作表索引
     */
    private String index;

    /**
     * 激活状态
     */
    private Integer status;

    /**
     * 工作表的下标
     */
    private Integer order;

    /**
     * 是否隐藏：0为不隐藏，1为隐藏
     */
    private Integer hide;

    /**
     * 行数
     */
    private Integer row;

    /**
     * 列数
     */
    private Integer column;

    /**
     * 自定义行高
     */
    private Integer defaultRowHeight;

    /**
     * 自定义列宽
     */
    private Integer defaultColWidth;

    /**
     * 初始化使用的单元格数据
     */
    private Cell[] celldata;

    private WorkSheetConfig config;

    /**
     * 左右滚动条位置
     */
    private Integer scrollLeft;

    /**
     * 上下滚动条位置
     */
    private Integer scrollTop;

    /**
     * 选中的区域
     */
    private LuckysheetSelectSave[] luckysheet_select_save;

    /**
     * 公式链
     */
    private CalcChainItem[] calcChain;

    /**
     * 是否数据透视表
     */
    private Boolean isPivotTable;

    /**
     * 数据透视表设置
     */
    private PivotTable pivotTable;

    /**
     * 筛选范围
     */
    private FilterSelect filter_select;

    /**
     * 筛选配置
     */
    private String filter;

    /**
     * 交替颜色
     */
    private LuckysheetAlternateformatSaveItem[] luckysheet_alternateformat_save;

    /**
     * 自定义交替颜色
     */
    private LuckysheetAlternateformatSaveModelCustomItem[] luckysheet_alternateformat_save_modelCustom;

    /**
     * 条件格式
     */
    private LuckysheetConditionformatSaveItem luckysheet_conditionformat_save;

    /**
     * 冻结行列配置
     */
    private Frozen frozen;

    /**
     * 图表配置
     */
    private ChartItem[] chart;

    /**
     * 缩放比例
     */
    private Integer zoomRatio;

    /**
     * 图片
     */
    private ImageItem[] image;

    /**
     * 是否显示网格线
     */
    private Integer showGridLines;

    /**
     * 数据验证配置
     */
    private DataVerification dataVerification;
}
