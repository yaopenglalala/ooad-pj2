package task.taskLife;

public class TaskLifeCycleStrategy {
    private LifeCycleStrategy type;
    private int count;

    TaskLifeCycleStrategy (LifeCycleStrategy type){
        this.type = type;
        this.count = 0;
    }

    public boolean shouldFinish(){
        return true;
    }

    public int taskFinishOnce(){
        return addCount(1);
    }

    public int addCount(int num){
        count += num;
        return count;
    }

    public int getCount() {
        return count;
    }

    public LifeCycleStrategy getType() {
        return type;
    }
}
