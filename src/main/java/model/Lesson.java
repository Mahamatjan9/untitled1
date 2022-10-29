package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



import java.util.List;

import static jakarta.persistence.CascadeType.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(name = "video_link", length = 35)
    private String videoLink;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH},fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,mappedBy = "lesson")
    private List<Task> task;



    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;

    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }



}
