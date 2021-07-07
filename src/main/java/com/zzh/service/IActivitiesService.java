package com.zzh.service;

import com.zzh.domain.Activities;

import java.util.List;

/**
 * 活动业务层接口
 */
public interface IActivitiesService {

    void insert(String theme,String start,String date,String number,String fee,String message,int leaderid);
    void delete(Activities activities);
    void edit(Activities activities);
    List<Activities> findAll();
    Activities findById(int leaderid);

    List<Activities> findByLid(int lid);

    List<Integer> findActidByUid(int uid);

    Activities findActById(int actId);

    Activities findByTheme(String theme);

    void deleteById(int actid);
}
