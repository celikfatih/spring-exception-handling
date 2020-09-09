package com.fati.exceptionhandling.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

/**
 * author @ fati
 * created @ 7.09.2020
 */

@Data
@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class I18NMessage implements Serializable {

    private static final long serialVersionUID = -2384761293802913519L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String code;
    String locale;
    String message;
}
