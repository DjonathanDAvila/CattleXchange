package com.cattle.xchange.domain.user;

import com.cattle.xchange.domain.user.dtos.UserLoginDTO;
import com.cattle.xchange.domain.user.dtos.UserMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public User findUserById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public List<User> findAll() {
        return repository.findAll();
    };

    @Transactional
    public User insert(String document, String name, String lastName, String email, String password) {
        return repository.save(new User(
                document, name, lastName, email, password, LocalDate.now()
        ));
    }
    @Transactional
    public User findByCpf(String document) {
        User user = repository.findByDocument(document);

        if (repository != null) {
            throw new IllegalArgumentException("CPF não Existe");
        }

        return user;
    }

    @Transactional
    public User login(UserLoginDTO usuario){
        User user = repository.findByEmail(usuario.email());

        if(!Objects.equals(user.getEmail(), usuario.email())){
            throw new IllegalArgumentException("Email não corresponde com as credências");
        }

        if(!Objects.equals(user.getPassword(), usuario.password())){
            throw new IllegalArgumentException("Senha não corresponde com as credências");
        }
        return user;
    }



}
