package ru.faang.school.task_2;

public class DataCenterService {
    OptimizationStrategy optimizationStrategy;
    private DataCenter dataCenter;

    public DataCenterService(OptimizationStrategy optimizationStrategy, DataCenter dataCenter) {
        this.optimizationStrategy = optimizationStrategy;
        this.dataCenter = dataCenter;
    }

    public DataCenterService(DataCenter dataCenter) {
        this.optimizationStrategy = new DefaultOptimizationStrategy();
        this.dataCenter = dataCenter;
    }

    public void balanceLoad() {
        System.out.println("Запущена балансировка.");
        optimizationStrategy.optimize(dataCenter);
    }

    public double getTotalEnergyConsumption() {
        double sum = 0.0;
        if (dataCenter.isFoundServers()) {
            for (Server server : dataCenter.getServers()) {
                sum += server.getEnergyConsumption();
            }
            return sum;
        }
        return sum;
    }

    public void allocateResources(ResourceRequest request) {
        System.out.println("Запрос на выделение ресурса: " + request.getLoad());
        loadExistServers(request);
        // Потрубить необходимое количество серверов, загрузить на максимум кроме последнего          // < 700 + 300 = 1000
        // Найти остаточную нагрузку при максимально заполнености текущих серверов
        // выделить дополнительный сервер и проверить хватает ли загрузки, засетить загруженость.
        while (request.getLoad() > 0) {
            // тут мы окажемся только в том случае если мы не смогли удовлетворить запрос
            // имеющимеся серверами в дата центре
            // выделяем сервер
            Server newServer = new Server(0);
            // нагружаем
            addLoadToServer(request, newServer);
            // добавляем в список
            addNewServer(newServer);
        }
    }

    public void releaseResources(ResourceRequest request) {
        // освободить ресур
        // допустим освободить надо 30
        // допустим 3 сервера: 100/100 100/100 10/100
        // можем поступить так
        // найти сервер с минимальной загрузкой, освободить ресурсы у него
        // могут быть две ситуации: заргузка больше чем запрос, тогда мы просто освободим ресурс у этого сервера
        // 2я - загрузка < чем мы высвобождаем -> освобождаем до 0(т.е полностью осовбодим сервер)
        // а дальше повторяем то что свержу
        System.out.println("Запрос на высвобождение ресурса: " + request.getLoad());
        System.out.println("\tСервер с мин наргузкой: " + getServerWithMinLoad().getLoad());
        while (request.getLoad() > 0) {
            Server server = getServerWithMinLoad();
            double diffLoad = server.getLoad() - request.getLoad();
            if (diffLoad > 0) {
                server.setLoad(diffLoad);
                return;
            }
            else {
                double curLoad = server.getLoad();
                diffLoad = request.getLoad() - curLoad;
                request.setLoad(diffLoad);
                removeServer(server);
            }
        }
    }

    private void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    private void addNewServer(Server server) {
        dataCenter.getServers().add(server);
    }

//        public Optional<Double> getTotalEnergyConsumption(){
//        return dataCenter.getServers().stream().map(Server::getEnergyConsumption).reduce(Double::sum);
//   }

    private Server getServerWithMinLoad() {
        return dataCenter.getServers().stream().min(Server::compareByLoad).get();
    }

    private void loadExistServers(ResourceRequest request){
        for (Server server : dataCenter.getServers()) {
            addLoadToServer(request, server);
            if (request.getLoad() == 0) {
                return;
            }
        }
    }

    private void addLoadToServer(ResourceRequest reqLoad, Server curServer) {
        double load = reqLoad.getLoad();
        double freeRsrc = curServer.freeResources();
        double curLoadServ = curServer.getLoad();
        try {
            curServer.setLoad(curLoadServ + load);
            reqLoad.setLoad(0);
        } catch (IllegalArgumentException ex) {
            curServer.setLoad(curLoadServ+freeRsrc);
            // уменьшаем наш запрос на это значение.
            load -= freeRsrc;
            reqLoad.setLoad(load);
        }
    }

    public void setOptimizationStrategy(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }
}
