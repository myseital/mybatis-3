package com.mao;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {

  static {
    try {
      Class.forName(Driver.class.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    Connection root = DriverManager.getConnection("jdbc:mysql://42.192.154.95:3306/fengchuang-admin?tinyInt1isBit=false", "root", "myseital");
    PreparedStatement preparedStatement = root.prepareStatement("select * from warehouse where id=?");
    preparedStatement.setString(1,"1");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      String columnName1 = resultSet.getMetaData().getColumnName(1);
      String columnName2 = resultSet.getMetaData().getColumnName(2);
      System.out.println(columnName1+":"+resultSet.getString(1));
      System.out.println(columnName2+":"+resultSet.getString(2));
    }
    resultSet.close();
    preparedStatement.close();
    root.close();

  }
}
