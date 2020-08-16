package br.com.peopleregister.service.impl;

import br.com.peopleregister.entity.dto.SourceDTO;
import br.com.peopleregister.service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SourceServiceImpl implements SourceService {

    @Override
    public SourceDTO listSource() {
        return SourceDTO.builder()
                .urlBackEnd("https://github.com/kevinzamperetti/people-register")
                .urlFrontEnd("https://github.com/kevinzamperetti/people-register-ui")
                .build();
    }
}
