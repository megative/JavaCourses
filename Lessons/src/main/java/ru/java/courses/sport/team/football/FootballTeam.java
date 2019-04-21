package ru.java.courses.sport.team.football;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FootballTeam {

    // Поля для Команды:
    // name - название команды
    // coach - тренер команды
    // players - игроки команды
    private String name;
    private Coach coach;
    private List<FootballPlayer> players = new ArrayList<>();

    // Конструктор команды (название)
    public FootballTeam(String name){

        setName(name);

    }

    // Геттер названия команды
    public String getName(){

        return name;

    }

    // Сеттер названия команды
    public void setName(String name) {

        if (name == null || name.isEmpty()) {

            throw new IllegalArgumentException("The team's name cannot be empty");

        }

        this.name = name;

    }

    // Геттер тренера команды
    public Coach getCoach() {

        return coach;

    }

    // Сеттер тренера команды
    public void setCoach(Coach coach) {

        this.coach = coach;

    }

    // Метод добавления игроков в команду
    public void addPlayer(FootballPlayer footballPlayer) {

        if (players.size() >= 20){

            throw new IllegalArgumentException("В команде не может быть больше, чем 20 игроков!");

        } else if (footballPlayer == null) {

            throw new IllegalArgumentException("Не выбран игрок для добавления в команду");

        } else players.add(footballPlayer);

    }

    // Метод удаления игрока из команды
    public void removePlayer(FootballPlayer footballPlayer) {

        if (players.size() < 1) {

            throw new IllegalArgumentException("Нельзя убрать игроков из команды, в которой нет игроков!");

        } else if (footballPlayer == null) {

            throw new IllegalArgumentException("Не выбран игрок для удаления из команды");

        } else players.remove(footballPlayer);

    }

    // Геттер количества игроков в команде
    public int getPlayersCount() {

        return players.size();

    }

    // Геттер забитых командой голов
    public int getScore() {

        int score = 0;
        for (FootballPlayer player: players) {

            score += player.getScore();

        }

        return score;

    }

    // Геттер игроков в команде
    public List<FootballPlayer> getPlayers() {

        return new ArrayList<>(players);

    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballTeam team = (FootballTeam) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(coach, team.coach) &&
                Objects.equals(players, team.players);
    }

    // Петеопределение метода hashcode
    @Override
    public int hashCode() {
        return Objects.hash(name, coach, players);
    }

    // Переопределяем преобразование объекта типа "Команда" в стоку
    @Override
    public String toString() {
        return "Команда: " +
                "Название: " + name +
                "Количество игроков: " + getPlayersCount() +
                "Игроки: " + players + '\'' +
                "Тренер: " + coach +
                "Голов забито: " + getScore();
    }
}
