package uzumtech.j_delivery.service;

import org.springframework.data.domain.Page;
import uzumtech.j_delivery.dto.request.TariffRequest;
import uzumtech.j_delivery.dto.response.TariffResponse;

public interface TariffService {
    //Создать новый тариф (например, "BIG_BOX")
    TariffResponse create(TariffRequest requestDto);

    //Получить данные конкретного тарифа по ID

    TariffResponse getById(Long id);

    //Получить все доступные тарифы для отображения клиенту
    Page<TariffResponse> getAllActive();

    //Удалить тариф
    void delete(Long id);


    //Пагинация списка тарифов для админки
    Page<TariffResponse> getPaginated(int page, int size);
}
