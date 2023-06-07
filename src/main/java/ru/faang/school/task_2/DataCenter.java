package ru.faang.school.task_2;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void showState(){
        int i = 1;
        for (Server server : servers) {
            System.out.println("Сервер:" + i + "\n\t" + server);
            i++;
        }
    }

    public boolean isFoundServers() {
        return !servers.isEmpty();
    }

    public double loadOfAllServers() {
        double result = 0.0;
        for (Server server : servers) {
            result += server.getLoad();
        }
        return result;
    }

    public void addNewServer(Server server) {
        servers.add(server);
    }

    public double getMaxLoad() {
        double result = 0.0;
        for (Server server : servers) {
            result += server.getMaxLoad();
        }
        return result;
    }

    private double freeResources() {
        double result = 0.0;
        for (Server server : servers) {
            result += server.freeResources();
        }
        return result;
    }

    public List<Server> getServers() {
        return servers;
    }

    @Override
    public String toString() {
        return "Состояние центра:" +
                "\n\tОбщая макс нагрузка: " + getMaxLoad()+
                "\n\tCвободно ресурсов:" + freeResources() +
                "\n\tЗанято ресурсов:" + loadOfAllServers() +
                "\n\t кол-во серверов: " + servers.size() + "\n";
    }
}
