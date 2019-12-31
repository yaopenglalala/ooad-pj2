package task.point;

public class TaskLifeCycleStrategy {
    private LifeCycleStrategy type;

    TaskLifeCycleStrategy (LifeCycleStrategy type){
        this.type = type;
    }

    public boolean shouldFinish(){
        boolean res = true;
        switch (type){
            case once:
            case daily:
                res = true;
                break;
            case unlimited:
                res = false;
                break;
        }

        return res;
    }
}
