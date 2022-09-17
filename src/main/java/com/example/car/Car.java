//оголошення пакету
package com.example.car;

import java.time.Year;

/**
 * this class describes cars
 */
public class Car {
    private final int id;
    private String model;
    private int year;
    private int price;
    private String reg_number;


    /**
     * @param id identificator of element
     */
    public Car(int id) {
        this.id = id;
    }

    /**
     * @param id identificator of element
     * @param model name of the car model
     * @param year year of car issue
     * @param price market price of car
     * @param reg_number register number of car
     */
    public Car(int id, String model, int year, int price, String reg_number) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.reg_number = reg_number;
    }

    //метод повертає значення поля model
    public String getModel() {
        return model;
    }

    //метод встановлює занчення поля model
    public void setModel(String model) {
        this.model = model;
    }

    //метод повертає значення поля year
    public int getYear() {
        return year;
    }

    //метод встановлює занчення поля year
    public void setYear(int year) {
        this.year = year;
    }

    //метод повертає значення поля price
    public int getPrice() {
        return price;
    }
    //метод встановлює занчення поля price
    public void setPrice(int price) {
        this.price = price;
    }

    //метод повертає значення поля model на reg_number
    public String getReg_number() {
        return reg_number;
    }

    //метод встановлює занчення поля reg_number
    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    //перевизначаємо системний метод toString щоб зручно показати клас функцією println (або print)
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", reg_number='" + reg_number + '\'' +
                '}';
    }

    /**
     * @return age of car
     */
    //метод повертає розрахунковий вік автомобіля
    public int getAge() {
        Year year = Year.now();
        return year.getValue() - this.year;
    }
}


