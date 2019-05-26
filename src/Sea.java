public class Sea {

    public Ship generateRandomShip(){
        int capacity;
        Ship.Type type;
        double random = Math.random() * 100;
        if (random < 10){
            capacity = 10;
        } else if (random < 50){
            capacity = 50;
        } else {
            capacity = 100;
        }
        double random2 = Math.random() * 3;
        if (random2 < 1) {
            type = Ship.Type.A;
        } else if (random2 < 2) {
            type = Ship.Type.B;
        } else {
            type = Ship.Type.C;
        }
        return new Ship(capacity, type);
    }
}