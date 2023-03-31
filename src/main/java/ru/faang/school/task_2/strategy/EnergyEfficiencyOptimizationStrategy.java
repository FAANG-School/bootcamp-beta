package ru.faang.school.task_2.strategy;

import ru.faang.school.task_2.DataCenter;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.rebalanceEnergyEfficiency();
    }
}
