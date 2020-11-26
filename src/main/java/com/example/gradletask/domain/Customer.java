package com.example.gradletask.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;
    @NonNull private String firstName;
    @NonNull private String lastName;
}
