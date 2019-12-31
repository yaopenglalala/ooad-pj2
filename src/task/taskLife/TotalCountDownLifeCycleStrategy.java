package task.taskLife;

/**
 * 自定义次数任务生命周期
 */
public class TotalCountDownLifeCycleStrategy extends TaskLifeCycleStrategy {
    private int limitCount;

    public TotalCountDownLifeCycleStrategy(int limitCount){
        super(LifeCycleStrategy.unlimited);
        this.limitCount = limitCount;
    }

    @Override
    public boolean shouldFinish() {
        return (getCount() >= limitCount);
    }
}
