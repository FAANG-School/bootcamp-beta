package ru.faang.school.task_2;

import java.util.List;

public class DataCenterService implements OptimizationStrategy{

    DataCenter dataCenter = new DataCenter();



    public double getTotalEnergyConsumption(List<Server> servers){

        double totalEnergyConsumption = servers.stream().mapToDouble(e -> e.getEnergyConsumption()).sum();

        return totalEnergyConsumption;
    }



    public void addServer(List<Server> servers, Server server){
        servers.add(server);
    }

    public void deleteServer(List<Server> servers, Server server){
        servers.remove(server);
    }

//решение требует перепроверки еще очень много раз
    public void allocateResources(ResourceRequest request){

        double requestLoad = request.getLoad();

        int amountOfServers = dataCenter.getServers().toArray().length;

        double avgLoad = requestLoad/amountOfServers;

        if (dataCenter.maxLoadOfDataCenter() < requestLoad)
            System.out.println("The request load is too big");


        for (int i = 0; i < amountOfServers; i++ ) {

            Server currentServer = dataCenter.getServers().get(i);
            currentServer.setLoad(currentServer.getLoad()-avgLoad);

            System.out.println(currentServer.getLoad());

        }

    }


    int amountOfServers = dataCenter.getServers().size();


    public void releaseResources(ResourceRequest request){

        double requestLoad  = request.getLoad();


        if (dataCenter.maxLoadOfDataCenter() < requestLoad)
            System.out.println("The request load is too big");


        double avgLoad = requestLoad/amountOfServers;


        for (int i = 0; i < amountOfServers; i++ ) {

            Server currentServer = dataCenter.getServers().get(i);

            currentServer.setLoad(avgLoad);

            currentServer.setEnergyConsumption(1);


        }

    }

    @Override
    public void optimize(DataCenter dataCenter,ResourceRequest request) {

        double requestLoad = request.getLoad();

            int i = 0;

            while (requestLoad > 0) {

                Server currentServer = dataCenter.getServers().get(i);

                if(requestLoad < currentServer.getMaxLoad()) {

                    currentServer.setLoad(currentServer.getLoad()+requestLoad);
                    requestLoad=0;

                }
                else {
                    requestLoad = requestLoad - currentServer.getMaxLoad();
                    currentServer.setLoad(currentServer.getMaxLoad());
                }

                i++;

            }


            for(int k = 0; k < amountOfServers; k++){

                Server currentServer = dataCenter.getServers().get(k);


                if(currentServer.getLoad() == 0)
                    currentServer.setEnergyConsumption(0);
                else
                    currentServer.setEnergyConsumption(1);
            }


        }

    }

