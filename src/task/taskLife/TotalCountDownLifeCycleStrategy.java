package task.taskLife;

/**
 * 自定义次数任务生命周期
 */
public class TotalCountDownLifeCycleStrategy extends TaskLifeCycleStrategy {
    private int limitCount;

    public TotalCountDownLifeCycleStrategy() {
        super(LifeCycleStrategy.TOTAL_COUNT);
        this.limitCount = -1;
    }

    public TotalCountDownLifeCycleStrategy(int limitCount){
        super(LifeCycleStrategy.TOTAL_COUNT);
        this.limitCount = limitCount;
    }

    @Override
    public boolean shouldFinish() {
        if (limitCount == -1) return false;
        return (getCount() >= limitCount);
    }
}
