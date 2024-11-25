package com.example.AirFrench.Repositories;


import com.example.AirFrench.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepositorie extends CrudRepository<Reservation, Long>  {

}
