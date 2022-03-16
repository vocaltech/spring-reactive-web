package fr.vocaltech.spring.reactiveweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String id;
    private String owner;
    private Double balance;
}
