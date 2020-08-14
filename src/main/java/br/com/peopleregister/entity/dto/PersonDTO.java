package br.com.peopleregister.entity.dto;

import br.com.peopleregister.entity.Person;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String name;

    private String gender;

    private String email;

    private String dateBirth;

    private String naturalFrom;

    private String nationality;

    private String cpf;

    public Person transformsToObject(){
        return Person.builder()
                .id(id)
                .name(name)
                .gender(gender)
                .email(email)
                .dateBirth(dateBirth)
                .naturalFrom(naturalFrom)
                .nationality(nationality)
                .cpf(cpf)
                .build();
    }

}
