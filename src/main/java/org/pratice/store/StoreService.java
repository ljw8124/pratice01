package org.pratice.store;

import java.util.Arrays;
import java.util.Optional;

public class StoreService {
    private StoreDTO[] storeDTOS = new StoreDTO[] {
        StoreDTO.builder().name("수정식당").menu("제육쌈밥").lat(10.00).lgt(10.00).preference(3.7).build(),
        StoreDTO.builder().name("훈이돈이").menu("로스카츠").lat(10.00).lgt(10.00).preference(2.5).build(),
        StoreDTO.builder().name("얌샘김밥").menu("한입김밥").lat(10.00).lgt(10.00).preference(1.5).build()
    };

    public StoreDTO findByMenu(String menuName) {

        Optional<StoreDTO> result =
                Arrays.stream(this.storeDTOS).filter(storeDTO -> storeDTO.getMenu().indexOf(menuName) >= 0).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
}
