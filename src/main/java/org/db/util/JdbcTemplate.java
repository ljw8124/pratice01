package org.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//안정적인 jdbc(Java Database Connectivity)연결을 위해서 만듦
//jdbc란 자바에서 데이터베이스를 접속할 수 있도록 만든 자바 API.
public abstract class JdbcTemplate {

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //클래스 로드시 static 필드의 내용 실행 -> class내부에 DriverManager 클래스 메모리에 등록, 동적으로 객체를 가져와 사용 가능.(즉석으로)
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //protected로 선언함으로서 아무렇게나 가져다 쓸 수 없게됨.
    //Connection,PreparedStatement/ResultSet은 전역변수로 선언하면 안됨. 지역변수로 선언 필수!!
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;


    //템플릿 생성 연결후 기능 -> finally에서 close()
    public void makeAll() {
        try {
            makeConnection(); //연결
            execute(); //기능수행
            System.out.println("END");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            finish(); //닫는 코드, 보통 닫는 것은 finally에 있어야함.
        }
    }

    protected abstract void execute() throws Exception; //추상메서드로 선언하여 쓸 때마다 오버라이딩으로 용도에 맞게 사용

    private void makeConnection() throws Exception{ //연결만을 하는 메서드
        System.out.println("Start");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bit08db?serverTimezone=Asia/Seoul","bituser","bituser");
    }

    private void finish() { //연결 상태를 보여주고 연결을 끊는 메서드
        System.out.println("------------finish--------------");
        System.out.println("Template ResultSet: "+ resultSet);
        System.out.println("Template PreparedStatement: "+preparedStatement);
        System.out.println(connection);

        //오류로 인해서 실행되지 않고 connection/resultSet/preparedStatement가 null이 아닌 경우는 연결을 끊지 않음
        if (resultSet != null) {
            try{ resultSet.close(); } catch(Exception e){}
        }

        if (preparedStatement != null){
            try{ preparedStatement.close(); } catch(Exception e){}
        }

        if (connection != null) {
            try{ connection.close(); } catch(Exception e){}
        }
    }
}
