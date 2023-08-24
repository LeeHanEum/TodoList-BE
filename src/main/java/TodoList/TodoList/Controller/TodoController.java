package TodoList.TodoList.Controller;

import TodoList.TodoList.Service.TodoService;
import TodoList.TodoList.Type.Dto.TodoDto;
import TodoList.TodoList.Type.Entity.Todo;
import TodoList.TodoList.Type.Vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 전체 항목 조회
    @GetMapping("/todo")
    public ResponseEntity<List<TodoVo>> readTodoList() {
        List<TodoVo> todoVo = todoService.readTodoList();
        return ResponseEntity.ok(todoVo);
    }

    // 항목 추가
    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodoList(@RequestBody TodoDto todoDto) {
        Todo todo = todoService.createTodoList(todoDto);
        return ResponseEntity.ok(todo);

    }

    // 항목 상태 수정
    @PutMapping("/todo/{id}/{status}")
    public ResponseEntity<Void> updateTodoList(@PathVariable Long id, @PathVariable Boolean status) {
        todoService.updateTodoList(id, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 항목 삭제
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable Long id) {
        todoService.deleteTodoList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
