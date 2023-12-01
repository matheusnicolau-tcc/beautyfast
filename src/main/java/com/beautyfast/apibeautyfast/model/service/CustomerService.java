package com.beautyfast.apibeautyfast.model.service;

import com.beautyfast.apibeautyfast.dto.CustomerDTO;
import com.beautyfast.apibeautyfast.model.entity.Customer;
import com.beautyfast.apibeautyfast.model.exception.CpfAlreadyExistsException;
import com.beautyfast.apibeautyfast.model.exception.LIstNotFindException;
import com.beautyfast.apibeautyfast.model.exception.UserNotFindException;
import com.beautyfast.apibeautyfast.model.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    public void validateIfCpfExists(String customerCpf) {
        Optional<Customer> customerOptional = customerRepository.findByCpf(customerCpf);
        if (customerOptional.isPresent()) {
            throw new CpfAlreadyExistsException("Este CPF já está cadastrado como Cliente!");
        }
    }

    public Customer createNewCustomer(CustomerDTO customerDTO) {
        validateIfCpfExists(customerDTO.getCpf());
        Customer customerModel = modelMapper.map(customerDTO, Customer.class);
        return customerRepository.save(customerModel);
    }

    public CustomerDTO searchById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isEmpty()){
            throw new UserNotFindException("Cliente não encontrado !");
        }

        return modelMapper.map(customerOptional.get(), CustomerDTO.class);
    }

    public List<Customer> findAll() {
        List<Customer> customersList = customerRepository.findAll();
        if (customersList.isEmpty()) {
            throw new LIstNotFindException("Lista de Clientes não encontrada");
        }
        return customersList;
    }

    public String updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> customerToUpdate = customerRepository.findById(customerId);
        if (customerToUpdate.isEmpty()) {
            throw new UserNotFindException("Cliente não encontrado !");
        }

        customerToUpdate.get().setName(customerDTO.getName());
        customerToUpdate.get().setCpf(customerDTO.getCpf());
        customerToUpdate.get().setAddress(customerDTO.getAddress());

        customerRepository.save(customerToUpdate.get());

        return "Cliente Atualizado com sucesso !";
    }

    public String deleteCustomer(Long customerId) {
        Optional<Customer> customerToDelete = customerRepository.findById(customerId);
        if (customerToDelete.isEmpty()) {
            throw new UserNotFindException("Cliente não encontrado !");
        }
        customerRepository.delete(customerToDelete.get());

        return "Cliente deletado com sucesso !";
    }
}
