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
    Long id;

    @Column(name = "length", nullable = false)
    Double length;

    @Column(name = "width", nullable = false)
    Double width;

    @Column(name = "height", nullable = false)
    Double height;

    @Column(name = "weight", nullable = false)
    Double weight;
}
