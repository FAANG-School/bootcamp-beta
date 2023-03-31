package ru.faang.school.task_2.optimization;

import ru.faang.school.task_2.data.DataCenter;
import ru.faang.school.task_2.data.Server;

import java.util.List;

public class LoadBalancingOptimizationStraregy implements OptimizationStrategy{

    @Override //Первое что пришло в голову, наверняка можно было что-то умное и оригинальное придумать :)
    public void optomize(DataCenter dataCenter) {
        List<Server> serverList = dataCenter.servers;
        for (int i = 0; i < serverList.size(); i++){
            Server curServer = serverList.get(i);
            if(curServer.maxLoad/2<curServer.load){
                for(Server server: serverList){
                    if(server!=curServer&&server.maxLoad/2>server.load){
                        double loadForTransfer = curServer.load/2;
                        if(server.load+loadForTransfer<server.maxLoad/1.5){
                            curServer.load-=loadForTransfer;
                            server.load+=loadForTransfer;
                            continue;
                        }
                    }
                }
            }
        }
    }
}
