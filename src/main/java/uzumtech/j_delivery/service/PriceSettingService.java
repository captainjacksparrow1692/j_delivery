package uzumtech.j_delivery.service;

import org.springframework.data.domain.Page;
import uzumtech.j_delivery.dto.request.PriceSettingRequest;
import uzumtech.j_delivery.dto.response.PriceSettingResponse;

public interface PriceSettingService {

    //Создание новой конфигурации цен (становится актуальной автоматически)
    PriceSettingResponse create(PriceSettingRequest requestDto);


    //Получение конкретной настройки по ID
    PriceSettingResponse get(Long id);


    //Получение текущих действующих цен (последних по дате)
    PriceSettingResponse getCurrent();

    //Удаление настройки (архивация)
    void delete(Long id);

    //Пагинация истории изменений цен для админ-панели
    Page<PriceSettingResponse> getHistory(int page, int size);
}