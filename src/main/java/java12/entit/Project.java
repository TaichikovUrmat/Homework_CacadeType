package java12.entit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "projects")
@Setter
@Getter
@SequenceGenerator(name = "base_id_gen",
               sequenceName = "projects_seg",
                allocationSize = 1)
@NoArgsConstructor
@ToString
public class Project  extends BaseEntity{

    @Column(name = "title")
     private String title;

    @ManyToOne(cascade = {MERGE,REFRESH,PERSIST})
    private Companies companies;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Programmer> programmers;

    public Project(String title) {
        this.title = title;
    }
}
