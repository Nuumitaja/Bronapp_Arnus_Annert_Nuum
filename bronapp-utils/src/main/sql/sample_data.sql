-- insert users and roles
DO $$
  DECLARE
    bronapp_user_id BIGINT;
    bronapp_role_id BIGINT;
  BEGIN
    INSERT INTO role(name) VALUES('bronapp.user') RETURNING id INTO bronapp_role_id;
    INSERT INTO users(name, email, username, password)
      VALUES('Tiina Nuum', 'tiina.nuum@gmail.com', 'tiina', '94431e9d5f5150cf097a4efd84c76e30ab9fe8c1742c957de8770e3878a4bc59')
      RETURNING id INTO bronapp_user_id;
    INSERT INTO user_role(user_id, role_id) VALUES(bronapp_user_id, bronapp_role_id);

    INSERT INTO role(name) VALUES('bronapp.admin') RETURNING id INTO bronapp_role_id;
    INSERT INTO users(name, email, username, password)
      VALUES('Administrator', 'ruth.annert@gmail.com', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918')
      RETURNING id INTO bronapp_user_id;
    INSERT INTO user_role(user_id, role_id) VALUES(bronapp_user_id, bronapp_role_id);
  END
$$;
