package com.bfm.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@ToString
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

}
