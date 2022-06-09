package Task_5;
import java.util.Random;
public class Test_2 {
    public static void main(String[] args){
        //Генерация рандомного кол-ва вагонов
        int N = (int)(Math.random() * 50);
        //Вывод рандомного кол-ва вагонов для сверки с итоговым результатом
        System.out.println("Random Train lenght = " + N);
        //Создание объекта класса поезд
        Train newTrain = new Train(N);
        //Запуск метода генерации вагонов
        newTrain.TrainGeneration();
        //Вывод начального состава
        newTrain.ShowTrain();
        //Создание объекта класса Man
        Man newMan = new Man(newTrain.TrainArray, N);
        //Запуск метода генерации стартовой точки обхода
        newMan.StartGeneration(newTrain.TrainArray, N);
        //Запуск метода обхода вагонов
        newMan.ManWalk();
    }
}
class Train{
    //Объявление переменной длины состава и массива вагонов
    public int TrainLenght = 0;
    public double []TrainArray;
    //Получение кол-ва вагонов и инициализация массива
    public Train(int N){
        this.TrainLenght = N;
        TrainArray = new double[this.TrainLenght];
    }
    //Метод генерации вкл/выкл света
    void TrainGeneration(){
        Random myRandom = new Random();
        for(int i = 0; i<TrainLenght; i++){
            TrainArray[i] = Math.round(myRandom.nextDouble());
        }
    }
    //Вывод сгенерированного состава на экран
    void ShowTrain(){
        System.out.print("Our Random Train : ");
        for(int i = 0; i<TrainLenght; i++){
            String result = String.format("%.0f", TrainArray[i]);
            System.out.printf(result + " ");
        }
        System.out.println();
    }
}
class Man{
    //Объявление переменной длины состава, массива вагонов и начальной точки
    public int TrainLenght = 0;
    public double []ArrayCars;
    public int Start = 0;
    //Получение длины состава, и сгенерированного поезда
    Man(double[] array, int N){
        this.TrainLenght = N;
        ArrayCars = array;
    }
    //Метод генерации стартовой точки обхода
    public void StartGeneration(double[] b, int a){
        Start = Math.round(a/2);
        System.out.println("Random Start Point = " + Start + "\n");
        b[Start] = 1;
        ManWalkShow(b,Start);
    }
    //Метода вывода обхода проверяющего вагонов или
    //его текущее положение
    public void ManWalkShow(double[] a, int start){
        for(int i = 0; i<TrainLenght; i++){
            String result = String.format("%.0f", a[i]);
            if(i==start)System.out.printf("\ta[Man]=" + result );
            else System.out.printf("\t[]=" + result );
        }
        System.out.println();
    }
    //Так как у нас поезд замкнут, решение реализовано через массив, то
    //проверяющий идет взад/вперед
    //Метод реализующий обход вагонов вперед
    public void ManWalk_Forward(int i){
        int Point = Start;
        //Сколько вагонов обойдет проверяющий (вперед)
        Point += i;
        //Выключение света
        ArrayCars[Point] = 0;
        //Вывод на экран
        ManWalkShow(ArrayCars, Point);
        //Возврат в исходную точку
        Point = Start;
        //Вывод на экран
        ManWalkShow(ArrayCars, Point);
    }
    //Метод реализующий обход вагонов назад
    public void ManWalk_Back(int i){
        int Point = Start;
        //Сколько вагонов обойдет проверяющий (назад)
        Point -= i;
        //Выключение света
        ArrayCars[Point] = 0;
        //Вывод на экран
        ManWalkShow(ArrayCars, Point);
        //Возврат в исходную точку
        Point = Start;
        //Вывод на экран
        ManWalkShow(ArrayCars, Point);
    }
    //Метод реализующий проверку включенного света во всем составе
    //По задумке обход прекращается когда свет включен только в одном вагоне (начальном)
    public int Check(){
        int check = 0;
        for(int i = 0; i<TrainLenght; i++){
            check += ArrayCars[i];
        }
        return check;
    }
    //Метод обхода вагонов
    public void ManWalk(){
        int check = 0;
        int Volume = 0;
        //Цикл обхода без использования кол-ва вагонов
        for(int i=1; i < 100; i++){
            //Проверка включенного света
            check = Check();
            //Если только 1 вагон с включенным светом, то конец обхода
            if(check == 1 ) break;
            //Обход вперед с подсчетом итераций
            ManWalk_Forward(i); Volume++;
            //Обход назад с подсчетом итераций
            ManWalk_Back(i); Volume++;
        }
        //Вывод кол-ва вагонов
        System.out.println("\nTrain lenght = " + (Volume+1));
    }
}