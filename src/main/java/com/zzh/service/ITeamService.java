package com.zzh.service;

import com.zzh.domain.Teams;

import java.util.List;

public interface ITeamService {
    List<Teams> findAllTeams();

    void addTeam(int leaderId, String name, String message);
}
