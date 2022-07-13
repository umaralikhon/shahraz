package com.shahraz.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Registered registered;
    private Login login;
    private String phone;
}
