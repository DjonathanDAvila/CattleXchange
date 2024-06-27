package com.cattle.xchange.domain.user;

import com.cattle.xchange.domain.user.dtos.UserLoginDTO;
import com.cattle.xchange.infra.config.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cattle.xchange.infra.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtService jwtService;

    @Transactional(readOnly = true)
    public User findUserById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
    }

    @Transactional
    public List<User> findAll() {
        return repository.findAll();
    };

    @Transactional
    public User findByCpf(String document) {
        User user = repository.findByDocument(document);

        if (repository != null) {
            throw new IllegalArgumentException("CPF não Existe");
        }

        return user;
    }

    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }

    public User getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User ?
                (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
    }
}
