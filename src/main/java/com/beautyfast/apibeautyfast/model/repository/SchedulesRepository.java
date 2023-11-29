package com.beautyfast.apibeautyfast.model.repository;

import com.beautyfast.apibeautyfast.model.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {

}
