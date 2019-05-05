package ru.java.courses.sport.team.football;

public class PlayerPatternIUsage {

    public static void main(String[] args) {

        FootballPlayer player = new FootballPlayer("test", PlayerRole.DEFENDER);
        PlayerBuilder superFootballMan = new FootballPlayer("test", PlayerRole.DEFENDER);
        player.setPlayerBuilder(superFootballMan);
        player.constructPlayer();

        PlayerPattern playerPattern = player.getNewBuildPlayer();
    }
}
