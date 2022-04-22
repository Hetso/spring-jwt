package br.com.hetso.springjwt.service;

import org.springframework.stereotype.Service;

import br.com.hetso.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

}
