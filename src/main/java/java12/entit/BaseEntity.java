package java12.entit;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {
@Id
@GeneratedValue(
        generator = "base_id_gen",
        strategy = GenerationType.SEQUENCE
)
    private Long id;

}
