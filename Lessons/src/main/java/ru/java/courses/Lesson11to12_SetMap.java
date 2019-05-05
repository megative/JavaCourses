package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Lesson11to12_SetMap {

    public static class User implements Comparable<User> {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age) {

            this.name = name;
            this.age = age;

        }

        public User(String phone) {

            this.phone = phone;

        }

        public String getName() {

            return name;

        }

        public void setName(String name) {

            this.name = name;

        }

        public int getAge() {

            return age;

        }

        public void setAge(int age) {

            this.age = age;

        }

        public String getPhone() {

            return phone;

        }

        public void setPhone(String phone) {

            this.phone = phone;

        }

        @Override
        public String toString() {

            return "User: " +
                    "name = '" + name + '\'' +
                    ", age = " + age +
                    ", phone = '" + phone + '\'' +
                    '}';

        }



        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(phone, user.phone);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age, phone);
        }

        @Override
        public int compareTo(User o) {
            if (name.equals(o.name)) {
                return Integer.compare(age,o.age);
            }
            return name.compareTo(o.name);
        }


    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {

        TreeSet<User> treeSet = new TreeSet<>(source);
        return treeSet.last();

    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {

        Map<String, String> hashMap = new HashMap<>();

        for (User user : source) {

            hashMap.put(user.getPhone(), user.toString());

        }

        return hashMap.size();

    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {

        Integer totalShelves = 5;
        List<String> booksList = source.stream().sorted().collect(Collectors.toList());
        Map<Integer, List<String>> hashMap = new HashMap<>();

        Integer shelveSize = booksList.size() / totalShelves;

        for (int shellNumber = 1; shellNumber < totalShelves; shellNumber++){

            hashMap.put(shellNumber, booksList.subList((shellNumber - 1) * shelveSize, shellNumber * shelveSize));
        }

        hashMap.put(totalShelves, booksList.subList((totalShelves - 1) * shelveSize, booksList.size()));

        return hashMap;

    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {

        Map<String, Integer> hashMap = new HashMap<>();

        for (Entry<Integer, String> entry : source.entrySet()) {

            hashMap.put(entry.getValue(),entry.getKey());

        }

        return hashMap;
    }

}
