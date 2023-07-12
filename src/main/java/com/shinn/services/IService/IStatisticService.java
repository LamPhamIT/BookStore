package com.shinn.services.IService;

import com.shinn.model.StatisticModel;
import com.shinn.services.impl.StatisticService;

import java.util.List;

public interface IStatisticService {
    public StatisticModel statisticByCurrentMonth();
    public StatisticModel statisticAVGByMonth();
    public List<StatisticModel> statisticalByMonth();
    public List<StatisticModel> statisticByCategoryName();
}
