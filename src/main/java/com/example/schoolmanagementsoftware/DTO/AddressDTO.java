package com.example.schoolmanagementsoftware.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "Area is required")
    @Size(min = 2, max = 30, message = "Area must be between 2 and 30 characters")
    private String area;
    @NotEmpty(message = "Street is required")
    @Size(min = 2, max = 30, message = "Street must be between 2 and 30 characters")
    private String street;
    @NotEmpty(message = "Building Number is required")
    @Pattern(regexp = "^\\d{6}$", message = "Building Number must be 6 digits")
    private String building_number;
}
