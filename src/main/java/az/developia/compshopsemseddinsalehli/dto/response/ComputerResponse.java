package az.developia.compshopsemseddinsalehli.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComputerResponse {
    Long id;
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
    UserResponse user;
}
