package com.neko.seed.user.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class SignInData {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
