package com.example.cricket;

public class CricketTeam {
    private String teamId;
    private String teamName;
    private int testRanking;
    private int odiRanking;
    private int t20Ranking;

    // Getters and Setters
    public String getTeamId() { return teamId; }
    public void setTeamId(String teamId) { this.teamId = teamId; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public int getTestRanking() { return testRanking; }
    public void setTestRanking(int testRanking) { this.testRanking = testRanking; }

    public int getOdiRanking() { return odiRanking; }
    public void setOdiRanking(int odiRanking) { this.odiRanking = odiRanking; }

    public int getT20Ranking() { return t20Ranking; }
    public void setT20Ranking(int t20Ranking) { this.t20Ranking = t20Ranking; }
}
