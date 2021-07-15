package com.zzh.controller;

import com.zzh.domain.DetialReportVo;
import com.zzh.serviceImpl.ExcelService;
import com.zzh.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ExcelController {
    @Resource
    private ExcelService excelService;

    /**
     * SpringBoot+easyPoi一行代码搞定excel导出
     * @return
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response, @RequestParam("actId")int actId){
        //从数据库获取需要导出的数据
        List<DetialReportVo> userModelList =excelService.getExportDatas(actId);
        //导出操作
        FileUtil.exportExcel(userModelList,"用户信息","用户制作scy",DetialReportVo.class,"用户.xls",response);
    }

//    /**
//     * SpringBoot+easyPoi一行代码搞定excel导入
//     * @return
//     */
//    @RequestMapping("importExcel")
//    public String importExcel(){
//        String filePath = "F:\\用户.xls";
//        //解析excel，
//        List<DetialReportVo> userModelList= FileUtil.importExcel(filePath,1,1,UserModel.class);
//        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
//        System.out.println("导入数据一共【"+userModelList.size()+"】行");
//
//        //TODO 保存数据库.是个集合需要遍历
//        for(UserModel userModelLists : userModelList) {
//            String userName = userModelLists.getUserName();
//            String password = userModelLists.getPassword();
//            //数据库查重（写个查询的方法），名字和密码重复就不插入，否则插入
//            UserModel byNameAndPassword = excelService.findByNameAndPassword(userName, password);
//            if (byNameAndPassword==null){
//                excelService.saveImport(userModelLists);
//            }
//        }
//        return "redirect:/user/getAllUser";
//    }
}
