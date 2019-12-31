package task;

import task.point.TaskLifeCycleStrategy;
import task.point.TaskPointCalcStrategy;

import java.util.List;

public class UserTask {
    private TaskDef definition;
    private UserTaskStatus status;
    private TaskPerformer performer;
    private List<UserTaskAction> actions;
    private TaskPointCalcStrategy calcStrategy;
    private TaskLifeCycleStrategy lifeCycleStrategy;

    public UserTask() {
    }

    public UserTask(TaskDef definition, TaskPerformer performer, List<UserTaskAction> actions, TaskPointCalcStrategy calcStrategy, TaskLifeCycleStrategy lifeCycleStrategy) {
        this.definition = definition;
        this.status = UserTaskStatus.Active;
        this.performer = performer;
        this.actions = actions;
        this.calcStrategy = calcStrategy;
        this.lifeCycleStrategy = lifeCycleStrategy;
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

    public TaskPerformer getPerformer() {
        return performer;
    }

    public void setPerformer(TaskPerformer performer) {
        this.performer = performer;
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
