package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    @Column(length = 35)
    private String name;

    @Column(name = "dead_line")
    private LocalDate deadline;

    @Column(name = "task")
    private String task;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson;

    public Task(String name, LocalDate deadline, String task) {
        this.name = name;
        this.deadline = deadline;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", deadline=" + deadline +
                ", task='" + task + '\'' +
                ", lesson=" + lesson +
                '}';
    }
}
