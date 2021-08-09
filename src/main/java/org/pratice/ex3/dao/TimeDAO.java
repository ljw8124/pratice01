package org.pratice.ex3.dao;

import org.db.util.JdbcTemplate;

//buffer 이용, 익명클래스와 JdbcTemplate를 이용한 안전하고 간결한 DB연결/해제
public class TimeDAO {


    public String getTime() throws RuntimeException {

        StringBuffer buffer = new StringBuffer();
        //buffer는 가변클래스로 불변인 String을 담을 수 있는 그릇과 같은 개념.
        //append(문자열에 다른 문자열 추가),capacity(현재 버퍼의 크기를 알아보는 메서드)
        //delete(말그대로 삭제),insert(지정한 위치에 문자열을 삽입 ex. insert(0, hello) => 0번째 순서에 hello 삽입)
        //등등 많은 사용법이 있음.

        new JdbcTemplate() { //익명클래스 => 람다 함수로 축소 가능
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement("select now()");
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                buffer.append(resultSet.getString(1));
            }
        }.makeAll();

     return buffer.toString(); //buffer를 문자열로 반환해서 return.
    }
}

//CopyTimeDAO에 비해서 코드량도 적고 자동으로 connection, close가 가능
