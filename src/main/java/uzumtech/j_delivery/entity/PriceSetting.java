package uzumtech.j_delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "price_settings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceSetting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "free_distance")
    Double freeDistance;

    @Column(name = "base_fee")
    Double baseFee;

    @Column(name = "per_kg_rate")
    Double perKgRate;

    @Column(name = "per_km_rate")
    Double perKmRate;

    @Column(name = "urgent_fee")
    Double urgentFee;

    @Column(name = "fragile_fee")
    Double fragileFee;

}
