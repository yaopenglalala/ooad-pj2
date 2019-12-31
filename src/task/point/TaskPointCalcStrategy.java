package task.point;

public class TaskPointCalcStrategy {
    private int initNumber;

    TaskPointCalcStrategy (int num) {
        this.initNumber = num;
    }

    public int calcPoint(){
        return calcPoint(1);
    }

    public int calcPoint(double rate){
        return new Long(Math.round(initNumber * rate)).intValue();
    }
}
