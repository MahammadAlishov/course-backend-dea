package az.developia.compshopsemseddinsalehli.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketRequest {
    Long compId;
    Long userId;
    Long quantity;
}
