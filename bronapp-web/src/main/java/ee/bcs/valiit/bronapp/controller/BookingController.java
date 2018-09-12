package ee.bcs.valiit.bronapp.controller;

import ee.bcs.valiit.bronapp.data.Doctor;
import ee.bcs.valiit.bronapp.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
@Slf4j
public class BookingController {

    @Autowired
    private DoctorService doctorService;

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
