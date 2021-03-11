package com.excel.service.impl;

import com.alibaba.fastjson.JSON;
import com.excel.domain.sheet.cell.Cell;
import com.excel.domain.sheet.cell.CellV;
import com.excel.domain.sheet.chart.ChartItem;
import com.excel.domain.sheet.dataverification.DataVerification;
import com.excel.domain.sheet.frozen.Frozen;
import com.excel.domain.sheet.image.ImageItem;
import com.excel.domain.sheet.luckysheet_alternateformat_save.LuckysheetAlternateformatSaveItem;
import com.excel.domain.sheet.WorkSheet;
import com.excel.domain.sheet.calcchain.CalcChainItem;
import com.excel.domain.sheet.config.*;
import com.excel.domain.sheet.filter_select.FilterSelect;
import com.excel.domain.sheet.luckysheet_alternateformat_save_modelCustom.LuckysheetAlternateformatSaveModelCustomItem;
import com.excel.domain.sheet.luckysheet_conditionformat_save.LuckysheetConditionformatSaveItem;
import com.excel.domain.sheet.luckysheet_select_save.LuckysheetSelectSave;
import com.excel.domain.sheet.pivottable.PivotTable;
import com.excel.service.WorkSheetService;
import com.excel.websocket.WebSocketUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class WorkSheetServiceImpl implements WorkSheetService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<WorkSheet> initData() {
        List<WorkSheet> list = new ArrayList<>(1);
        WorkSheet workSheet = new WorkSheet();
        workSheet.setName("My Online Sheet");
        workSheet.setColor("");
        workSheet.setIndex("0");
        workSheet.setStatus(1);
        workSheet.setOrder(0);
        workSheet.setHide(0);
        workSheet.setRow(30);
        workSheet.setColumn(20);
        workSheet.setDefaultRowHeight(20);
        workSheet.setDefaultColWidth(73);

        Cell[] cellArray = getCellData();
        if (cellArray.length > 0) {
            workSheet.setCelldata(cellArray);
        } else {
            workSheet.setCelldata(new Cell[0]);
        }

        WorkSheetConfig config = new WorkSheetConfig();
        config.setMerge(new Merge());
        config.setRowlen(new Rowlen());
        config.setColumnlen(new Columnlen());
        config.setRowhidden(new Rowhidden());
        config.setColhidden(new Colhidden());
        config.setBorderInfo(new BorderInfo());
        config.setAuthority(new Authority());
        workSheet.setConfig(config);

        workSheet.setScrollLeft(0);
        workSheet.setScrollTop(0);

        workSheet.setLuckysheet_select_save(new LuckysheetSelectSave[0]);

        workSheet.setCalcChain(new CalcChainItem[0]);
        workSheet.setIsPivotTable(false);
        workSheet.setPivotTable(new PivotTable());
        workSheet.setFilter_select(new FilterSelect());
        workSheet.setFilter("");
        workSheet.setLuckysheet_alternateformat_save(new LuckysheetAlternateformatSaveItem[0]);
        workSheet.setLuckysheet_alternateformat_save_modelCustom(new LuckysheetAlternateformatSaveModelCustomItem[0]);
        workSheet.setLuckysheet_conditionformat_save(new LuckysheetConditionformatSaveItem());
        workSheet.setFrozen(new Frozen());
        workSheet.setChart(new ChartItem[0]);
        workSheet.setZoomRatio(1);
        workSheet.setImage(new ImageItem[0]);
        workSheet.setShowGridLines(1);
        workSheet.setDataVerification(new DataVerification());

        list.add(workSheet);

        return list;
    }

    @Override
    public void cellUpdated(Cell cell) {
        WebSocketUtils.sendMessageAll(JSON.toJSONString(cell));
        jdbcTemplate.update("update CELL set v=? where sheet_id = ? and r = ? and c = ?",
                JSON.toJSONString(cell.getV()),
                "1",
                cell.getR(),
                cell.getC());
    }

    private Cell[] getCellData() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from cell");
        List<Cell> cellList = new ArrayList<>();
        if (list.size() > 0) {
            for (Object obj : list) {
                log.info(obj.toString());
                Map map =  (Map)obj;
                map.remove("ID");
                map.remove("SHEET_ID");
                map.remove("FA");
                map.remove("T");
                map.remove("M");
                String v = (String)map.get("V");
                if (!StringUtils.isEmpty(v)) {
                    CellV cellV = JSON.parseObject(v, CellV.class);
                    Cell cell = new Cell();
                    cell.setV(cellV);
                    cell.setR((String) map.get("R"));
                    cell.setC((String)map.get("R"));
                    cellList.add(cell);
                }

            }
        }

        Cell[] cellArray = new Cell[cellList.size()];
        for (int i = 0; i < cellList.size(); i++) {
            cellArray[i] = cellList.get(i);
        }
        return cellArray;
    }
}
