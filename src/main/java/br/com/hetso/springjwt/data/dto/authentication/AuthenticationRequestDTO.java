package br.com.hetso.springjwt.data.dto.authentication;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@NoArgsConstructor(force = true)
public class AuthenticationRequestDTO implements Serializable {

	@NotBlank(message = "Login is required (username or email)")
	private final String login;

	@NotBlank(message = "Password is required")
	private final String password;
}
