package user;

import task.point.Account;

/**
 * 用户
 */
public class User {
    private int id;
    private String name;
    private Account account;

    protected User (int id, String name){
        this.id = id;
        this.name = name;
        account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
