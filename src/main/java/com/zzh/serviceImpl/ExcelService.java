package com.zzh.serviceImpl;

import com.zzh.domain.DetialReportVo;
import com.zzh.mapper.IExcelMapper;
import com.zzh.service.IExcelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExcelService implements IExcelService {
    @Resource
    private IExcelMapper iExcelMapper;
    @Override
    public List<DetialReportVo> getExportDatas(int actId) {
        List<DetialReportVo> userModels = iExcelMapper.getExportDatas(actId);
        return userModels;
    }

    @Override
    public void saveImport(DetialReportVo detialReportVo) {
        iExcelMapper.saveImport(detialReportVo);
    }
}
