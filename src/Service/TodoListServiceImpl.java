package Service;

import Entities.TodoList;
import Repository.TodoListRepository;
import Repository.TodoListRepositoryImpl;

public class TodoListServiceImpl implements TodoListService{
    private final TodoListRepository todoListRepository;
    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] data = todoListRepository.findAll();
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null){
                System.out.printf("%d. %s \n", (i + 1), data[i].getToDo());
            }
        }
    }

    @Override
    public void addTodoList(String dataTodo) {
        TodoList todoList = new TodoList(dataTodo);
        todoListRepository.add(todoList);
    }

    @Override
    public void removeTodoList(Integer index) {
        boolean isSuccess = todoListRepository.remove(index);
        if(isSuccess){
            System.out.println("Berhasil menghapus data No. " + index);
        }else{
            System.err.println("Gagal menghapus data No. " + index);
        }
    }
}
