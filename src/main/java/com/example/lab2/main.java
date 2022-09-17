//оголошення пакету
package com.example.lab2;
//імпорт класу car з пакету com.example.car
import com.example.car.Car;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class main {

    //
    public static void main(String[] args) {
        //оголошення масиву з 10 елементів класу Сar
        Car[] cararr = new Car[10];
        //виклик методу ініціалізація масиву
        initCarArray(cararr);
        System.out.println("Автомобілі в базі:");
        showCars(cararr);

        //пункт A
        //оголошення рядкової змінної model з ініціалізацією значенням Audi
        String model = "Audi";
        System.out.println("Автомобілі марки " + model + ":");
        //виклик методу, який показує всі елементи масиву у яких поле model = Audi
        showCars(getModelList(cararr, model));

        //пункт B
        //оголошення цілочисельної змінної age з ініціалізацією значенням 10
        int age = 10;
        System.out.println("Автомобілі марки " + model + ", які старші за " + age + " років:");
        //виклик методу, що показує всі машини моделі Audi віком старше 10 років
        showCars(getModelAgeList(cararr, model, age));

        //пункт C
        //оголошення цілочисельної змінної year з ініціалізацією значення 2015
        int year = 2015;
        //оголошення цілочисельної змінної price з ініціалізацією значення 20000
        int price = 20000;
        System.out.println("Автомобілі " + year + " року випуску, які дорожчі за " + price + " доларів:");
        //виклик методу, що показує усі елементи масиву зі значенням поля year = 2015 і ціною що перевищує 20000
        showCars(getYearPriceList(cararr, year, price));

    }

    /**
     * @param cararr array of cars
     * @param year   value of minimal year
     * @param price  value of minimal price
     * @return
     */
    //метод показує елементи масиву cararr зі значенням поля year = параметру year і поля price >=параметру price
    private static Car[] getYearPriceList(Car[] cararr, int year, int price) {

        if(year < 1950)  {
            System.out.println("Автомобілі до цього року не випускались");
            return cararr;
        }

        if(price < 1000)  {
            System.out.println("Вказана занадто низька ціна для пошуку");
            return cararr;
        }

        //для збереження результатів пошуку
        Car[] arr = new Car[cararr.length];
        //лічильник знайдених елементів
        int nmbCars = 0;
        //цикл пробігається по елементах масиву cararr
        for(Car c : cararr) {
            //якщо виконуються умови над полями елементу масиву, то
            if (c.getYear() == year && c.getPrice() >= price) {
                //додаємо елемент до результуючого масиву
                arr[nmbCars] = cararr[nmbCars];
                nmbCars++;
            }
        }
        return Arrays.copyOf(arr, nmbCars);
    }

    /**
     * @param cararr array of cars
     * @param model  name of the model
     * @param age    minimal age of car
     * @return
     */
    private static Car[] getModelAgeList(Car[] cararr, String model, int age) {
        if(age < 0)  {
            System.out.println("Вік не має бути відʼємним числом");
            return cararr;
        }
        //для збереження результатів пошуку
        Car[] arr = new Car[cararr.length];
        //лічильник знайдених елементів
        int nmbCars = 0;
        //цикл пробігається по елементах масиву cararr
        for(Car c : cararr) {
            //якщо виконуються умови над полями елементу масиву, то
            if(c.getModel().equals(model) && c.getAge() >= age) {
                //додаємо елемент до результуючого масиву
                arr[nmbCars] = cararr[nmbCars];
                nmbCars++;
            }
        }
        return Arrays.copyOf(arr, nmbCars);
    }

    /**
     * @param cararr array of car
     * @param model name of the model
     * @return array of car with the same model
     */
    private static Car[] getModelList(Car[] cararr, String model) {
        //для збереження результатів пошуку
        Car[] arr = new Car[cararr.length];
        //лічильник знайдених елементів
        int nmbCars = 0;
        //цикл пробігається по елементах масиву cararr
        for(Car c : cararr) {
            //якщо виконуються умови над полями елементу масиву, то
            if(c.getModel().equals(model)) {
                //додаємо елемент до результуючого масиву
                arr[nmbCars] = cararr[nmbCars];
                nmbCars++;
            }
        }
        return Arrays.copyOf(arr, nmbCars);
    }


    /**
     * @param cararr array of cars
     */
    //метод заповнює елементи масиву cararr екземплярами класу car
    private static void initCarArray(Car[] cararr) {
        Faker faker = new Faker();

        String[] models = {"Audi", "BMW", "Volkswagen", "Dodge", "Kia", "Lexus"};
        for(int k = 0; k < 10; k++) {
            int id = faker.number().numberBetween(1, 1000000);
            String model = models[faker.number().numberBetween(0, 5)];
            int year = faker.number().numberBetween(2000, 2022);
            int price = faker.number().numberBetween(1, 1000) * 1000;
            String reg_numb = faker.lorem().characters(2).toUpperCase() + " " + faker.number().digits(4);
            //створюємо екземпляр класу Car з усіма заповненими полями і записуємо у масив
            cararr[k] = new Car(id, model, year, price, reg_numb);
        }
    }

    /**
     * @param arr array of cars
     */
    public static void showCars(Car[] arr) {
        for(Car c : arr) {
            //виводимо елемент масиву в консоль
            System.out.println(c);
        }
    }

}
