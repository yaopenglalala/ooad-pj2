package task;

import task.point.Account;
import user.User;
import user.UserGroup;

public class TaskPerformer {
    private User user;
    private Account account;

    TaskPerformer(String name){
        UserGroup.getUserGroup().getUser(name);
        account = new Account();
    }

    public boolean checkAvailable(){
        if (this.user == null) return false;
        return true;
    }
}
