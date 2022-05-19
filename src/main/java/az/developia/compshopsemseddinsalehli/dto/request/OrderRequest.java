package az.developia.compshopsemseddinsalehli.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String compBrand;
    String compModel;
    String compContent;
    String price;
    String buyerName;
    String buyerSurname;
    String buyerPhone;
    String quantity;
    String sellerId;
}
