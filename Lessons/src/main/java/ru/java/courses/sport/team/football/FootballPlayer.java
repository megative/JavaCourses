package ru.java.courses.sport.team.football;

import java.util.Objects;

public class FootballPlayer extends PlayerBuilder {

    // Поля для Игрока:
    // name - имя игрока
    // goals - голы игрока
    // role - роль игрока
    // active - статус активности игрока
    // age - возраст игрока
    private String name;
    private int goals;
    private PlayerRole role;
    private boolean active;
    private int age;

    // Получаем информацию об игроке как строку
    @Override
    public String toString() {
        return "Игрок: " +
                "Имя: " + name +
                "Количество голов: " + getGoals() +
                "Роль: " + getRole() + '\'' +
                "Статус: " + isActive()+
                "Возраст: " + getAge();
    }

    // Конструктор игрока (имя + роль)
    public FootballPlayer(String name, PlayerRole role) {

        setName(name);
        setRole(role);
        setActive(true);

    }

    // Конструктор игрока (имя)
    public FootballPlayer(String name) {

        setName(name);
        setActive(true);

    }

    // Метод получения возраста игрока
    public int getAge() {

        return age;

    }

    // Метод установки возраста игрока
    public void setAge(int age) {

        this.age = (age < 18) ? 18 : age;

    }

    // Метод получения статуса активности игрока
    private boolean isActive(){

        return active;

    }

    // Метод установки статуса активности игрока
    public void setActive(boolean active) {

        this.active = active;

    }

    // Геттер имени игрока
    public String getName() {

        return name;

    }

    // Сеттер имени игрока
    public void setName(String name) {

        if (name == null || name.isEmpty()) {

            throw new IllegalArgumentException("Значение \"Имя\" не может быть пустым");

        }

        this.name = name;

    }

    // Метод "забивания гола"
    public void score() {
        if (isActive()) {
            goals++;
        } else {
            throw new IllegalArgumentException("Только активный игрок может забивать голы!");
        }
    }

    // Геттер количества голов
    int getScore(){

        return goals;

    }

    // Сеттер количества голов
    public int getGoals() {

        return goals;

    }

    //  Геттер роли игрока
    public PlayerRole getRole() {

        return role;

    }

    // Сеттер роли игрока
    public void setRole(PlayerRole role) {

        if (role == null) {

            throw new IllegalArgumentException("Значение \"Роль\" не может быть пустым");

        }

        this.role = role;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer player = (FootballPlayer) o;
        return goals == player.goals &&
                active == player.active &&
                age == player.age &&
                Objects.equals(name, player.name) &&
                role == player.role &&
                Objects.equals(playerBuilder, player.playerBuilder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, goals, role, active, age, playerBuilder);
    }

    @Override
    public void buildNationality() {

        builtPlayer.setNationality("ENG");


    }

    @Override
    public void buildGender() {
        builtPlayer.setGender("M");

    }

    @Override
    public void buildLeague() {

        builtPlayer.setLeague("HIGH");

    }

    private PlayerBuilder playerBuilder;

    public void setPlayerBuilder(PlayerBuilder builtPlayer) {

        this.playerBuilder = builtPlayer;

    }

    public PlayerPattern getNewBuildPlayer() {


        return playerBuilder.getBuiltPlayer();

    }

    public void constructPlayer() {
        playerBuilder.createPatternPlayer();
        playerBuilder.buildNationality();
        playerBuilder.buildGender();
        playerBuilder.buildLeague();
    }

}