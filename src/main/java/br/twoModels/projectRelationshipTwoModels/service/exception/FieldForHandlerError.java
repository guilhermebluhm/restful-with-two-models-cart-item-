package br.twoModels.projectRelationshipTwoModels.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldForHandlerError {

    private Long timestamp;
    private Integer error;
    private String messageError;
    private String path;

}
