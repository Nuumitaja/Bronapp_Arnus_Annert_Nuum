package ee.bcs.valiit.bronapp.controller;

import ee.bcs.valiit.bronapp.data.Doctor;
import ee.bcs.valiit.bronapp.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@Slf4j
public class BookingController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public Doctor get(@PathVariable Long id) {
        return doctorService.get(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Doctor doctor) {
        Doctor dbDoctor = doctorService.get(doctor.getId());
        dbDoctor.setDoctorname(doctor.getDoctorname());
        dbDoctor.setDate(doctor.getDate());
        dbDoctor.setCustomername(doctor.getCustomername());
        dbDoctor.setPhone(doctor.getPhone());
        dbDoctor.setComment(doctor.getComment());
        doctorService.save(dbDoctor);
    }

    @GetMapping("/list")
    public List<Doctor> list() {
        log.debug("Appointment list called ...");
        List<Doctor> list = doctorService.listFree();
        list.sort((o1, o2) -> {
            if (o1.getId().compareTo(o2.getId()) > 0) {
                return 1;
            } else if (o1.getId().compareTo(o2.getId()) < 0) {
                return -1;
            }
            return 0;
        });
        return list;
    }

}
