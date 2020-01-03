package task;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class TaskPerformerGroup {
    private static TaskPerformerGroup performers = new TaskPerformerGroup();
    private static List<TaskPerformer> list = new ArrayList<>();

    private TaskPerformerGroup(){}

    public static TaskPerformerGroup getGroup(){
        return performers;
    }

    public boolean addPerformer(User user){
        if (getPerformer(user.getName()) != null) return false;

        TaskPerformer newPerformer = new TaskPerformer(user);
        list.add(newPerformer);
        return true;
    }

    public TaskPerformer getPerformer(String name){
        for (TaskPerformer performer: list){
            if (performer.getUser().getName().equals(name)) return performer;
        }
        return null;
    }
}
