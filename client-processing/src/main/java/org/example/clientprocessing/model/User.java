package org.example.clientprocessing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends AbstractPersistable<Long> {

    @NotBlank(message = "Логин не может быть пустым")
    @Size(min = 3, max = 20, message = "Логин должен быть от 3 до 20 символов")
    @Column(name = "login", nullable = false, unique = true, length = 20)
    private String login;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8, max = 20, message = "Пароль должен быть от 8 до 20 символов")
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    @Size(max = 64, message = "Email не должен превышать 64 символов")
    @Column(name = "email", nullable = false, unique = true, length = 64)
    private String email;
}
