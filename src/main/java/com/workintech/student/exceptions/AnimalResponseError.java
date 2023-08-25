package com.workintech.student.exceptions;

import lombok.*;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalResponseError {

    private int status;
    private String message;
    private long timeStamp;

}
