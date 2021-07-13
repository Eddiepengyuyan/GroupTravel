package com.zzh.service;

import com.zzh.domain.Teams;
import com.zzh.mapper.ITeamMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamService implements ITeamService{
    @Resource
    private ITeamMapper iTeamMapper;

    @Override
    public List<Teams> findAllTeams() {
        return iTeamMapper.findAllTeams();
    }

    @Override
    public void addTeam(int leaderId, String name, String message) {
        iTeamMapper.addTeam(leaderId,name,message);
    }

    @Override
    public List<Teams> findByLeaderId(int uid) {
        return iTeamMapper.findByLeaderId(uid);
    }

    @Override
    public List<Teams> findAllTeamsAndLeaders() {
        return iTeamMapper.findAllTeamsAndLeaders();
    }
}
