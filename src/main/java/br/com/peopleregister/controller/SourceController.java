package br.com.peopleregister.controller;

import br.com.peopleregister.entity.dto.SourceDTO;
import br.com.peopleregister.service.SourceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api(value = "Source")
@RequestMapping("/source")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SourceController {

    private final SourceService service;

    @GetMapping
    public ResponseEntity<SourceDTO> listSource() {
        return ResponseEntity.ok(service.listSource());
    }

}
