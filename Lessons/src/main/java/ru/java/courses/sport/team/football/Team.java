package ru.java.courses.sport.team.football;

import java.util.ArrayList;

public class Team {

    // Поля для команды:
    // players - игроки (массив объектов типа ScoringPlayers) команды
    // name - название команды
    // coach - тренер команды
    private ArrayList<ScoringPlayer> players = new ArrayList<>();
    private String name;

    private Coach coach;

    // Метод добавления игроков в команду
    public void addPlayers(ScoringPlayer scoringPlayer) {
        if (players.size() > 20){
            throw new IllegalArgumentException("В команде не может быть больше 20 игроков");
        } else {
            players.add(scoringPlayer);
        }
    }

    // Метод удаления игроков из команды
    public void removePlayers(ScoringPlayer scoringPlayer) {
        if (players.size() < 0) {
            throw new IllegalArgumentException("В команде отсутствуют игроки, удалить игроков нельзя");
        } else {
            players.remove(scoringPlayer);
        }
    }

    // Метод получения игроков количества игроков в команде
    public int getPlayersCount() {
        return players.size();
    }

    // Метод получения количества забитых командой голов
    public byte getScore() {
        byte score = 0;

        for (int i=0; i - players.size() == 0; i++) {
            score += players.get(i).getScore();
        }
        return score;
    }

    // Метод получения названия команды
    public String getName() {
        return name;
    }

    // Метод установления названия команды
    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Название команды не может быть пустым");
        }
        this.name = name;
    }

    // Метод получения тренера команды
    public Coach getCoach() {
        return coach;
    }

    // Метод установления тренера команды
    public void setCoach(Coach coach) {
        if (coach == null) {
            throw new IllegalArgumentException("Значение Тренер не может быть пустым");
        }
        this.coach = coach;
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
