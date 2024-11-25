package com.example.AirFrench.services;

import com.example.AirFrench.model.Reservation;
import com.example.AirFrench.Repositories.ReservationRepositorie;
import com.example.AirFrench.services.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepositorie reservationRepository;

    public ReservationServiceImpl(ReservationRepositorie reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        reservation.setTicketReference(UUID.randomUUID().toString());
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        Optional<Reservation> existing = reservationRepository.findById(id);
        if (existing.isPresent()) {
            Reservation updated = existing.get();
            updated.setPassengerName(reservation.getPassengerName());
            updated.setDepartureDateTime(reservation.getDepartureDateTime());
            updated.setDepartureCity(reservation.getDepartureCity());
            updated.setArrivalCity(reservation.getArrivalCity());
            return reservationRepository.save(updated);
        }
        throw new RuntimeException("Reservation not found");
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationDetails(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }



}
