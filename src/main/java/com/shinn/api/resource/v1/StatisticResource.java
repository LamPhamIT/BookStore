package com.shinn.api.resource.v1;

import com.shinn.dao.idao.IStatisticDAO;
import com.shinn.model.StatisticModel;
import com.shinn.services.IService.IStatisticService;
import com.shinn.services.impl.StatisticService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/statistics")
public class StatisticResource {
    private IStatisticService statisticService;
    public StatisticResource() {
        statisticService = new StatisticService();
    }

    @GET
    @Path("/months")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatisticModel> getStatisticalByMonth() {
        List<StatisticModel> list = statisticService.statisticalByMonth();
        return list;
    }
    @GET
    @Path("/categoryname")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatisticModel> getStatisticByCategory() {
        List<StatisticModel> list = statisticService.statisticByCategoryName();
        return list;
    }
}
