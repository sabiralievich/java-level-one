package ru.gb;

/*
Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
(в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class TaskTwo {
    public static void main(String[] args) {
            PhoneBook pb = new PhoneBook();
            pb.add("+79013893933", "Sid");
            pb.get("Peter");
            pb.get("Sid");
    }
}
