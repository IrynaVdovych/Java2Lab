//оголошення пакету
package com.example.lab2;
//імпорт класу car з пакету com.example.car
import com.example.car.Car;
import com.github.javafaker.Faker;

import java.util.ArrayList;

public class main {

    //
    public static void main(String[] args) {
        //оголошення динамічного списку елементів класу Car
        ArrayList<Car> cararr = new ArrayList<Car>();

        //виклик методу ініціалізація масиву
        initCarList(cararr, 10);
        System.out.println("Автомобілі в базі:");
        showCars(cararr);

        //пункт A
        task1(cararr);

        //пункт B
        task2(cararr);

        //пункт C
        task3(cararr);
    }

    /**
     * task1
     *
     * @param cararr list of cars
     */
    private static void task1(ArrayList<Car> cararr) {
        //оголошення рядкової змінної model з ініціалізацією значенням Audi
        String model = "Audi";
        System.out.println("Автомобілі марки " + model + ":");
        //виклик методу, який показує всі елементи масиву у яких поле model = Audi
        showCars(getModelList(cararr, model));
    }

    /**
     * task2
     *
     * @param cararr list of cars
     */
    private static void task2(ArrayList<Car> cararr) {
        //оголошення рядкової змінної model з ініціалізацією значенням Audi
        String model = "Audi";
        //оголошення цілочисельної змінної age з ініціалізацією значенням 10
        int age = 10;
        System.out.println("Автомобілі марки " + model + ", які старші за " + age + " років:");
        //виклик методу, що показує всі машини моделі Audi віком старше 10 років
        showCars(getModelAgeList(cararr, model, age));
    }

    /**
     * task3
     *
     * @param cararr list of cars
     */
    private static void task3(ArrayList<Car> cararr) {
        //оголошення цілочисельної змінної year з ініціалізацією значення 2015
        int year = 2015;
        //оголошення цілочисельної змінної price з ініціалізацією значення 20000
        int price = 20000;
        System.out.println("Автомобілі " + year + " року випуску, які дорожчі за " + price + " доларів:");
        //виклик методу, що показує усі елементи масиву зі значенням поля year = 2015 і ціною що перевищує 20000
        showCars(getYearPriceList(cararr, year, price));
    }

    /**
     * method returns list of cars where year is equal to param year and price is greater or equal to param price
     *
     * @param cararr list of cars
     * @param year   value of minimal year
     * @param price  value of minimal price
     * @return list of cars
     */
    //метод показує елементи масиву cararr зі значенням поля year = параметру year і поля price >=параметру price
    private static ArrayList<Car> getYearPriceList(ArrayList<Car> cararr, int year, int price) {

        if(year < 1950)  {
            System.out.println("Автомобілі до цього року не випускались");
            return new ArrayList<Car>();
        }

        if(price < 1000)  {
            System.out.println("Вказана занадто низька ціна для пошуку");
            return new ArrayList<Car>();
        }

        //для збереження результатів пошуку
        ArrayList<Car> arr = new ArrayList<Car>();
        //цикл пробігається по елементах масиву cararr
        for(Car c : cararr) {
            //якщо виконуються умови над полями елементу масиву, то
            if (c.getYear() == year && c.getPrice() >= price) {
                //додаємо елемент до результуючого масиву
                arr.add(c);
            }
        }
        return arr;
    }

    /**
     * method returns list of cars where model name contains param model and age is greater or equal to param age
     *
     * @param cararr list of cars
     * @param model  name of the model
     * @param age    minimal age of car
     * @return list of cars
     */
    private static ArrayList<Car> getModelAgeList(ArrayList<Car> cararr, String model, int age) {
        if(age < 0)  {
            System.out.println("Вік не має бути відʼємним числом");
            return new ArrayList<Car>();
        }
        //для збереження результатів пошуку
        ArrayList<Car> arr = new ArrayList<Car>();
        //цикл пробігається по елементах масиву cararr
        for(Car c : cararr) {
            //якщо виконуються умови над полями елементу масиву, то
            if(c.getModel().contains(model) && c.getAge() >= age) {
                //додаємо елемент до результуючого масиву
                arr.add(c);
            }
        }
        return arr;
    }

    /**
     * method returns list of cars where model name contoins param model
     *
     * @param cararr list of car
     * @param model name of the model
     * @return list of car
     */
    private static ArrayList<Car> getModelList(ArrayList<Car> cararr, String model) {
        //для збереження результатів пошуку
        ArrayList<Car> arr = new ArrayList<Car>();
        //цикл пробігається по елементах масиву cararr
        for(Car c : cararr) {
            //якщо виконуються умови над полями елементу масиву, то
            if(c.getModel().contains(model)) {
                //додаємо елемент до результуючого масиву
                arr.add(c);
            }
        }
        return arr;
    }

    /**
     * fill array list car with exemplars of class car
     *
     * @param cararr list of cars
     * @param n quantity of cars
     *
     */
    //метод заповнює елементи масиву cararr екземплярами класу car
    private static void initCarList(ArrayList<Car> cararr, int n) {
        Faker faker = new Faker();

        String[] models = {"Audi", "BMW", "Volkswagen", "Dodge", "Kia", "Lexus"};
        for(int k = 0; k < n; k++) {
            int id = faker.number().numberBetween(1, 1000000);
            String model = models[faker.number().numberBetween(0, 5)];
            int year = faker.number().numberBetween(2000, 2022);
            int price = faker.number().numberBetween(1, 1000) * 1000;
            String reg_numb = faker.lorem().characters(2).toUpperCase() + " " + faker.number().digits(4);
            //створюємо екземпляр класу Car з усіма заповненими полями і записуємо у масив
            cararr.add(new Car(id, model, year, price, reg_numb));
        }
    }

    /**
     * print all elements of array arr into console
     *
     * @param arr list of cars
     */
    public static void showCars(ArrayList<Car> arr) {
        for(Car c : arr) {
            //виводимо елемент масиву в консоль
            System.out.println(c);
        }
    }

}
