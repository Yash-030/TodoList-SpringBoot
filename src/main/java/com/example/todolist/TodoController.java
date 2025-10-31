package com.example.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    // 💡 IN-MEMORY STORAGE: Data is stored here and lost when the application stops.
    private static final List<Todo> todos = new ArrayList<>();
    private static long nextId = 1;

    // 1. CREATE (POST /api/todos)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }

    // 2. READ ALL (GET /api/todos)
    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }

    // 3. READ BY ID (GET /api/todos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

        return todo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. UPDATE (PUT /api/todos/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {

        Optional<Todo> todoOptional = todos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

        if (todoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Todo existingTodo = todoOptional.get();
        existingTodo.setTitle(todoDetails.getTitle());
        existingTodo.setDescription(todoDetails.getDescription());
        existingTodo.setCompleted(todoDetails.isCompleted());

        return ResponseEntity.ok(existingTodo);
    }

    // 5. DELETE (DELETE /api/todos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean removed = todos.removeIf(t -> t.getId().equals(id));

        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
