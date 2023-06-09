package ru.faang.school.task_2;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private final List<Server> servers = new ArrayList<>();


    public List<Server> getServers() {
        return servers;
    }


    public void allocateResources(ResourceRequest request) {
        for (Server s : servers) {
            if (!s.addLoad(request.getLoad())) {
                System.out.println("Будет перегружен сервер номер: " + (servers.indexOf(s) + 1));
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        for (Server s : servers) {
            s.removeLoad(request.getLoad());
        }
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server s : servers) {
            totalEnergyConsumption += s.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getAverageLoad() {
        double totalLoad = 0;
        for (Server s : servers) {
            totalLoad += s.getLoad();
        }
        return totalLoad / servers.size();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 0;
        for (Server s : servers) {
            i++;
            str.append(i).append(" ").append(s.toString());
        }
        str.append("Average Load: ").append(getAverageLoad());
        return str.toString();
    }


}
