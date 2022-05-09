package az.developia.compshopsemseddinsalehli.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  ComputerRequest {
    String image;
    String brand;
    String model;
    String price;
    String ram;
    String cpu;
    String compNew;
    String content;
    String diskCapacity;
    String diskType;
    String sellerPhone;
    String sellerName;
    Long userId;
}
