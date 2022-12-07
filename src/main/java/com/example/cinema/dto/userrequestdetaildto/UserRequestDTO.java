package com.example.cinema.dto.userrequestdetaildto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotEmpty(message = "user's name can't be empty")
    private String name;
    @NotEmpty(message = "user's surname can't be empty")
    private String surname;
    @Email(message = "wrong Email form")
    @NotEmpty(message = "user's Email can't be empty")
    private String email;
    @Size(min = 5, max = 20)
    @NotEmpty(message = "user's password can't be empty or invalid size")
    private String password;
    private String pictureUrl;

}
