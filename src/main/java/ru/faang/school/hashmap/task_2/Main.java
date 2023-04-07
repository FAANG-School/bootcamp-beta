package ru.faang.school.hashmap.task_2;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.printAllBooksAndPositions();

        main.addNewBookAndItsPosition(  new Book("Sapiens", "Hararri", 2004), "1");
        main.removeABook(new Book("Mr. Mersedes", "King", 2001));
        main.getPosition(new Book("Финансист", "Драйзер", 1920));
        main.printAllBooksAndPositions();
    }

    public static Map<Book, String> map = Map.of(
            new Book("Mr. Mersedes", "King", 2001), "2",
            new Book("Бегущий за ветром", "Хоссейни", 2005), "1",
            new Book("Финансист", "Драйзер", 1920), "4"
    );

    public void addNewBookAndItsPosition(Book newBook, String position) {
        System.out.println("************************************");
        System.out.println("Добавление новой книги: " + newBook + " и ее позиции: " + position);
        map.put(newBook, position);
    }

    public void removeABook(Book book) {
        System.out.println("************************************");
        System.out.println("Удаление из мапы книги по ключу:" + book);
        map.remove(book);
    }

    public void getPosition(Book book) {
        System.out.println("************************************");
        System.out.println("Поиск книги и вывод информации о позиции: " + book);
        String position = map.get(book);
        System.out.println("Position is: " + position);
    }

    public void printAllBooksAndPositions() {
        System.out.println("************************************");
        System.out.println("Получаем список всех книг и их позиций:");
        for(Map.Entry<Book, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

