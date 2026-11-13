/*
 * Author
 * Rahul Kumar
 */

package com.spring.data.jpa.papractics.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employee_TBL")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String firstName;
    private String lastName;
    private String sex;
    private String emailId;
}
