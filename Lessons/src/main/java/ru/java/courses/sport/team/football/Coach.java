package ru.java.courses.sport.team.football;

public class Coach {

    // Поля для тренера:
    // name - имя тренера
    // experience - опыт тренера
    private String name;
    private Byte experience;

    // Геттер имени тренера
    public String getName() {
        return name;
    }

    // Сеттер имени тренера
    public void setName(String name) {
        if ((name == null)||(name.isEmpty())) {
            throw new IllegalArgumentException("Значение Имя не может быть пустым");
        }
        this.name = name;
    }

    // Геттер опыта тренера
    public Byte getExperience() {
        return experience;
    }

    // Сеттер Опыта тренера
    public void setExperience(Byte experience) {
        this.experience = experience;
    }

    // Переопределяем преобразование объекта типа "Тренер" в стоку
    @Override
    public String toString() {
        return "Тренер: " +
                "Имя: " + name + '\'' +
                "Опыт: " + experience;
    }
}
