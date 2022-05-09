package br.twoModels.projectRelationshipTwoModels.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class FieldForHandlerError {

    private LocalDate timestamp;
    private Integer error;
    private String messageError;
    private String path;

}
