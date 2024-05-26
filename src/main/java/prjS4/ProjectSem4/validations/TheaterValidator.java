//package prjS4.ProjectSem4.validations;
//
//import java.util.ArrayList;
//import java.util.List;
//import prjS4.ProjectSem4.entities.Theaters;
//
//public class TheaterValidator {
//    
//    public List<String> validate(Theaters theater) {
//        List<String> errors = new ArrayList<>();
//
//        if (theater.getTheaterName() == null || theater.getTheaterName().isEmpty()) {
//            errors.add("Theater name is required.");
//        }
//
//        if (theater.getTheaterAddress() == null || theater.getTheaterAddress().isEmpty()) {
//            errors.add("Theater address is required.");
//        }
//
//        if (theater.getTheaterStatus() == null) {
//            errors.add("Theater status is required.");
//        } else if (theater.getTheaterStatus() < 0 || theater.getTheaterStatus() > 2) {
//            errors.add("Theater status must be between 0 and 2.");
//        }
//
//        return errors;
//    }
//        
//}
