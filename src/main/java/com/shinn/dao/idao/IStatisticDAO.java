package com.shinn.dao.idao;

import com.shinn.model.StatisticModel;

import java.util.List;

public interface IStatisticDAO {
    public StatisticModel statisticByCurrentMonth();
    public StatisticModel statisticAVGByMonth();
    public List<StatisticModel> statisticalByMonth();
    public List<StatisticModel> statisticByCategoryName();
}
