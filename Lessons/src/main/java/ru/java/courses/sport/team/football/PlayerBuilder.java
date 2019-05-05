package ru.java.courses.sport.team.football;

abstract class PlayerBuilder {

    protected PlayerPattern builtPlayer;

    public PlayerPattern getBuiltPlayer() {
        return builtPlayer;
    }

    public void createPatternPlayer() {
        builtPlayer = new PlayerPattern();
        System.out.println(builtPlayer);
    }

    public abstract void buildNationality();
    public abstract void buildGender();
    public abstract void buildLeague();
}
