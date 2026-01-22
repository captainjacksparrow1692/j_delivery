package uzumtech.j_delivery.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uzumtech.j_delivery.dto.request.PriceSettingRequest;
import uzumtech.j_delivery.dto.response.PriceSettingResponse;
import uzumtech.j_delivery.entity.PriceSetting;

@Mapper(componentModel = "spring")
public interface PriceSettingMapper {

    PriceSetting toEntity(PriceSettingRequest dto);

    PriceSettingResponse toResponse(PriceSetting entity);

    void updateEntityFromDto(PriceSettingResponse dto, @MappingTarget PriceSetting entity);
}