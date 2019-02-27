package o.k.spring.slearn.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ExceptionResponse
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String detailMessage;
    private ErrorCode errorCode;
}