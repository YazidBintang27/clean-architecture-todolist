package Repository;

import Entities.TodoList;

public interface TodoListRepository {
    TodoList[] findAll();
    void add(TodoList todoList);
    boolean remove(Integer index);
}
