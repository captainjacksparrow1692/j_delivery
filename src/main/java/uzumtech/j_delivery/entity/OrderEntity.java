package uzumtech.j_delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uzumtech.j_delivery.constant.enums.Status;

@Entity
@Table(name = "orders")
@Builder
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "merchant_id", nullable = false)
    Integer merchantId;
    @Column(name = "tariff_id", nullable = false)
    Integer tariffId;

    @Column(name = "length", nullable = false)
    Double length;
    @Column(name = "width", nullable = false)
    Double width;
    @Column(name = "height", nullable = false)
    Double height;
    @Column(name = "weight", nullable = false)
    Double weight;

    @Column(name = "distance_km", nullable = false)
    Double distanceKm;

    @Column(name = "is_urgent")
    Boolean isUrgent;
    @Column(name = "is_fragile")
    Boolean isFragile;

    @Column(name = "total_price", nullable = false)
    Double totalPrice;

    @Enumerated(EnumType.STRING)
    Status status;
}
