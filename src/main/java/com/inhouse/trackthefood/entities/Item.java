package com.inhouse.trackthefood.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
public class Item {
    @Id
    @GeneratedValue
    long id;

    @NotBlank(message = "Name cannot be blank")
    String name;

    @PositiveOrZero(message = "Calories value must be provided a positive value or a zero.")
    int calories;

    String category;
}
