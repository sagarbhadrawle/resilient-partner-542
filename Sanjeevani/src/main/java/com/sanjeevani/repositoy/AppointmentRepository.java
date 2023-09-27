package com.sanjeevani.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeevani.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
