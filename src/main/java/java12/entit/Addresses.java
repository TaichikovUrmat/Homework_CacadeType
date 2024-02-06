package java12.entit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "base_id_gen",
               sequenceName ="addresses_seq",
                 allocationSize = 1)
@NoArgsConstructor
@ToString(exclude = "companies")
public class Addresses extends BaseEntity{

    @Column(name = "country")
    private String country;
    @OneToOne(mappedBy = "addresses",cascade = {MERGE,REFRESH,PERSIST}  )
    private Companies companies;

    @OneToOne(mappedBy = "addresses")
    private Programmer programmer;

    public Addresses(String country) {
        this.country = country;
    }
}
