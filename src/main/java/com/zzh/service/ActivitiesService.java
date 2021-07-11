package com.zzh.service;

import com.zzh.domain.Activities;
import com.zzh.mapper.IActivitiesMapper;
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

}
