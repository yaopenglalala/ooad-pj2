package task.taskLife;

/**
 * 一次性任务生命周期
 */
public class OnceLifeCycleStrategy extends TaskLifeCycleStrategy{
    OnceLifeCycleStrategy(){
        super(LifeCycleStrategy.once);
    }
}
