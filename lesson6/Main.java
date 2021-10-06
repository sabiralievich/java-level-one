package ru.gb.lesson6;

public class Main {
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому
методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
(Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия
(бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.*/
public static void main(String[] args) {
   Animal cat = new Cat("Basilio");
   cat.run(100);
   cat.swim(8);
   Animal dog = new Dog("Sobaka Kachalova");
   dog.run(400);
   dog.swim(8);
   Animal dog1 = new Dog("Mu-Mu");
   dog1.swim(1);

   System.out.print("Total animals run in the race - " + Animal.animalCounter + ": ");
   System.out.println(countCats() + " cats and " + countDogs() + " dogs");
}

   private static int countCats() {
           int cats = 0;
      for (Animal buf : Animal.animals) {
            if (buf instanceof Cat) {
               cats++;
            }
      }
      return cats;
   }

   private static int countDogs() {
      int dogs = 0;
      for (Animal buf : Animal.animals) {
          if (buf instanceof Dog) {
            dogs++;
         }
      }
      return dogs;
   }


}
