package com.example.AirFrench.services;

import com.example.AirFrench.model.Reservation;

import java.util.List;


public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
    Reservation getReservationDetails(Long id);
}
