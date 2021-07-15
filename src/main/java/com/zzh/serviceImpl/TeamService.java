package com.zzh.serviceImpl;

import com.zzh.domain.Teams;
import com.zzh.mapper.ITeamMapper;
import com.zzh.service.ITeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamService implements ITeamService {
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

    @Override
    public Teams findByName(String name) {
        return iTeamMapper.findByName(name);
    }

    @Override
    public void addUser(int teamid, int userid) {
        iTeamMapper.addUser(teamid,userid);
    }

    @Override
    public Teams findById(int teamid) {
        return iTeamMapper.findById(teamid);
    }

    @Override
    public List<Integer> findUserIds(int teamId) {
        return iTeamMapper.findUserIds(teamId);
    }

    @Override
    public void addAct(int teamId, int actId) {
        iTeamMapper.addAct(teamId,actId);
    }
}
