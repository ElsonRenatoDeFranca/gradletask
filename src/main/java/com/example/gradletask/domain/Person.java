package com.example.gradletask.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@ToString(exclude = {"id"})
@Document(collection = "person")
public class Person {

    @Id
    private String id;
    @NonNull private String firstName;
    @NonNull private String lastName;
}
