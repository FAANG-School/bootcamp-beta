package ru.faang.school.task_2;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    private static final Logger LOGGER = Logger.getLogger("LoadBalancingOptimizationStrategy");

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        LOGGER.log(Level.INFO, "Servers before optimization: " + servers);
        servers.sort(Comparator.comparingDouble(Server::getLoadCoeff).reversed());

        double averageLoadCoeff = servers.stream()
                .map(Server::getLoadCoeff)
                .reduce(Double::sum)
                .get() / servers.size();

        double remainder = 0;
        for (Server server : servers) {
            double loadMustBe = averageLoadCoeff * server.getMaxLoad();
            if (server.getLoadCoeff() > averageLoadCoeff) {
                double tempReminder = server.getLoad() - loadMustBe;
                remainder += tempReminder;
                server.removeLoad(tempReminder);
            } else if (server.getLoadCoeff() < averageLoadCoeff) {
                if (remainder > loadMustBe) {
                    remainder -= loadMustBe - server.getLoad();
                    server.addLoad(loadMustBe - server.getLoad());
                } else {
                    server.addLoad(remainder);
                    remainder = 0;
                }
            }
        }
        LOGGER.log(Level.INFO, "Servers after optimization: " + servers);
    }
}
