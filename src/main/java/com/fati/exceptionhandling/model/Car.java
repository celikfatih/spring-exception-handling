package com.fati.exceptionhandling.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * author @ fati
 * created @ 7.09.2020
 */

@Data
@Table
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    private static final long serialVersionUID = -4223668875806414110L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull(message = "Year cannot be empty.")
    int year;

    @NotNull(message = "Brand cannot be empty.")
    String brand;

    @DecimalMin(value = "0.0", inclusive = false)
    BigDecimal price;
}
