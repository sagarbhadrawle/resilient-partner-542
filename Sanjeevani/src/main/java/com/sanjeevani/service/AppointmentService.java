package com.sanjeevani.service;

import com.sanjeevani.model.Appointment;

public interface AppointmentService {
	
	public Appointment getAppointmentDetails(Integer bookingId);
	public Appointment addAppointment(Integer memberId ,Integer vaxCenterId , Appointment appointment);
	public Appointment updateAppointment(Integer bookingId , Appointment appointment);
	public Appointment deleteAppointment(Integer bookingId);
	
}
