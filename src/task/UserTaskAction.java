package task;

import java.util.Date;

public class UserTaskAction {
    private Date actionTime;

    public UserTaskAction() {
    }

    public UserTaskAction(Date actionTime) {
        this.actionTime = actionTime;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }
}
