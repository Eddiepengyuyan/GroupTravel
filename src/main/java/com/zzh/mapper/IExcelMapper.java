package com.zzh.mapper;

import com.zzh.domain.DetialReportVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IExcelMapper {
    /**
     * SpringBoot+easyPoi一行代码搞定excel导入导出
     * @return
     */
    @Select("select theme,realname,aa_perfee,zj_perfee,aa_perfee + zj_perfee as perfee from act_user,activities,user where activityid=#{actId} and activities.id=activityid and user.id = act_user.userid;")
    List<DetialReportVo> getExportDatas(int actid);

    /**
     * 保存导入的用户
     * @param detialReportVo
     * @return
     */
    @Insert("")
    void saveImport(DetialReportVo detialReportVo);
}
