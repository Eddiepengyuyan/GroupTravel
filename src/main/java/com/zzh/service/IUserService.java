package com.zzh.service;

import com.zzh.domain.User;

import java.util.List;

public interface IUserService {

    void insert(String username,String password,String realname,String number);
    int findIdByName(String name);

    User findByUsername(String username);
    User findById(int id);

    List<Integer> findIdByActid(int actid);

    void addUser(int actid, int uid);
}
