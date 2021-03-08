package com.excel.controller;

import com.alibaba.fastjson.JSON;
import com.excel.domain.sheet.WorkSheet;
import com.excel.domain.sheet.cell.Cell;
import com.excel.service.WorkSheetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("worksheet")
public class WorkSheetController {

    private final WorkSheetService workSheetService;

    public WorkSheetController(WorkSheetService workSheetService) {
        this.workSheetService = workSheetService;
    }

    @GetMapping("/initData")
    public List<WorkSheet> initData() {
        List<WorkSheet> list = workSheetService.initData();
        log.info(JSON.toJSONString(list));
        return list;
    }

    @PostMapping("/cellUpdated")
    public Boolean cellUpdated(@RequestBody Cell cell) {
        log.info(JSON.toJSONString(cell));
        return Boolean.TRUE;
    }
}
