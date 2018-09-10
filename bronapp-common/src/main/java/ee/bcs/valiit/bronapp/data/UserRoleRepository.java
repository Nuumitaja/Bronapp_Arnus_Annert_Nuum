package ee.bcs.valiit.bronapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    public List<UserRole> findByRoleId(Long roleId);

}
