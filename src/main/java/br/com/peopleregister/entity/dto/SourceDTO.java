package br.com.peopleregister.entity.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SourceDTO {

    private String urlBackEnd;
    private String urlFrontEnd;

}
