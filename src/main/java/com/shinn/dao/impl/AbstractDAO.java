package com.shinn.dao.impl;

import com.shinn.dao.idao.GenericDAO;
import com.shinn.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements GenericDAO<T> {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    private Connection getConnection() {
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public <T1> List<T1> query(String sql, RowMapper<T1> rowMapper, Object... parameters) {
        List<T1> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(rowMapper.mapRow(resultSet));
            }
            return list;
        } catch (SQLException e) {
            return list;
        } finally {
           try {
               if(connection != null) {
                   connection.close();
               }
               if(statement != null) {
                   statement.close();
               }
               if(resultSet != null) {
                   statement.close();
               }
           } catch (SQLException e) {
               return list;
           }
        }
    }

    @Override
    public <T1> Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            while(resultSet.next()) {
                return resultSet.getLong(1);
            }
//            connection.commit();
            return null;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(resultSet != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                if (parameter instanceof Long) {
                    statement.setLong(i + 1, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(i + 1, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(i + 1, (int) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(i + 1, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
