package ru.faang.school.task_2;

public class StandartOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        long serversQuantity = dataCenter.getServers().size();
        double totalLoadOnDataCenter = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad).sum();
        double optimalLoad = totalLoadOnDataCenter / serversQuantity;
        dataCenter.getServers().stream()
                .peek(server -> server.unloadServer())
                .forEach(server -> {
                    server.setLoad(optimalLoad);
                    server.setEnergyConsumption(optimalLoad * 5);
                });


    }


}
