package com.beautyfast.apibeautyfast.model.service;

import com.beautyfast.apibeautyfast.dto.UserDTO;
import com.beautyfast.apibeautyfast.model.entity.User;
import com.beautyfast.apibeautyfast.model.exception.CpfAlreadyExistsException;
import com.beautyfast.apibeautyfast.model.exception.LIstNotFindException;
import com.beautyfast.apibeautyfast.model.exception.UserNotFindException;
import com.beautyfast.apibeautyfast.model.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new CpfAlreadyExistsException("Este CPF já está cadastrado como Usuário!");
        }
    }

    public User createNewUser(UserDTO userDTO) {
        validateIfCpfExists(userDTO.getCpf());
        User userModel = modelMapper.map(userDTO, User.class);
        return userRepository.save(userModel);
    }

    public UserDTO searchById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
          throw new UserNotFindException("Usuário não encontrado !");
        }

        return modelMapper.map(userOptional.get(), UserDTO.class);
    }

    public List<User> findAll() {
     List<User> usersList = userRepository.findAll();
        if (usersList.isEmpty()) {
            throw new LIstNotFindException("Lista de Usuários não encontrada");
        }
        return usersList;
    }

    public String updateUser(Long userId, UserDTO userDTO) {
        Optional<User> userToUpdate = userRepository.findById(userId);
       if (userToUpdate.isEmpty()) {
           throw new UserNotFindException("Usuário não encontrado !");
       }

       userToUpdate.get().setName(userDTO.getName());
       userToUpdate.get().setCpf(userDTO.getCpf());
       userToUpdate.get().setSalary(userDTO.getSalary());
       userToUpdate.get().setUserPosition(userDTO.getUserPosition());

       userRepository.save(userToUpdate.get());

       return "Usuário Atualizado com sucesso !";
    }

    public String deleteUser(Long userId) {
        Optional<User> userToDelete = userRepository.findById(userId);
        if (userToDelete.isEmpty()) {
            throw new UserNotFindException("Usuário não encontrado !");
        }
        userRepository.delete(userToDelete.get());
        return "Usuário deletado com sucesso !";
    }
}
