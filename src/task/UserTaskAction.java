package task;

import java.util.Date;

public class UserTaskAction {
    private TaskDef definition;
    private Date actionTime;

    public UserTaskAction() {
    }

    public UserTaskAction(TaskDef definition) {
        this.definition = definition;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }
}
