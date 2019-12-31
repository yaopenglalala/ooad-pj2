package user;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    private static UserGroup instace = new UserGroup();
    private List<User> users = new ArrayList<>();

    private UserGroup(){}

    public static UserGroup getUserGroup(){
        return instace;
    }

    public void addUser(String name){
        int id = users.size();
        users.add(new User(id, name));
    }
}
