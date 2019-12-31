package task.point;

public class Account {
    private int number;

    public Account(){
        this.number = 0;
    }

    public int addPoint(int num){
        this.number += num;
        return this.number;
    }

    public int reducePoint(int num){
        this.number -= num;
        return this.number;
    }
}
