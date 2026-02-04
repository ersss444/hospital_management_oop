package hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

    private final Hospital hospital = new Hospital();

    // GET → JSON response from DB
    @GetMapping("/doctors")
    public List<Doctor> getDoctors() throws Exception {
        return hospital.getDoctors();   // from DB → JSON
    }

    // GET by ID → JSON
    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable int id) throws Exception {
        return DoctorDAO.findDoctorById(id);
    }

    // POST → JSON request → DB
    @PostMapping("/doctors")
    public String addDoctor(@RequestBody Doctor d) throws Exception {
        hospital.addDoctor(d);
        return "Doctor saved successfully";
    }

    // GET patients → JSON
    @GetMapping("/patients")
    public List<Patient> getPatients() throws Exception {
        return hospital.getPatients();
    }

    // POST patient → JSON
    @PostMapping("/patients")
    public String addPatient(@RequestBody Patient p) throws Exception {
        hospital.addPatient(p);
        return "Patient saved successfully";
    }
}
