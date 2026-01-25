package uzumtech.j_delivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;
import uzumtech.j_delivery.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trackingNumber", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "distanceKm", source = "distance")
    OrderEntity toEntity(OrderRequest orderRequestDto);

    OrderResponse toResponse(OrderEntity orderEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trackingNumber", ignore = true)
    @Mapping(target = "distanceKm", source = "distance")
    void updateEntityFromDto(OrderRequest dto, @MappingTarget OrderEntity entity);
}