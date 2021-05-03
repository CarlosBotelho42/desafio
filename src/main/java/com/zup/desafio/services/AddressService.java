package com.zup.desafio.services;

import com.zup.desafio.entities.Address;
import com.zup.desafio.repositories.AddressRepository;
import com.zup.desafio.repositories.UserRepository;
import com.zup.desafio.services.exceptions.ObjectNotfound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public Address findBy(Integer id){
        Optional<Address> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotfound(
                "Não conseguimos encontrar o endereço que procura :(  Tente novamente! :) Id: "
                        + id
                        + ", Tipo: "
                        + Address.class.getName()
        )) ;
    }

    public Address insert(Address obj){
        obj.setId(null);
        obj.setUser(userService.findBy(obj.getUser().getId()));
        obj = repo.save(obj);
        return obj;
    }

}
