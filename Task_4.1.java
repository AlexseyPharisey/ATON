package Task_5;
import java.util.Random;
public class Test_1 {
    public static void main(String[] args){
        //Генерация рандомного кол-ва вагонов
        int N = (int)(Math.random() * 100);
        //Создание объекта класса поезд
        Train newTrain = new Train(N);
        //Генерация вкл/выкл света в вагонах
        newTrain.InputArrayCars();
        //Вывод поезда
        newTrain.OutputArrayCars();
        //Создание объекта man класса People_Control
        People_Control newMan = new People_Control(newTrain.ArrayCars, N);
        //Запуск функции обхода
        newMan.ManWalk();
    }
}
class Train{
    //Объявление начального кол-ва вагонов и массива вагонов
    public int volumeTrainCars = 0;
    public double []ArrayCars;
    //Получение рандомного кол-ва вагонов и создание массива
    Train(int N){
        this.volumeTrainCars = N;
        ArrayCars = new double[this.volumeTrainCars];
    }
    //Метод генерации света в вагонах
    public void InputArrayCars(){
        //Создание объекта рандома для лучшей генерации чисел от 0 до 1
        Random myRandom = new Random();
        for(int i = 0; i<volumeTrainCars; i++){
            ArrayCars[i] = Math.round(myRandom.nextDouble());
        }
    }
    //Метод вывода вагонов
    public void OutputArrayCars(){
        //Переменные для подсчета вкл/выкл света
        int kol_1 = 0;
        int kol_0 = 0;
        System.out.println();
        System.out.println("BEFORE: ");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Train cars: ");
        //Цикл вывода вагонов и подсчета света
        for(int i = 0; i<volumeTrainCars; i++){
            if (ArrayCars[i] == 0) kol_0++;
            if (ArrayCars[i] == 1) kol_1++;
            String result = String.format("%.0f", ArrayCars[i]);
            System.out.printf(result + " ");
        }
        System.out.println("\n");
        System.out.println("Number of cars with lights off = " + kol_0);
        System.out.println("Number of cars with lights on = " + kol_1);
        System.out.println();
    }
}
class People_Control{
    //Переменные - длина поезда, массив вагонов и начало обхода
    public int Length = 0;
    public double []ArrayCars;
    public int StartR = 0;
    //Получение рандомного кол-ва вагонов и передача готового массива вагонов
    People_Control(double[] array, int N){
        this.Length = N;
        ArrayCars = array;
    }
    //Метод генерации рандомного стартового вагона
    public int RandomStartGeneration(int a){
        for (int i = 0; i < Length; i++) {
            //Стартовый вагон должен быть меньше чем общее кол-во вагонов
            a = (int)(Math.random()*90);
            if(a < Length) break;
            else a = 0;
        }
        return a;
    }
    //Метод обхода проверяющего
    public void ManWalk(){
        //Переменные - счетчики света, кол-во вагонов, переменная для
        //красивого вывода
        int kol_1 = 0;
        int kol_0 = 0;
        int TotalCars = 1;
        int OutPoint = 0;
        //Вызов метода генерации начального вагона
        StartR = RandomStartGeneration(StartR);
        System.out.println("AFTER:");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("First car = " + StartR + "\n");
        //Объявление рандомной переменной для вкл/выкл света проверяющим
        Random randomLight = new Random();
        //Цикл обхода вагонов
        for(int i = StartR; i<Length; i++){
            OutPoint++; TotalCars++;
            //Проверяющий включает или не включает свет
            ArrayCars[i] = Math.round(randomLight.nextDouble());
            //Подсчет кол-ва вкл/выкл света
            if (ArrayCars[i] == 0) kol_0++;
            if (ArrayCars[i] == 1) kol_1++;
            //Вывод вагонов
            String result = String.format("%.0f", ArrayCars[i]);
            System.out.printf("\tCar[" + i + "]=" + result + " ");
            if(OutPoint == 10){ System.out.println(); OutPoint = 0;}
            //Обнуление массива если проверяющий дошел до конца тк состав замкнут
            if((i + 1) == Length) i=0;
            //Если проверяющий пришел в изначальную точку, то цикл прерывается
            if((i + 1) == StartR) break;
        }
        System.out.println("\n");
        System.out.println("Number of cars with lights off = " + kol_0);
        System.out.println("Number of cars with lights on = " + kol_1);
        System.out.println("Total cars : " + TotalCars);
        System.out.println();
    }
}