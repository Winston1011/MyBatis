package dz.winston.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private long id;
    private String username;
    private String password;
    private int age;
}
