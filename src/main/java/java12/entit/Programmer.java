package java12.entit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@SequenceGenerator(
        name = "base_id_gen",
        sequenceName = "programmers_seg",
        allocationSize =  1
)
@NoArgsConstructor
public class Programmer extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "programmers",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Project> projects;

    @OneToOne
    private Addresses addresses;
}
