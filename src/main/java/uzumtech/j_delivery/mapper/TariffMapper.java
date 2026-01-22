package uzumtech.j_delivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uzumtech.j_delivery.dto.request.TariffRequest;
import uzumtech.j_delivery.dto.response.TariffResponse;
import uzumtech.j_delivery.entity.TariffEntity;

@Mapper(componentModel = "spring")
public interface TariffMapper {
    //Превращаем запрос от админа в сущность для БД
    @Mapping(target = "id", ignore = true) // ID создаст база данных
    TariffEntity toEntity(TariffRequest request);

    //Превращаем сущность из БД в ответ для API
    TariffResponse toResponse(TariffEntity entity);
}
