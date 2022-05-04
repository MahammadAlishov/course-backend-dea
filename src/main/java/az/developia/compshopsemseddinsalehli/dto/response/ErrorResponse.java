package az.developia.compshopsemseddinsalehli.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private Integer code;
    private String path;
    private String message;
    private Integer errorCode;
}
