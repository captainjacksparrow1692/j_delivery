package uzumtech.j_delivery.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uzumtech.j_delivery.dto.request.PriceSettingRequest;
import uzumtech.j_delivery.dto.response.PriceSettingResponse;
import uzumtech.j_delivery.entity.PriceSetting;
import uzumtech.j_delivery.mapper.PriceSettingMapper;
import uzumtech.j_delivery.repository.PriceSettingRepository;
import uzumtech.j_delivery.service.PriceSettingService;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PriceSettingServiceImpl implements PriceSettingService {
    PriceSettingRepository repository;
    PriceSettingMapper mapper;

    @Override
    @Transactional
    public PriceSettingResponse create (PriceSettingRequest request) {
        PriceSetting entity = mapper.toEntity(request);
        PriceSetting saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public PriceSettingResponse get(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Settings not found with id: " + id));
    }

    @Override
    public PriceSettingResponse getCurrent() {
        return repository.findFirstByOrderByUpdatedAtDesc()
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Settings not found"));
    }

    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public Page<PriceSettingResponse> getHistory(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(mapper::toResponse);
    }
}
