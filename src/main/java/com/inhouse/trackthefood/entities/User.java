package com.inhouse.trackthefood.entities;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    long id;
    String firstName;
    String lastName;

    @NotBlank(message = "mail field is mandatory for user.")
    String mail;
    
    @Positive(message = "valid height (in cms) is mandatory.")
    float height; // Centimeters

    @Positive(message = "valid weight (in kgs) in mandatory.")
    float weight; // Kgs

    @Positive(message = "valid age (in years) is mandatory.")
    int age;

    float bmi;
    int bmr;
    ArrayList<Long> logs;

    public long newLog(long id){
        if(logs == null){
            logs = new ArrayList<Long>();
        }
        this.logs.add(id);
        return id;
    }
}
