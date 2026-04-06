package com.godoy.to_do_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ProblemDetail toProblemDetail() {
        var pb =  ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("Usuário não encontrado");
        pb.setDetail(this.getMessage());
        return pb;
    }
}
