package systemDesign.lowLevelDesign.DesignPatterns.structural.adapter.Client;

import systemDesign.lowLevelDesign.DesignPatterns.structural.adapter.Adaptee.WeightMachineForBabies;
import systemDesign.lowLevelDesign.DesignPatterns.structural.adapter.Adapter.WeightMachineAdapter;
import systemDesign.lowLevelDesign.DesignPatterns.structural.adapter.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
