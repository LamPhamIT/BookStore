package com.shinn.services.impl;

import com.shinn.dao.idao.IStatisticDAO;
import com.shinn.dao.impl.StatisticDAO;
import com.shinn.model.StatisticModel;
import com.shinn.services.IService.IStatisticService;

import java.util.List;

public class StatisticService implements IStatisticService {
    private IStatisticDAO statisticDAO;
    public StatisticService() {
        statisticDAO = new StatisticDAO();
    }
    @Override
    public StatisticModel statisticByCurrentMonth() {
        return statisticDAO.statisticByCurrentMonth();

    }

    @Override
    public StatisticModel statisticAVGByMonth() {
        return statisticDAO.statisticAVGByMonth();
    }

    @Override
    public List<StatisticModel> statisticalByMonth() {
        return statisticDAO.statisticalByMonth();
    }

    @Override
    public List<StatisticModel> statisticByCategoryName() {
        return statisticDAO.statisticByCategoryName();
    }
}
