package ru.java.courses.sport.team.football;

public class ScoringPlayer {

    // Поля для игрока:
    // name - имя игрока
    // goals - количество забитых голов
    // role - роль
    // active - статус активности
    private String name;
    private Byte goals;
    private Role role;
    private Boolean active;

    // Проверка на активность
    public Boolean isActive() {
        return active;
    }

    // Метод "забивания гола"
    public void score(){
        if (isActive()) {
            goals++;
        } else {
            throw new UnsupportedOperationException("Запасные игроки не могут забивать голы");
        }
    }

    // Геттер количества забитых игроком мячей
    public byte getScore() {
        return goals;
    }

    // Геттер роли игрока
    public Role getRole() {
        return role;
    }

    // Сеттер роли игрока
    public void setRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Значение параметра Роль не может быть пустым");
        }
       this.role = role;
    }

    // Геттер имени игрока
    public String getName() {
        return name;
    }

    // Сеттер имени игрока
    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Значение Имя не может быть пустым");
        }
        this.name = name;
    }

    // Переопределяем преобразование объекта типа "Игрок" в стоку
    @Override
    public String toString() {
        return "Игрок: " +
                "Имя: " + name + '\'' +
                "Голов забито: " + goals +
                "Роль: " + role +
                "Статус активности: " + (active ? ("На поле") : ("На скамейке запасных"));
    }
}
