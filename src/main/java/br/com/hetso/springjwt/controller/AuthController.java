package br.com.hetso.springjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.hetso.springjwt.data.dto.authentication.AuthenticationRequestDTO;
import br.com.hetso.springjwt.data.dto.authentication.AuthenticationResponseDTO;
import br.com.hetso.springjwt.data.dto.user.UserResponseDTO;
import br.com.hetso.springjwt.data.model.UserModel;
import br.com.hetso.springjwt.security.jwt.JwtTokenService;
import br.com.hetso.springjwt.utils.MapperUtils;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/auth", consumes = { "application/json" }, produces = { "application/json" })
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService tokenService;

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponseDTO> signin(@Validated @RequestBody AuthenticationRequestDTO authDTO) {
        UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(
                authDTO.getLogin(), authDTO.getPassword());

        try {
            Authentication authentication = authenticationManager
                    .authenticate(userPassAuthToken);

            String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok(AuthenticationResponseDTO
                    .builder()
                    .token(token)
                    .user(MapperUtils
                            .convert((UserModel) authentication.getPrincipal(), UserResponseDTO.class))
                    .build());
        } catch (BadCredentialsException e) {

            return ResponseEntity.badRequest().build();
        } catch (DisabledException e) {

            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "USER IS DISABLED");
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
