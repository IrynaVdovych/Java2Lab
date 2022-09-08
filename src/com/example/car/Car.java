//оголошення пакету
package com.example.car;

//оголошення класу Сar
public class Car {
    private int id;
    private String model;
    private int year;
    private int price;
    private String reg_number;

    //конструктор, який заповнює поле id
    public Car(int id) {
        this.id = id;
    }

    //конструктор що запонвнює всі поля
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

    //метод повертає розрахунковий вік автомобіля
    public int getAge() {
        return 2022 - this.year;
    }
}


