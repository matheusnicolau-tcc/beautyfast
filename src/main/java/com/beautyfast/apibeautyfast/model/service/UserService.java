package com.beautyfast.apibeautyfast.model.service;

import com.beautyfast.apibeautyfast.dto.UserDTO;
import com.beautyfast.apibeautyfast.model.entity.User;
import com.beautyfast.apibeautyfast.model.exception.CpfAlreadyExistsException;
import com.beautyfast.apibeautyfast.model.exception.EntityInUseException;
import com.beautyfast.apibeautyfast.model.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    public void validateIfCpfExists(String userCpf) {
        Optional<User> userOptional = userRepository.findByCpf(userCpf);
        if (userOptional.isPresent()) {
            throw new CpfAlreadyExistsException("Já existe um Registro com este CPF!");
        }
    }

    public User createNewUser(UserDTO userDTO) {
        validateIfCpfExists(userDTO.getCpf());
        User userModel = modelMapper.map(userDTO, User.class);
        return userRepository.save(userModel);
    }

}
