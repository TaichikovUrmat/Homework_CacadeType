package java12.entit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Setter
@Getter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen",
        sequenceName ="companies_seq",
        allocationSize = 1)
public class Companies  extends  BaseEntity{

    @Column(name = "name")
     private String name;

    @OneToOne(cascade = {MERGE,REFRESH,PERSIST})
    private Addresses addresses;

    @OneToMany(mappedBy = "companies")
    private List<Project> project;


    public Companies(String name) {
        this.name = name;
    }

}
