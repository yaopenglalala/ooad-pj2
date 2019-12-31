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

    public boolean addUser(String name){
        if (this.getUser(name) == null ) return false;
        int id = users.size();
        users.add(new User(id, name));
        return true;
    }

    public User getUser(String name){
        for (User user : users){
            if(user.getName().equals(name)) return user;
        }
        return null;
    }
}
