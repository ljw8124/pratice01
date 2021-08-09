package org.pratice.ex3.dao;

import org.db.util.JdbcTemplate;
import org.pratice.ex3.dto.StoreDTO;


//StoreDTO에 맞게 DB에 넣음
public class StoreDAO {

    public void insert(final StoreDTO storeDTO) throws RuntimeException {

    String sql = "insert into tbl_store (name,area,menus,link) value (?, ?, ?, ?)";
    //preparedStatement를 사용하기 위한 sql 문에서는 ?를 활용함

    new JdbcTemplate() {
        @Override
        protected void execute() throws Exception {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, storeDTO.getName());
            preparedStatement.setString(2, storeDTO.getArea());
            preparedStatement.setString(3, storeDTO.getDesc());
            preparedStatement.setString(4, storeDTO.getLink());

            preparedStatement.executeUpdate();

        }
    }.makeAll();
    }
}
