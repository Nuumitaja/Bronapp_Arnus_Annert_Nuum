package ee.bcs.valiit.bronapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAll();

    Doctor getOne(Long id);

    void delete(Doctor doctor);

    Doctor save(Doctor doctor);
}
