package ee.bcs.valiit.bronapp.controller;

import ee.bcs.valiit.bronapp.data.Doctor;
import ee.bcs.valiit.bronapp.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Doctor> list() {
        log.debug("Appointment list called ...");
        List<Doctor> list = doctorService.list();
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

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public Doctor get(@PathVariable Long id) {
        return doctorService.get(id);
    }

    @PostMapping(value = "/delete/{id}", produces = "application/json")
    public void delete(@PathVariable  Long id) {
        Doctor doctor = doctorService.get(id);
        doctorService.delete(doctor);
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

    @PostMapping(value = "/add")
    public void add(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
    }

}

