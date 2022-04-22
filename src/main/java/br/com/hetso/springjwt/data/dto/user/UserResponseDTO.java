package br.com.hetso.springjwt.data.dto.user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@JsonPropertyOrder(value = {"id"})
public class UserResponseDTO extends UserDTO {
    private final Long id;
    
    private final Boolean enabled;
    private final Boolean accountNonLocked;
    private final Boolean accountNonExpired;
    private final Boolean credentialsNonExpired;
}
