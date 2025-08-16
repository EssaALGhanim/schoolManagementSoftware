package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    private String area;
    private String street;
    private String building_number;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
