package ru.gb;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
 */
public class TaskOne {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(
                Arrays.asList("Да", "очень", "беспокоит", "меня", "беспокоит", "и", "на", "то", "дан",
                        "разум", "чтобы", "избавиться", "стало", "быть", "надо", "избавиться", "беспокоит"));
        Set<String> unique = new HashSet<>(words);
        words.clear();
        System.out.println(unique);
    }
}
