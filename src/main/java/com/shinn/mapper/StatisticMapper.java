package com.shinn.mapper;

import com.shinn.model.StatisticModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticMapper implements RowMapper<StatisticModel> {
    @Override
    public StatisticModel mapRow(ResultSet resultSet) {
        StatisticModel statisticModel = new StatisticModel();
        try {

            statisticModel.setTotal(resultSet.getFloat("total"));

        } catch (SQLException e) {

        }
        try {
            Integer num = resultSet.getInt("Num");
            statisticModel.setNum((num == null)? 0: num);
        } catch (SQLException e) {

        }
        try {

            statisticModel.setCategoryName(resultSet.getString("Category_Name"));

        } catch (SQLException e) {

        }
        try {
            statisticModel.setStatisticDate(resultSet.getString("Statistic_Date"));

        } catch (SQLException e) {

        }
        try {

            statisticModel.setCategory(resultSet.getString("Category"));
        } catch (SQLException e) {

        }
        return statisticModel;
    }
}
