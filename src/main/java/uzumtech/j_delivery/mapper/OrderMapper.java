package uzumtech.j_delivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;
import uzumtech.j_delivery.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", constant = "NEW")
    OrderEntity toEntity(OrderRequest orderRequestDto);

    OrderResponse toDto(OrderEntity orderEntity);
}