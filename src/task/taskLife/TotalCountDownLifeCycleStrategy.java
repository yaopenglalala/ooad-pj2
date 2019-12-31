package task.taskLife;

public class TotalCountDownLifeCycleStrategy extends TaskLifeCycleStrategy {
    private int limitCount;

    TotalCountDownLifeCycleStrategy(int limitCount){
        super(LifeCycleStrategy.unlimited);
        this.limitCount = limitCount;
    }

    @Override
    public boolean shouldFinish() {
        return (getCount() >= limitCount);
    }
}
