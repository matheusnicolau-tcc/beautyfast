package com.beautyfast.apibeautyfast.model.service;

import com.beautyfast.apibeautyfast.dto.ScheduleDTO;
import com.beautyfast.apibeautyfast.model.entity.Customer;
import com.beautyfast.apibeautyfast.model.entity.Schedules;
import com.beautyfast.apibeautyfast.model.entity.User;
import com.beautyfast.apibeautyfast.model.exception.LIstNotFindException;
import com.beautyfast.apibeautyfast.model.exception.SchedulesNotFindException;
import com.beautyfast.apibeautyfast.model.exception.UserNotFindException;
import com.beautyfast.apibeautyfast.model.repository.CustomerRepository;
import com.beautyfast.apibeautyfast.model.repository.SchedulesRepository;
import com.beautyfast.apibeautyfast.model.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulesService {

    @Autowired
    SchedulesRepository schedulesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    public Schedules createNewSchedule(ScheduleDTO scheduleDTO) {
        Schedules schedulesModel = new Schedules();
        Optional<User> userFind = userRepository.findById(scheduleDTO.getUser().getUserId());
        if (userFind.isEmpty()) {
            throw new UserNotFindException("Usuário não cadastrado!");
        }
        Optional<Customer> customerFind = customerRepository.findById(scheduleDTO.getCustomer().getCustomerId());
        if (customerFind.isEmpty()) {
            throw new UserNotFindException("Cliente não cadastrado!");
        }
        schedulesModel.setScheduleDate(scheduleDTO.getScheduleDate());
        schedulesModel.setUserId(userFind.get());
        schedulesModel.setCustomerId(customerFind.get());

        return schedulesRepository.save(schedulesModel);
    }

    public ScheduleDTO searchById(Long id) {
        Optional<Schedules> schedulesOptional = schedulesRepository.findById(id);
        if(schedulesOptional.isEmpty()){
            throw new SchedulesNotFindException("Agendamento não encontrado !");
        }

        return modelMapper.map(schedulesOptional.get(), ScheduleDTO.class);
    }

    public List<Schedules> findAll() {
        List<Schedules> schedulesList = schedulesRepository.findAll();
        if (schedulesList.isEmpty()) {
            throw new LIstNotFindException("Lista de Agendamentos não encontrada");
        }
        return schedulesList;
    }

    public String updateSchedules(Long scheduleId, ScheduleDTO scheduleDTO) {
        Optional<Schedules> scheduleToUpdate = schedulesRepository.findById(scheduleId);
        if (scheduleToUpdate.isEmpty()) {
            throw new SchedulesNotFindException("Usuário não encontrado !");
        }

        Optional<User> userFind = userRepository.findById(scheduleDTO.getUser().getUserId());
        if (userFind.isEmpty()) {
            throw new UserNotFindException("Usuário não cadastrado!");
        }
        Optional<Customer> customerFind = customerRepository.findById(scheduleDTO.getCustomer().getCustomerId());
        if (customerFind.isEmpty()) {
            throw new UserNotFindException("Cliente não cadastrado!");
        }

        scheduleToUpdate.get().setScheduleDate(scheduleDTO.getScheduleDate());
        scheduleToUpdate.get().setUserId(userFind.get());
        scheduleToUpdate.get().setCustomerId(customerFind.get());

        schedulesRepository.save(scheduleToUpdate.get());

        return "Agendamento Atualizado com sucesso !";
    }

    public String deleteUser(Long scheduleId) {
        Optional<Schedules> schedulesToDelete = schedulesRepository.findById(scheduleId);
        if (schedulesToDelete.isEmpty()) {
            throw new SchedulesNotFindException("Agendamento não encontrado !");
        }
        schedulesRepository.delete(schedulesToDelete.get());
        return "Agendamento deletado com sucesso !";
    }
}
