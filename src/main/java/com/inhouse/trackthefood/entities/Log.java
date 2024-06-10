package com.inhouse.trackthefood.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue
    long id;

    @PositiveOrZero(message = "User id should be provided for a log")
    long userid;

    @NotEmpty(message = "Log needs at least one item in it.")
    String items[];
    
    @NotEmpty(message = "Log needs at least one serving in it.")
    int servings[];

    int total_cals;
}
