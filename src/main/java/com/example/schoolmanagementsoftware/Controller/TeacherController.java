package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherServise teacherServise;

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllTeachers(){
        return ResponseEntity.status(HttpStatus.OK.value()).body(teacherServise.getAllTeachers());
    }

    @GetMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherServise.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(new ApiResponse("Teacher added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherServise.updateTeacher(id,teacher);
        return ResponseEntity.status(HttpStatus.OK.value()).body(new ApiResponse("Teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherServise.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(new ApiResponse("Teacher deleted successfully"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK.value()).body(teacherServise.getTeacherById(id));
    }

}
