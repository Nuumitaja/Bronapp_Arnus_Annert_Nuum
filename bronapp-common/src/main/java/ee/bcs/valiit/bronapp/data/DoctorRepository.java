package ee.bcs.valiit.bronapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAll();

    List<Doctor> findByCustomernameIsNull();

    Doctor getOne(Long id);

    void delete(Doctor doctor);

    Doctor save(Doctor doctor);
}
