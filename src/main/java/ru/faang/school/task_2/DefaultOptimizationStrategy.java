package ru.faang.school.task_2;

public class DefaultOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        System.out.println("Балансировка по умолчанию.");
        double curFullLoad = dataCenter.loadOfAllServers();
        double curServ = dataCenter.getServers().size();
        double partLoad = curFullLoad / curServ;
        for (Server server : dataCenter.getServers()) {
            server.setLoad(partLoad);
        }
    }
}
