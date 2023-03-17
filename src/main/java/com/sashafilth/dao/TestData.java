package com.sashafilth.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Generated
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "test_data")
public class TestData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public TestData(String name, String lastName, String middleName, Integer age, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }

    private String name;
    private String lastName;
    private String middleName;
    private Integer age;
    private String gender;
}
