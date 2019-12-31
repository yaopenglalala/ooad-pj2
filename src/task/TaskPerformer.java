package task;

import task.point.Account;
import transaction.PerformTaskTransaction;
import user.User;
import user.UserGroup;

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
        account = new Account();
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
}
