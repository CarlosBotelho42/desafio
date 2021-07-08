package com.zup.desafio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Address_tb")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Rua obrigatória!")
    private String street;
    @NotEmpty(message = "Nunero obrigatório!")
    private String number;

    private String complement;

    @NotEmpty(message = "Bairro obrigatório!")
    private String district;

    @NotEmpty(message = "Cidade obrigatório!")
    private String city;

    @NotEmpty(message = "Rua obrigatório!")
    private String state;

    @NotEmpty(message = "Cep obrigatório!")
    private String zipCode;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
