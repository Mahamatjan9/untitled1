package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(length = 25)
    private String coursename;

    @Column(length = 30)
    private String duration;


    private LocalDate createAt;

    @Column(name = "imagine_link", length = 40)
    private String imagineLink;

    @Column
    private String description;

    @ManyToMany(cascade ={ CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER,mappedBy = "course")
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public Course(String name, String duration, LocalDate createAt, String imagineLink,
                  String description) {
        this.coursename = name;
        this.duration = duration;
        this.createAt = createAt;
        this.imagineLink = imagineLink;
        this.description = description;

    }



    @Override
    public String toString() {
        return "Course{" +
                "name='" + coursename + '\'' +
                ", duration='" + duration + '\'' +
                ", createAt=" + createAt +
                ", imagineLink='" + imagineLink + '\'' +
                ", description='" + description + '\'' +
                ", instructors=" + instructors +
                '}';
    }
}
