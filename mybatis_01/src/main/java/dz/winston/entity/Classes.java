package dz.winston.entity;

import lombok.Data;

import java.util.List;

@Data
public class Classes {
    private int id;
    private String classnumber;
    private List<Student> students;
}
