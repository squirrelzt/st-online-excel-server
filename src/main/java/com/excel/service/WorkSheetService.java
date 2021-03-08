package com.excel.service;

import com.excel.domain.sheet.WorkSheet;
import com.excel.domain.sheet.cell.Cell;

import java.util.List;

public interface WorkSheetService {

    List<WorkSheet> initData();

    void cellUpdated(Cell cell);
}
