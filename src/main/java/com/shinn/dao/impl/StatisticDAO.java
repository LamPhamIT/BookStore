package com.shinn.dao.impl;

import com.shinn.dao.idao.IStatisticDAO;
import com.shinn.mapper.StatisticMapper;
import com.shinn.model.StatisticModel;

import java.util.List;

public class StatisticDAO extends AbstractDAO<StatisticModel> implements IStatisticDAO {

    @Override
    public StatisticModel statisticByCurrentMonth() {
        String sql = "SELECT DATE_FORMAT(CreatedDate, '%Y-%m') AS Statistic_Date, SUM(Price) AS Total " + "FROM Order_Detail " +
                "WHERE DATE_FORMAT(CreatedDate, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') " +
                "GROUP BY DATE_FORMAT(CreatedDate, '%Y-%m');";
        List<StatisticModel> list= query(sql, new StatisticMapper());
        return list.get(0);
    }

    @Override
    public StatisticModel statisticAVGByMonth() {
        String sql = "SELECT AVg(tempTable.T) AS total FROM (SELECT DATE_FORMAT(CreatedDate, '%Y-%m') AS current_month, SUM(Price) AS T FROM Order_Detail " +
                " GROUP BY DATE_FORMAT(CreatedDate, '%Y-%m')) AS tempTable";
        List<StatisticModel> list= query(sql, new StatisticMapper());
        return list.get(0);
    }

    @Override
    public List<StatisticModel> statisticalByMonth() {
        String sql = "SELECT DATE_FORMAT(CreatedDate, '%Y-%m') AS Statistic_Date, SUM(Price) as Total FROM Order_Detail GROUP BY DATE_FORMAT(CreatedDate, '%Y-%m') ORDER BY DATE_FORMAT(CreatedDate, '%Y-%m')";
        return query(sql, new StatisticMapper());
    }

    @Override
    public List<StatisticModel> statisticByCategoryName() {
        String sql = "SELECT Sum(o.Num) AS Num, c.Category_Name FROM Order_Product AS o INNER JOIN Product AS p ON o.Product_ID = p.Product_ID RIGHT JOIN Category AS c ON p.Category_ID = c.Category_ID GROUP BY c.Category_Name ORDER BY c.Category_Name";
        return query(sql, new StatisticMapper());
    }
}
