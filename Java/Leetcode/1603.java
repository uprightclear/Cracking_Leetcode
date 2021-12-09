class ParkingSystem {
    int[] lot = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        lot[0] = big;
        lot[1] = medium;
        lot[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(lot[carType - 1] > 0) {
            lot[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */