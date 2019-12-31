package task.taskLife;

public class OnceLifeCycleStrategy extends TaskLifeCycleStrategy{
    OnceLifeCycleStrategy(){
        super(LifeCycleStrategy.once);
    }
}
