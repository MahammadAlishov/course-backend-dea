package az.developia.compshopsemseddinsalehli.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotFoundException extends RuntimeException {
    Integer code;

    public NotFoundException(Class clazz, Long id, Integer code) {
        super(clazz.getSimpleName() + " not found with id: " + id);
        this.code = code;
    }

    public NotFoundException(Class clazz, String value, Integer code) {
        super(clazz.getSimpleName() + " not found with value: " + value);
        this.code = code;
    }
}
