package TodoList.TodoList.Service;

import TodoList.TodoList.Repository.TodoRepository;
import TodoList.TodoList.Type.Dto.TodoDto;
import TodoList.TodoList.Type.Entity.Todo;
import TodoList.TodoList.Type.Vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoVo> readTodoList() {
        List<TodoVo> todoVoList = todoRepository.findAll().stream()
                .map(todo -> new TodoVo(todo.getText(), todo.isDone()))
                .toList();
        return todoVoList;
    }

    public Todo createTodoList(TodoDto todoDto) {
        Todo todo = Todo.builder()
                .text(todoDto.getText())
                .done(todoDto.isDone())
                .build();
        todoRepository.save(todo);
        return todo;
    }

    public Boolean updateTodoList(Long id, Boolean status) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setDone(status);
        todoRepository.save(todo);
        return status;
    }

    public void deleteTodoList(Long id) {
        todoRepository.deleteById(id);
    }

}
