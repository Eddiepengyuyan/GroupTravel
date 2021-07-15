package com.zzh.service;

import com.zzh.domain.Teams;

import java.util.List;

public interface ITeamService {
    List<Teams> findAllTeams();

    void addTeam(int leaderId, String name, String message);

    List<Teams> findByLeaderId(int uid);

    List<Teams> findAllTeamsAndLeaders();

    Teams findByName(String name);

    void addUser(int teamid, int userid);

    Teams findById(int teamid);

    List<Integer> findUserIds(int teamId);

    void addAct(int teamId, int actid);
}
