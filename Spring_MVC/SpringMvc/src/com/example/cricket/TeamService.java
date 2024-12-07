package com.example.cricket;

import java.util.HashMap;
import java.util.Map;

@Service
public class TeamService {
    private final Map<String, CricketTeam> teams = new HashMap<>();

    public void addTeam(CricketTeam team) {
        teams.put(team.getTeamId(), team);
    }

    public CricketTeam getTeam(String teamId) {
        return teams.get(teamId);
    }
}