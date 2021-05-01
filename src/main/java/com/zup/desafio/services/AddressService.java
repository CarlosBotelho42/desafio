package com.zup.desafio.services;

import com.zup.desafio.entities.Address;
import com.zup.desafio.repositories.AddressRepository;
import com.zup.desafio.repositories.UserRepository;
import com.zup.desafio.services.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        return obj.orElseThrow(() -> new ObjectNotfoundException(
                "Objeto não encontrado! Id: "
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

//    public Address fromDto(Address objDto){
//        Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(), objDto.getDistrict(), objDto.getCity(), objDto.getState(), objDto.getZipCode(),)
//    }

}
