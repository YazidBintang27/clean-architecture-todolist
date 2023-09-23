package View;

import Service.TodoListService;

import java.util.Scanner;

public class TodoListView {
    private final TodoListService todoListService;
    Scanner scanner = new Scanner(System.in);
    public TodoListView(TodoListService todoListService){
        this.todoListService = todoListService;
    }
    public void showTodoList(){
        while(true){
            System.out.println("\n\tTo Do List");
            System.out.println("\t------------");
            System.out.println("Task Anda");
            todoListService.showTodoList();
            System.out.println("------");
            System.out.println("1. Tambah task\n2. Hapus task\n3. Keluar");
            System.out.print("Masukkan pilihan : ");
            String input = scanner.nextLine();
            inputValidate(input);
        }
    }
    public void addTodoList(){
        System.out.println("\n\tTambah task");
        System.out.println("\t------------");
        todoListService.showTodoList();
        System.out.println("---------");
        System.out.print("Masukkan task (x jika batal): ");
        String input = scanner.nextLine();
        if(input.equals("x")){
            showTodoList();
        }else{
            todoListService.addTodoList(input);
            System.out.println("Berhasil menambah " + input.toUpperCase());
        }
    }
    public void removeTodoList(){
        System.out.println("\n\tHapus task");
        System.out.println("\t------------");
        todoListService.showTodoList();
        System.out.print("Pilih nomor task yang ingin anda hapus (x jika batal): ");
        String input = scanner.nextLine();
        if(input.equals("x")){
            showTodoList();
        }else{
            todoListService.removeTodoList(Integer.valueOf(input));
        }
    }
    public void inputValidate(String input){
        if(input.equals("1")){
            addTodoList();
        }else if(input.equals("2")){
            removeTodoList();
        }else if(input.equals("3")){
            System.out.println("Terimakasih");
            System.exit(0);
        }else{
            System.err.println("Masukkan pilihan yang sesuai !");
        }
    }
}
