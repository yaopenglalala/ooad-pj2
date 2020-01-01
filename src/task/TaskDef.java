package task;

public class TaskDef {
    public String getName() {
        return name;
    }

    private String name;

    public TaskDef (String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TaskDef){
            TaskDef newOne = (TaskDef) obj;
            return this.name.equals(newOne.getName());
        }
        return false;
    }
}
