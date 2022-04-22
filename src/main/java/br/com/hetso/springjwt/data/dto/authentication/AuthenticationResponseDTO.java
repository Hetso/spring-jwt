package br.com.hetso.springjwt.data.dto.authentication;

import java.io.Serializable;

import br.com.hetso.springjwt.data.dto.user.UserResponseDTO;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@NoArgsConstructor(force = true)
public class AuthenticationResponseDTO implements Serializable {

	private final String token;
	private final UserResponseDTO user;
    
}
