package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final ParkingSpotRepository repository;

    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ParkingSpot save(ParkingSpot parkingSpot) {
        return repository.save(parkingSpot);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return repository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndTower(String apartment, String tower) {
        return repository.existsByApartmentAndTower(apartment, tower);
    }

    public Page<ParkingSpot> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<ParkingSpot> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpot parkingSpot) {
        repository.delete(parkingSpot);
    }
}