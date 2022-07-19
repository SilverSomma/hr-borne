package com.codeborne.hrborne;

import lombok.Value;

import java.sql.Date;
import java.util.UUID;

@Value
public class Absences {
    UUID id;
    UUID userId;
    UUID absenceTypeId;
    Date absenceStart;
    Date absenceEnd;
    String description;
}
