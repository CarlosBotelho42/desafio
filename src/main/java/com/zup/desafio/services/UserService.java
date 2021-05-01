package com.zup.desafio.services;
import com.zup.desafio.entities.User;
import com.zup.desafio.repositories.AddressRepository;
import com.zup.desafio.repositories.UserRepository;
import com.zup.desafio.services.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private AddressRepository addressRepository;

    public User findBy(Integer id){
        Optional<User> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotfoundException(
                "Objeto não encontrado! Id: "
                        + id
                        + ", Tipo: "
                        + User.class.getName()
        )) ;
    }

    public User insert(User obj){
        obj.setId(null);
        return repo.save(obj);
    }


}
