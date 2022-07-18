package com.codeborne.hrborne;

import lombok.Value;

import java.sql.Date;
import java.util.UUID;

@Value
public class AbsenceLine {
    UUID userId;
    String type;
    Date start;
    Date end;
    String description;
}
