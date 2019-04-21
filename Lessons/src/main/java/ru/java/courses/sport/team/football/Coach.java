package ru.java.courses.sport.team.football;

import java.util.Objects;

public class Coach {

    // Поля для тренера:
    // name - имя тренера
    // experience - опыт тренера
    private int experience;
    private String name;

    // Конструкторы класса Coach

    public Coach(String name, int experience){
        setExperience(experience);
        setName(name);
    }

    public Coach(String name){
        setName(name);
    }

    // Геттер имени тренера
    public String getName() {
        return name;
    }

    // Сеттер имени тренера
    public void setName(String name) {
        if ((name == null)||(name.isEmpty())) {
            throw new IllegalArgumentException("Значение \"Имя\" не может быть пустым");
        }
        this.name = name;
    }

    // Геттер опыта тренера
    public int getExperience() {
        return experience;
    }

    // Сеттер Опыта тренера
    public void setExperience(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("Значение \"Опыт\" не может быть отрицательным");
        }
        this.experience = experience;
    }

    // Переопределяем преобразование объекта типа "Тренер" в стоку
    @Override
    public String toString() {
        return "Тренер: " +
                "Имя: " + name + '\'' +
                "Опыт: " + experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return experience == coach.experience &&
                Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience, name);
    }
}
