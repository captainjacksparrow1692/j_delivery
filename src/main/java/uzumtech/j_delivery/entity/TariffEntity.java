package uzumtech.j_delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "length", nullable = false)
    Integer length;

    @Column(name = "width", nullable = false)
    Integer width;

    @Column(name = "height", nullable = false)
    Integer height;

    @Column(name = "weight", nullable = false)
    Integer weight;
}
