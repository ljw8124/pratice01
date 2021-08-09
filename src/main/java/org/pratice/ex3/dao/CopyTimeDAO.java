package org.pratice.ex3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//bad code
public class CopyTimeDAO {

    static { //이 블럭은 클래스 초기화 블럭으로 클래스가 처음 로딩될 때 한번만 수행하기위해서 선언 -> class생성하면서 한 번만 생성
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //static에 걸리면서 예외가 필요
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getTime() throws RuntimeException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String currentTime = null;

        try { //try()은 자동 close
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bit08db", "bituser", "bituser");
            preparedStatement = connection.prepareStatement("select now()"); //준비
            resultSet = preparedStatement.executeQuery(); //전송(커서를 이동)

            resultSet.next(); //데이터 하나만 보내는 경우

            currentTime = resultSet.getString(1); //사실 db에서는 시간으로 나오지만 문자열로 나올 수도 있음(자바로 불러오는 것은 자바에서 설정)


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally { //close하기 위해서 사용
            if(resultSet != null) { //if문을 이용하여 무작정 닫히지 않게 설정
                try { resultSet.close(); } catch (Exception e) {}
            }
            if(preparedStatement != null) {
                try { preparedStatement.close(); } catch (Exception e) {}
            }
            if(connection != null) {
                try { connection.close(); } catch (Exception e) {}
            }
        }
        return currentTime;
    }
}
