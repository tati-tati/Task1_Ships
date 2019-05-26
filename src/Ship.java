public class Ship {
    private int capacity;
    private int currFilling;
    private Type type;

//    public Ship(){}

    public Ship(int capacity, Type type) {
        this.capacity = capacity;
        this.type = type;
        this.currFilling = 0;
    }

    public int getCapacity() {
        return capacity;
    }

//    public int getCurrFilling() {
//        return currFilling;
//    }

    public Type getType() {
        return type;
    }

    public void setCurrFilling(int currFilling) {
        this.currFilling += currFilling;
    }

    public String toString(){
        return "Ship <" + type + ", " + capacity + ", " + currFilling + ">";
    }

    public void goToChannel(Channel channel){
        channel.getNewShip(this);
    }

    public enum Type{
        A,
        B,
        C
    }
}