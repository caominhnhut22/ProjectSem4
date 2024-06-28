package prjS4.ProjectSem4.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import prjS4.ProjectSem4.entities.Fares;
import prjS4.ProjectSem4.entities.Seats;
import prjS4.ProjectSem4.entities.Shifts;
import prjS4.ProjectSem4.interfaces.IFareService;
import prjS4.ProjectSem4.interfaces.ISeatService;
import prjS4.ProjectSem4.interfaces.IShiftService;

@RestController
@RequestMapping("/api/management")
public class BranchAPI {
    
    @Autowired
    private IFareService fareService;

    @Autowired
    private ISeatService seatService;

    @Autowired
    private IShiftService shiftService;

    // Fares endpoints

    @GetMapping("/fares")
    public List<Fares> getAllFares() {
        return fareService.getAllFares();
    }

    @GetMapping("/fares/{id}")
    public Fares getFareById(@PathVariable String id) {
        return fareService.getFareById(id);
    }

    @PostMapping("/fares")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public Fares createFare(@RequestBody Fares fare) {
        return fareService.createFare(fare);
    }

    @PutMapping("/fares/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public Fares updateFare(@PathVariable String id, @RequestBody Fares fare) {
        return fareService.updateFare(id, fare);
    }

    @DeleteMapping("/fares/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public void deleteFare(@PathVariable String id) {
        fareService.deleteFare(id);
    }

    // Seats endpoints

    @GetMapping("/seats")
    public List<Seats> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/seats/{id}")
    public Seats getSeatById(@PathVariable String id) {
        return seatService.getSeatById(id);
    }

    @PostMapping("/seats")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public Seats createSeat(@RequestBody Seats seat) {
        return seatService.createSeat(seat);
    }

    @PutMapping("/seats/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public Seats updateSeat(@PathVariable String id, @RequestBody Seats seat) {
        return seatService.updateSeat(id, seat);
    }

    @DeleteMapping("/seats/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public void deleteSeat(@PathVariable String id) {
        seatService.deleteSeat(id);
    }

    // Shifts endpoints

    @GetMapping("/shifts")
    public List<Shifts> getAllShifts() {
        return shiftService.getAllShifts();
    }

    @GetMapping("/shifts/{id}")
    public Shifts getShiftById(@PathVariable String id) {
        return shiftService.getShiftById(id);
    }

    @PostMapping("/shifts")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public Shifts createShift(@RequestBody Shifts shift) {
        return shiftService.createShift(shift);
    }

    @PutMapping("/shifts/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public Shifts updateShift(@PathVariable String id, @RequestBody Shifts shift) {
        return shiftService.updateShift(id, shift);
    }

    @DeleteMapping("/shifts/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGEMENT_EMPLOYEE')")
    public void deleteShift(@PathVariable String id) {
        shiftService.deleteShift(id);
    }

}
