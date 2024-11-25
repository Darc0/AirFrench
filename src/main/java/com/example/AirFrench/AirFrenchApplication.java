package com.example.AirFrench;

import com.example.AirFrench.model.Reservation;
import com.example.AirFrench.services.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AirFrenchApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirFrenchApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ReservationService reservationService) {
		return args -> {
			// Création d'une réservation
			Reservation reservation = new Reservation();
			reservation.setPassengerName("Ange Yannick");
			reservation.setDepartureDateTime(LocalDateTime.of(2024, 12, 25, 10, 30));
			reservation.setDepartureCity("Paris");
			reservation.setArrivalCity("Abidjan");
			reservationService.createReservation(reservation);

			// Afficher toutes les réservations
			reservationService.getAllReservations().forEach(r ->
					System.out.println("Reservation: " + r.getPassengerName() + ", Ticket: " + r.getTicketReference())
			);

			// Modifier une réservation
			reservation.setDepartureCity("Orly");
			reservationService.updateReservation(reservation.getId(), reservation);

			// Supprimer une réservation
			reservationService.deleteReservation(reservation.getId());
		};
	}
}
