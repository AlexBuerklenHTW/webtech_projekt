package com.example.webtechProjekt.service.TripService;

import com.example.webtechProjekt.model.Trip;
import com.example.webtechProjekt.repository.TripRepository;
import com.example.webtechProjekt.service.TripService.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository theTripRepository){
        tripRepository = theTripRepository;
    }
    @Override
    public List<Trip> findAll(){return tripRepository.findAll();}
    @Override
    public Trip findById(int theId){

        Optional<Trip> result = tripRepository.findById(theId);

        Trip theTrip;

        if(result.isPresent()){
            theTrip = result.get();
        }
        else {
            throw new RuntimeException("Trip id: " + theId + " not found");
        }
        return theTrip;
    }
    @Override
    public Trip save(Trip theTrip){return tripRepository.save(theTrip);}

    @Override
    public void deleteById(int theId){tripRepository.deleteById(theId);}

}
