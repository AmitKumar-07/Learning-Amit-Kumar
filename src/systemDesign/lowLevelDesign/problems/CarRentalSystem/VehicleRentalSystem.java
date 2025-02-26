package systemDesign.lowLevelDesign.problems.CarRentalSystem;


import java.util.List;

public class VehicleRentalSystem {

    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.storeList = stores;
        this.userList = users;
    }


    public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        for(Store store: storeList){
            if(location.pincode==store.getStoreLocation().pincode){
                System.out.println("found required store");
                return store;
            }
        }
        return storeList.get(0);
    }



    //addUsers

    //remove users


    //add stores

    //remove stores



}
