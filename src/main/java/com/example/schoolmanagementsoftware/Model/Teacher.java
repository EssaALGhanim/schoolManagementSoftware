package com.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "Age is required")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is not valid")
    @Column(columnDefinition = "varchar(30) not null")
    private String email;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
