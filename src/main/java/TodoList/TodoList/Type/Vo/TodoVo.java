package TodoList.TodoList.Type.Vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TodoVo {

    private String text;

    private boolean done;

    public TodoVo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }
}
