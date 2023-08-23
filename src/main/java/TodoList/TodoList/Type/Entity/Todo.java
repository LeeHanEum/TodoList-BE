package TodoList.TodoList.Type.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100, nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean done;

    @Builder
    public Todo (String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
