import java.util.ArrayList;
import java.util.List;

//задача 1
class Database {
    private static Database instance;
    private Database() {
        System.out.println("Создано подключение к базе данных");
    }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public void connect() {
        System.out.println("Успешное Подключение к базе данных! ");
    }
}
//задача 2
class Logik{
    private static Logik instance;
    private List<String> log;
    private Logik(){
        log = new ArrayList<>();
    }
    public static Logik getInstance(){
        if (instance==null){
            instance=new Logik();
        }
        return instance;
    }
    public void add(String str){
        log.add(str);
        System.out.println("Лог добавлен: " + str);
    }
    public void allstr(){
        System.out.println("Все логи: ");
        for (String i : log){
            System.out.println(i);
        }
    }
}
//задача 3
enum Status{
    NEW, IN_PROGRESS, DELIVERED, CANCELLED
}
class Order{
    private int orderID;
    private Status status;
    public Order(int orderID){
        this.orderID=orderID;
        this.status = Status.NEW;
    }
    public void printStatus(){
        System.out.println(orderID + " - заказ "+ status + " - статус");
    }
    public void changeStatus(Status newstatus){
        if(this.status == Status.DELIVERED){
            System.out.println("Нельзя изменить статус. Заказ доставлен");
        }else if(this.status == Status.CANCELLED){
            System.out.println("Нельзя изменить статус. Заказ отменен");
        }else{
            this.status = newstatus;
            System.out.println("Статус изменен");
        }
    }
}
//задача 4
enum Season{
    WINTER, SPRING, SUMMER, AUTUMN
}

public class SingletonEnum {
    public static void season(Season a){
        if(a==Season.WINTER){
            System.out.println("зима");
        }else if(a==Season.AUTUMN){
            System.out.println("осень");
        }else if(a==Season.SPRING){
            System.out.println("весна");
        }else if(a==Season.SUMMER){
            System.out.println("лето");
        }else{
            System.out.println("ошибка");
        }
    }
    public static void main(String[] args) {
//        Singleton Enum.txt
//        задача 1
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        db1.connect();
        db2.connect();
        if (db1 == db2) {
            System.out.println("Ссылаются на один и тот же объект");
        } else {
            System.out.println("Объекты разные");
//        }
            //задача 2
//        Logik log1 = Logik.getInstance();
//        Logik log2 = Logik.getInstance();
//        log1.add("сообщение");
//        log2.add("привет");
//        log1.allstr();
            //задача 3
//        Order order1 = new Order(1);
//        Order order2 = new Order(2);
//        order1.changeStatus(Status.DELIVERED);
//        order1.changeStatus(Status.NEW);
//        order2.changeStatus(Status.IN_PROGRESS);
//        order1.printStatus();
//        order2.printStatus();
            //задача 4
            season(Season.AUTUMN);
            season(Season.SPRING);
            season(Season.WINTER);
            season(Season.SUMMER);
        }
    }
}