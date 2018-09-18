package ee.bcs.valiit.bronapp.service;

import ee.bcs.valiit.bronapp.data.Doctor;
import ee.bcs.valiit.bronapp.data.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> list() {
        return doctorRepository.findAll();
    }

    public List<Doctor> listFree() {
        return doctorRepository.findByCustomernameIsNullOrCustomernameEquals("");
    }

    public Doctor get(Long id) {
        return doctorRepository.getOne(id);
    }

    @Transactional
    public void delete(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    public void save(Doctor dbDoctor) {
        doctorRepository.save(dbDoctor);
    }
}

