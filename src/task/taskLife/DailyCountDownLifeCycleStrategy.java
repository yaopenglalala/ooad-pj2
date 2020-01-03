package task.taskLife;

/**
 * 日常任务生命周期
 */
public class DailyCountDownLifeCycleStrategy extends TaskLifeCycleStrategy {
    public DailyCountDownLifeCycleStrategy (){
        super(LifeCycleStrategy.DAILY);
    }
}
