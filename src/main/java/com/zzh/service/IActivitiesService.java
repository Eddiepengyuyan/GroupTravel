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

    List<Activities> findActByIds1(List<Integer> joiActId);

    List<Activities> findActByIds2(List<Integer> joiActId);

    List<Activities> findActByIds(List<Integer> joiActId);

    void updateAct(int id,String number, String theme, String time, String start, String fee, String message);

    void setupAct(int id);

    void closeAct(int id);

    List<Integer> findActidByTid(int teamid);

    int countUserByActId(int id);

    List<Integer> findFeeByIds1(List<Integer> joiActId);

    List<Integer> findFeeByIds2(List<Integer> joiActId);

    List<Integer> countAllUser(List<Integer> joiActId);

    int getZjperfee(int actId, int userId);

    void addZjperfee(int zjAfter, int actId, int userId);

    void addAaperfee(int feePerUser, int actid);
}
