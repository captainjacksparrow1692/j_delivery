package uzumtech.j_delivery.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uzumtech.j_delivery.dto.request.TariffRequest;
import uzumtech.j_delivery.dto.response.TariffResponse;
import uzumtech.j_delivery.entity.TariffEntity;
import uzumtech.j_delivery.mapper.TariffMapper;
import uzumtech.j_delivery.repository.TariffRepository;
import uzumtech.j_delivery.service.TariffService;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TariffServiceImpl implements TariffService {
    private final TariffRepository repository;
    private final TariffMapper mapper;

    @Override
    @Transactional
    public TariffResponse create(TariffRequest requestDto) {
        TariffEntity entity = mapper.toEntity(requestDto);
        TariffEntity saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public TariffResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Тариф не найден: " + id));
    }

    @Override
    public Page<TariffResponse> getAllActive(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest)
                .map(mapper::toResponse);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<TariffResponse> getPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(mapper::toResponse);
    }
}
