package com.zzh.service;

import com.zzh.domain.DetialReportVo;

import java.util.List;

public interface IExcelService {
    /**
     * SpringBoot+easyPoi一行代码搞定excel导入导出
     * @return
     */
    List<DetialReportVo> getExportDatas(int actId);

    /**
     * 保存导入的用户
     * @param detialReportVo
     * @return
     */
    void saveImport(DetialReportVo detialReportVo);
}
