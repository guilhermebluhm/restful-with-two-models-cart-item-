package br.twoModels.projectRelationshipTwoModels.service.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

class ObjectErrorNotFoundHandlerTest {

    @InjectMocks
    ObjectErrorNotFoundHandler hdlr;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void objectErrorNotFoundHandler() {
        ResponseEntity<FieldForHandlerError> e = hdlr.objectErrorNotFoundHandler(
                new ObjectNotFoundInSearch("erro"),
                new MockHttpServletRequest());
        Assertions.assertEquals(FieldForHandlerError.class,e.getBody().getClass());
        Assertions.assertEquals(ResponseEntity.class,e.getClass());
        Assertions.assertEquals("erro",e.getBody().getMessageError());
        Assertions.assertEquals(400,e.getBody().getError());
        Assertions.assertEquals("",e.getBody().getPath());
    }
}