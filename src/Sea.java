public class Sea {

    public Ship generateRandomShip(){
        double random = Math.random() * 100;
        int capacity = random < 10 ? 10 : random < 50 ? 50 : 100;
        double random2 = Math.random() * 3;
        Ship.Type type = random2 < 1 ? Ship.Type.A : random2 < 2 ? Ship.Type.B : Ship.Type.C;
        return new Ship(capacity, type);
    }
}