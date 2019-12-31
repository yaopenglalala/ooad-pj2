package task;

import task.point.Account;
import transaction.PerformTaskTransaction;
import user.User;
import user.UserGroup;

import java.util.ArrayList;
import java.util.List;
/**
 * 任务执行者
 */
public class TaskPerformer {
    private User user;
    private List<UserTask> tasks;
    private Account account;

    TaskPerformer(String name){
        user = UserGroup.getUserGroup().getUser(name);
        tasks = new ArrayList<>();
        account = new Account();
    }

    public boolean addTask(UserTask task){
        this.tasks.add(task);
        return true;
    }

    public boolean complete(UserTask task, String commit) {
        UserTaskAction action = task.done();
        if (action == null) return false;
        // 记录交易
        if (!this.checkAvailable()) {
            System.out.println("This performer is valid.");
            return false;
        }
        this.getAccount().addTransaction(
                new PerformTaskTransaction(
                        task.getDefinition(), action.getActionTime(),
                        task.getCalcStrategy().calcPoint(), commit));
        return true;
    }

    public boolean checkAvailable(){
        if (this.user == null) return false;
        return true;
    }

    public User getUser() {
        return user;
    }

    public Account getAccount() {
        return account;
    }

    public UserTask getTask(TaskDef taskDef){
        for (UserTask task: tasks){
            if (task.getDefinition().equals(taskDef)) return task;
        }

        return null;
    }
}
