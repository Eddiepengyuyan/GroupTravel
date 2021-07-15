package com.zzh.serviceImpl;

import com.zzh.domain.Activities;
import com.zzh.mapper.IActivitiesMapper;
import com.zzh.service.IActivitiesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动业务层实现类
 * @author 22505
 */
@Service("ActivitiesService")
public class ActivitiesService implements IActivitiesService {
    @Resource
    private IActivitiesMapper iActivitiesMapper;

    @Override
    public void insert(String theme,String start,String date,String number,String fee,String message,int leaderid) {
        iActivitiesMapper.insert(theme,start,date,number,fee,message,leaderid);
    }

    @Override
    public void delete(Activities activities) {

    }

    @Override
    public void edit(Activities activities) {

    }

    @Override
    public List<Activities> findAll() {
        return iActivitiesMapper.findAll();
    }

    @Override
    public Activities findById(int leaderid) {
        return iActivitiesMapper.findById(leaderid);
    }

    @Override
    public List<Activities> findByLid(int lid) {
        return iActivitiesMapper.findByLid(lid);
    }

    @Override
    public List<Integer> findActidByUid(int uid) {
        return iActivitiesMapper.findActidByUid(uid);
    }

    @Override
    public Activities findActById(int actId) {
        return iActivitiesMapper.findActById(actId);
    }

    @Override
    public Activities findByTheme(String theme) {
        return iActivitiesMapper.findByTheme(theme);
    }

    @Override
    public void deleteById(int actid) {
        iActivitiesMapper.deleteById(actid);
    }

    @Override
    public List<Activities> findActByIds(List<Integer> joiActId) {
        return iActivitiesMapper.findActByIds(joiActId);
    }

    @Override
    public void updateAct(int id,String number, String theme, String time, String start, String fee, String message) {
        iActivitiesMapper.updateAct(id,number,theme,time,start,fee,message);
    }

    @Override
    public void setupAct(int id) {
        iActivitiesMapper.setupAct(id);
    }

    @Override
    public void closeAct(int id) {
        iActivitiesMapper.closeAct(id);
    }

    @Override
    public List<Integer> findActidByTid(int teamid) {
        return iActivitiesMapper.findActidByTid(teamid);
    }

    @Override
    public int countUserByActId(int id) {
        return iActivitiesMapper.countUserByActId(id);
    }

    @Override
    public List<Integer> findFeeByIds1(List<Integer> joiActId) {
        return iActivitiesMapper.findFeeByIds1(joiActId);
    }

    @Override
    public List<Integer> findFeeByIds2(List<Integer> joiActId) {
        return iActivitiesMapper.findFeeByIds2(joiActId);
    }

    @Override
    public List<Integer> countAllUser(List<Integer> joiActId) {
        return iActivitiesMapper.countAllUser(joiActId);
    }

    @Override
    public int getZjperfee(int actId, int userId) {
        return iActivitiesMapper.getZjperfee(actId,userId);
    }

    @Override
    public void addZjperfee(int zjAfter,int actId,int userId) {
        iActivitiesMapper.addZjperfee(zjAfter,actId,userId);
    }

    @Override
    public void addAaperfee(int feePerUser,int actid) {
        iActivitiesMapper.addAaperfee(feePerUser,actid);
    }

    @Override
    public int getAaperfee(int actId, int uid) {
        return iActivitiesMapper.getAaperfee(actId,uid);
    }


    @Override
    public List<Activities> findActByIds1(List<Integer> joiActId) {
        return iActivitiesMapper.findActByIds1(joiActId);
    }

    @Override
    public List<Activities> findActByIds2(List<Integer> joiActId) {
        return iActivitiesMapper.findActByIds2(joiActId);
    }

}
