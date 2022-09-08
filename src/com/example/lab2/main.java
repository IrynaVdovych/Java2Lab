//оголошення пакету
package com.example.lab2;
//імпорт класу car з пакету com.example.car
import com.example.car.Car;

public class main {
    public static void main(String[] args) {
        //оголошення масиву з 10 елементів класу Сar
        Car[] cararr = new Car[10];
        //виклик методу ініціалізація масиву
        initCarArray(cararr);

        //пункт A
        //оголошення рядкової змінної model з ініціалізацією значенням Audi
        String model = "Audi";
        //виклик методу, який показує всі елементи масиву у яких поле model = Audi
        showModelList(cararr, model);

        //пункт B
        //оголошення цілочисельної змінної age з ініціалізацією значенням 10
        int age = 10;
        //виклик методу, що показує всі машини моделі Audi віком старше 10 років
        showModelAgeList(cararr, model, age);

        //пункт C
        //оголошення цілочисельної змінної year з ініціалізацією значення 2015
        int year = 2015;
        //оголошення цілочисельної змінної price з ініціалізацією значення 20000
        int price = 20000;
        //виклик методу, що показує усі елементи масиву зі значенням поля year = 2015 і ціною що перевищує 20000
        showYearPriceList(cararr, year, price);

    }

    //метод показує елементи масиву cararr зі значенням поля year = параметру year і поля price >=параметру price
    private static void showYearPriceList(Car[] cararr, int year, int price) {
        System.out.println("Автомобілі " + year + " року випуску, які дорожчі за " + price + " доларів:");
        //цикл з індексом k від 0 до довжини масиву (не включно)
        for(int k = 0; k < cararr.length; k++) {
            //у змінну типу car зчитуємо k-тий ел. масиву
            Car c = cararr[k];
            //якщо виконуються умови над полями елементу масиву, то
            if (c.getYear() == year && c.getPrice() >= price) {
                //виводимо елемент масиву в консоль
                System.out.println(c);
            }
        }
    }

    //метод показує елементи масиву cararr зі значенням поля model = параметру model і віком >= парметру age
    private static void showModelAgeList(Car[] cararr, String model, int age) {
        System.out.println("Автомобілі марки " + model + ", які старші за " + age + " років:");
        //цикл з індексом k, що пробігається по елементах масиву
        for(int k = 0; k < cararr.length; k++) {
            //у змінну типу car зчитуємо k-тий ел. масиву
            Car c = cararr[k];
            //якщо виконуються умови над полями елементу масиву, то
            if(c.getModel() == model && c.getAge() >= age) {
                //виводимо елемент масиву в консоль
                System.out.println(c);
            }
        }
    }

    //метод показує елементи масиву cararr зі значенням поля model = параметру model
    private static void showModelList(Car[] cararr, String model) {
        System.out.println("Автомобілі марки " + model + ":");
        //цикл з індексом k, що пробігається по елементах масиву cararr
        for(int k = 0; k < cararr.length; k++) {
            //у змінну типу car зчитуємо k-тий ел. масиву
            Car c = cararr[k];
            //якщо виконуються умови над полями елементу масиву, то
            if(c.getModel() == model) {
                //виводимо елемент масиву в консоль
                System.out.println(c);
            }
        }
    }

    //метод заповнює елементи масиву cararr екземплярами класу car
    private static void initCarArray(Car[] cararr) {
        //створюємо екземпляр класу Car з порожніми полями окрім id
        Car c = new Car(1);
        //встановлюємо значення поля model
        c.setModel("Audi");
        //встановлюємо значення поля year
        c.setYear(2001);
        //встановлюємо значення поля price
        c.setPrice(5000);
        //встановлюємо значення поля reg_number
        c.setReg_number("AA 1218 MX");
        //записуємо екзамепляр класу як перший елемент масиву cararr
        cararr[0] = c;

        //створюємо екземпляр класу Car з усіма заповненими полями і записуємо у другий елемент масиву і тд
        cararr[1] = new Car(2, "BMW", 2004, 10000, "AA 1210 KH");
        cararr[2] = new Car(3, "Volkswagen", 2010, 15000, "AA 1871 TH");
        cararr[3] = new Car(4, "Dodge", 2008, 8000, "AA 1100 BA");
        cararr[4] = new Car(5, "Kia", 2020, 20000, "AA 8872 KM");
        cararr[5] = new Car(6, "Mitsubishi", 2001, 4000, "BC 1222 KA");
        cararr[6] = new Car(7, "Honda", 2007, 6000, "BC 7777 MM");
        cararr[7] = new Car(8, "Lexus", 2022, 30000, "BC 9876 AC");
        cararr[8] = new Car(9, "Audi", 2015, 120000, "BC 1210 KH");
        cararr[9] = new Car(10, "Ford", 2015, 13000, "BC 5674 KC");
    }

}
