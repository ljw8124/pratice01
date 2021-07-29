package org.pratice.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@Builder
@NoArgsConstructor

public class StoreDTO {

    private String name;
    private String menu;
    private double lat, lgt;
    private double preference;

}
