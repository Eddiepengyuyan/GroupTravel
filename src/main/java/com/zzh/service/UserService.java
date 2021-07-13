package com.zzh.service;

import com.zzh.domain.User;
import com.zzh.mapper.IUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 22505
 */
@Service
public class UserService implements IUserService{

    @Resource
    private IUserMapper iUserMapper;

    @Override
    public User findById(int id){
        return iUserMapper.findById(id);
    }

    @Override
    public List<Integer> findIdByActid(int actid) {
        return iUserMapper.findIdByActid(actid);
    }

    @Override
    public void insert(String username, String password, String realname, String number) {
        iUserMapper.insert(username,password,realname,number);
    }

    @Override
    public int findIdByName(String name) {
        return iUserMapper.findIdByName(name);
    }

    @Override
    public User findByUsername(String username) {
        User user = iUserMapper.findByUsername(username);
        return user;
    }

    @Override
    public void addUser(int actid, int uid) {
        iUserMapper.addUser(actid,uid);
    }

    @Override
    public List<User> findByids(List<Integer> userIds) {
        return iUserMapper.findByIds(userIds);
    }

}
