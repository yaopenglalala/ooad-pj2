package task;

import task.taskLife.TaskLifeCycleStrategy;
import task.point.TaskPointCalcStrategy;
import transaction.PerformTaskTransaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTask {
    private TaskDef definition;
    private UserTaskStatus status;
    private List<UserTaskAction> actions;
    private TaskPointCalcStrategy calcStrategy;
    private TaskLifeCycleStrategy lifeCycleStrategy;

    public UserTask(TaskDef definition,TaskPointCalcStrategy calcStrategy, TaskLifeCycleStrategy lifeCycleStrategy) {
        this.definition = definition;
        this.status = UserTaskStatus.Active;
        this.actions = new ArrayList<>();
        this.calcStrategy = calcStrategy;
        this.lifeCycleStrategy = lifeCycleStrategy;
    }

    public UserTaskAction done() {
        if (this.status != UserTaskStatus.Active) {
            System.out.println("This Task has Completed.");
            return null;
        }
        // 发起行动
        UserTaskAction action = new UserTaskAction(definition);
        action.setActionTime(new Date());
        actions.add(action);
        // 计算任务次数
        lifeCycleStrategy.taskFinishOnce();
        if (lifeCycleStrategy.shouldFinish()) {
            status = UserTaskStatus.Finished;
        }
        return action;
    }

    public TaskDef getDefinition() {
        return definition;
    }

    public void setDefinition(TaskDef definition) {
        this.definition = definition;
    }

    public UserTaskStatus getStatus() {
        return status;
    }

    public void setStatus(UserTaskStatus status) {
        this.status = status;
    }

    public List<UserTaskAction> getActions() {
        return actions;
    }

    public void setActions(List<UserTaskAction> actions) {
        this.actions = actions;
    }

    public TaskPointCalcStrategy getCalcStrategy() {
        return calcStrategy;
    }

    public void setCalcStrategy(TaskPointCalcStrategy calcStrategy) {
        this.calcStrategy = calcStrategy;
    }

    public TaskLifeCycleStrategy getLifeCycleStrategy() {
        return lifeCycleStrategy;
    }

    public void setLifeCycleStrategy(TaskLifeCycleStrategy lifeCycleStrategy) {
        this.lifeCycleStrategy = lifeCycleStrategy;
    }
}
