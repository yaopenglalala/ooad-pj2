package service;

import javafx.concurrent.Task;
import task.TaskDef;
import task.TaskPerformer;
import task.TaskPerformerGroup;
import task.UserTask;
import task.point.FixPointStrategy;
import task.point.TaskPointCalcStrategy;
import task.taskLife.TaskLifeCycleStrategy;
import user.User;
import user.UserGroup;

public class AdminService {
    private UserGroup userGroup = UserGroup.getUserGroup();
    private TaskPerformerGroup performerGroup = TaskPerformerGroup.getGroup();

    public boolean addUser(String name){
        return userGroup.addUser(name);
    }

    public UserTask createTask(TaskDef taskDef, FixPointStrategy point, TaskLifeCycleStrategy life){
        return new UserTask(taskDef, point, life);
    }

    public boolean publishTask(UserTask task, String name){
        User user = userGroup.getUser(name);
        performerGroup.addPerformer(user);
        performerGroup.getPerformer(name).addTask(task);
        return true;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public TaskPerformerGroup getPerformerGroup() {
        return performerGroup;
    }
}
