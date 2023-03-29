package ru.faang.school.task_2.solution;

public class DataCenterService implements OptimizationStrategy {
    private final DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        if (dataCenter == null) throw new RuntimeException();
        this.dataCenter = dataCenter;
    }

    /** Добавляет переданный сервер в список серверов(датацентр). */
    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    /** Удаляет переданный сервер в список серверов(датацентр).
     * Если элемента нет - возвращает false.
     * */
    public boolean removeServer(Server server) {
        return dataCenter.getServers().remove(server);
    }

    /** Возвращает потреблении электроэнергии всеми серверами.
     *  Если кол-во серверов - 0, возвращает -1
     *  */
    public Double getTotalEnergyConsumption() {
        if (dataCenter.getServers().size() == 0) return -1d;
        Double totalEnergyConsumption = 0d;
        for (Server server : dataCenter.getServers())
            totalEnergyConsumption += server.getEnergyConsumption();
        return totalEnergyConsumption;
    }

    /** Выделяет ресурсы для всех серверов исходя из запроса. */
    public void allocateResources(ResourceRequest request) {
        dataCenter.getServers().forEach(server -> server.setLoad((server.getLoad() - request.getLoad()) < 0 ? 0 
                                                                 // Если server.load < request.load return 0
                : server.getLoad() - request.getLoad()));
    }

    /** Высвобождает ресурсы серверов исходя из запроса. */
    public void releaseResources(ResourceRequest request) {
        dataCenter.getServers().forEach(server -> server.setLoad(server.getLoad() + request.getLoad()));
    }


    @Override
    public void optimize() {
        Double averageEnergyConsumption = getTotalEnergyConsumption() / dataCenter.getServers().size();
        dataCenter.getServers().stream().forEach(server -> server.setLoad(averageEnergyConsumption));
    }
}
