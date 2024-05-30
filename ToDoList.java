package LinkedListAssignment1;

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }
}

class Node {
    private Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class ToDoList {
    private Node head;

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            Task task = current.getTask();
            if (task.getTitle().equals(title)) {
                task.markCompleted();
                return;
            }
            current = current.getNext();
        }
        System.out.println("Task not found");
    }

    public void viewToDoList() {
        Node current = head;
        System.out.println("To-Do List:");
        while (current != null) {
            Task task = current.getTask();
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println();
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Add tasks
        toDoList.addToDo(new Task("Task 1", "Description 1"));
        toDoList.addToDo(new Task("Task 2", "Description 2"));
        toDoList.addToDo(new Task("Task 3", "Description 3"));

        // View initial to-do list
        toDoList.viewToDoList();

        // Mark a task as completed
        toDoList.markToDoAsCompleted("Task 2");

        // View updated to-do list
        toDoList.viewToDoList();
    }
}
