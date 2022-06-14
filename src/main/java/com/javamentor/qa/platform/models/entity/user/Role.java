package com.javamentor.qa.platform.models.entity.user;

import com.javamentor.qa.platform.models.entity.chat.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 5731253987889984670L;
    @Id
    @GeneratedValue(generator = "Role_seq")
    private Long id;

    @Column
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        Role role = (Role) o;
        return id != null &&
                id.equals(role.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
