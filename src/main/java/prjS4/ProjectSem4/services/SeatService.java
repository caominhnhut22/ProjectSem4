package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Seats;
import prjS4.ProjectSem4.interfaces.ISeatService;
import prjS4.ProjectSem4.repositories.SeatRepository;

@Service
public class SeatService implements ISeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seats> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seats getSeatById(String id) {
        return seatRepository.findById(id).orElse(null);
    }

    @Override
    public Seats createSeat(Seats seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seats updateSeat(String id, Seats seat) {
        if (!seatRepository.existsById(id)) {
            return null;
        }
        seat.setSeatId(id);
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(String id) {
        seatRepository.deleteById(id);
    }
    
}
