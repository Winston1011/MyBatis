package dz.winston.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private Classes classes;
}
