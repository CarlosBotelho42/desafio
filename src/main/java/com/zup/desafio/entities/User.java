package com.zup.desafio.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "User_tb")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome obrigatório!")
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "Data de nascimento obrigatória!")
    private String  dateOfBirth;

    @Column(unique = true)
    @NotEmpty(message = "Email obrigatório!")
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "CPF obrigatório!")
    @CPF(message = "Cpf Invalido!")
    private String cpf;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

}
