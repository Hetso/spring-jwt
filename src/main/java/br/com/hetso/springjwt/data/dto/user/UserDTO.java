package br.com.hetso.springjwt.data.dto.user;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

@Value
@NonFinal
@SuperBuilder
@NoArgsConstructor(force = true)
public class UserDTO implements Serializable {

    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    
}
