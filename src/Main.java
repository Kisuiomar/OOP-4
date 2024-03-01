import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class Dire implements Observer {
    private String name;

    public Dire(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " выходит убить RADIANT!");
    }
}

class Radiant implements Observer {
    private String name;

    public Radiant(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " выходит убить DIRE!");
    }
}

// Класс для карты, являющийся наблюдаемым объектом
class Map {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void radiantSpotted() {
        System.out.println("RADIANT появился на карте!");
        notifyObservers();
    }

    public void direSpotted() {
        System.out.println("DIRE появился на карте!");
        notifyObservers();
    }
}

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.addObserver(new Radiant("Huscar"));
        map.addObserver(new Radiant("Sevs"));
        map.addObserver(new Radiant("Tusk"));
        map.addObserver(new Radiant("Axe"));
        map.addObserver(new Radiant("Dazzle"));

        map.addObserver(new Dire("Tinker"));
        map.addObserver(new Dire("Invoker"));
        map.addObserver(new Dire("Ark Warden"));
        map.addObserver(new Dire("Techies"));
        map.addObserver(new Dire("Nix"));
        map.direSpotted();
    }
}