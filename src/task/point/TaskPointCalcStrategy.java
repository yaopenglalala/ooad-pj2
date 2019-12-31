package task.point;

/**
 * 积分计算策略
 */
public class TaskPointCalcStrategy {
    private int initNumber;

    TaskPointCalcStrategy (int num) {
        this.initNumber = num;
    }

    public int calcPoint(){
        return calcPoint(1);
    }

    private int calcPoint(double rate){
        return new Long(Math.round(initNumber * rate)).intValue();
    }
}
