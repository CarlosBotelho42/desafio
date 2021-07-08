package com.zup.desafio.services;
import com.zup.desafio.entities.User;
import com.zup.desafio.repositories.AddressRepository;
import com.zup.desafio.repositories.UserRepository;
import com.zup.desafio.services.exceptions.ObjectNotfound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import com.zup.desafio.services.exceptions.DataIntegrityViolation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private AddressRepository addressRepository;

    public User findBy(Integer id){
        Optional<User> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotfound(
                "Não conseguimos encontrar o usuário que procura :(  Tente novamente! :) Id: "
                        + id
                        + ", Tipo: "
                        + User.class.getName()
        )) ;
    }

    @Transactional
    public User insert(User obj) {
        obj.setId(null);
        try {
            return repo.save(obj);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolation("Email ou CPF já cadastrados!!");
        }
    }
}
