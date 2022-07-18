package com.codeborne.hrborne;

import lombok.Value;

import java.sql.Date;
import java.util.UUID;

@Value
public class AbsenceLine {
    UUID id;
    UUID userId;
    Date absenceStart;
    Date absenceEnd;
    String absenceDescription;
    String absenceType;
    String absenceTypeDescription;

}
