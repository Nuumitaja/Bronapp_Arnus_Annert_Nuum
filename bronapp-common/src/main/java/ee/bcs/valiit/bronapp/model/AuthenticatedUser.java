package ee.bcs.valiit.bronapp.model;

import lombok.Data;

import java.util.Set;

@Data
public class AuthenticatedUser {

    private Long id;
    private String username, name, email;
    private Set<String> roles;

}
