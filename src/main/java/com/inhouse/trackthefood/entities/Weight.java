package com.inhouse.trackthefood.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weight {
    
    @Id
    @GeneratedValue
    long id;

    long userId;

    float weight;

    // @Temporal(TemporalType.TIMESTAMP)
    Date date;

}
