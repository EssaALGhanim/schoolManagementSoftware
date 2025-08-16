package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Service.AddressServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressServise addressServise;

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllAddresses(){
        return ResponseEntity.status(HttpStatus.OK.value()).body(addressServise.getAllAddresses());
    }

    @GetMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressServise.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(new ApiResponse("Address added successfully"));
    }

    @GetMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressServise.updateAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK.value()).body(new ApiResponse("Address updated successfully"));
    }
}
