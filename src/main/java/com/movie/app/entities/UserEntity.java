package com.movie.app.entities;

import com.movie.app.configs.db.AttributeEntityBuider;
import com.movie.app.configs.db.EntityBuider;
import com.movie.app.configs.db.IEntityBuider;
import com.movie.app.interfaces.UserDetails;
import java.util.List;

public class UserEntity implements UserDetails {

    private String username;
    private String password;
    private Role role;
    public static final IEntityBuider SQL = EntityBuider.builder()
            .name("users")
            .add(AttributeEntityBuider.builder()
                    .name("id")
                    .type("int")
                    .primary(true)
                    .autoIncrement(true),
                    false)
            .add(AttributeEntityBuider.builder()
                    .name("_username")
                    .type("varchar(255)")
                    .nullable(false)
                    .unique(true),
                    false)
            .add(AttributeEntityBuider.builder()
                    .name("_password")
                    .type("varchar(255)")
                    .nullable(false), true);
    

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public List<String> getRoles() {
        return List.of(this.role.toString());
    }

}
