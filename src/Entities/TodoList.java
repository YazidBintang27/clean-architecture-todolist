package Entities;

public class TodoList {
    private String toDo;
    public TodoList(String toDo){
        this.toDo = toDo;
    }
    public TodoList(){

    }
    public void setToDo(String toDo){
        this.toDo = toDo;
    }
    public String getToDo(){
        return toDo;
    }
}
