package br.com.peopleregister.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender")
    private String gender = "N";

    @Column(name = "email")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_birth", nullable = false)
    private String dateBirth;

    @Column(name = "naturalFrom")
    private String naturalFrom;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
