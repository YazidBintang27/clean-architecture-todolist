package Repository;

import Entities.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{
    public TodoList[] dataTodoList = new TodoList[10];
    @Override
    public TodoList[] findAll() {
        return dataTodoList;
    }

    @Override
    public void add(TodoList todoList) {
        resizeIfFull();
        for (int i = 0; i < dataTodoList.length; i++) {
            if(dataTodoList[i] == null){
                dataTodoList[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer index) {
        if((index - 1) >= dataTodoList.length || (index - 1) < 0){
            return false;
        }else if(dataTodoList[index - 1] == null){
            return false;
        }else{
            for (int i = (index - 1); i < dataTodoList.length; i++) {
                if(i != dataTodoList.length - 1){
                    dataTodoList[i] = dataTodoList[i + 1];
                }else{
                    dataTodoList[i] = null;
                }
            }
        }
        return true;
    }

    public boolean isFull(){
        boolean isFull = true;
        for (int i = 0; i < dataTodoList.length; i++) {
            if(dataTodoList[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public void resizeIfFull(){
        if(isFull()){
            var temp = dataTodoList;
            dataTodoList = new TodoList[dataTodoList.length * 2];
            for (int i = 0; i < temp.length; i++) {
                 dataTodoList[i] = temp[i];
            }
        }
    }
}
