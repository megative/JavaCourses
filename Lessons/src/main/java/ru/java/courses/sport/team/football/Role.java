package ru.java.courses.sport.team.football;

public class Role {

    // Поля для роли:
    // role - роль
    private String role;

    // Конструктор класса "Роль"
    Role(String role) {

        switch (role){
            case "DEFENDER":
                this.role = "Защитник";
                break;

            case "GOALKEEPER":
                this.role = "Вратарь";
                break;

            case "WINGER":
                this.role = "Нападающий";
                break;

            default:
                throw new IllegalArgumentException("Неверное значение аргумента Role");
        }
    }

    // Геттер роли
    public String getRole() {
        return role;
    }

}
