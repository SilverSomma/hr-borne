package com.codeborne.hrborne;

import lombok.Value;

import java.util.UUID;

@Value
public class Name {
    UUID id;
    String firstName;
    String lastName;
}
