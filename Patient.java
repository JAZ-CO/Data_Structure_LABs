public class Patient implements Comparable<Patient>{
    // the following attributes
    private String name;
    private int emergencyLevel;
    private int arrivalOrder;

    // a constructor to assign them
    Patient(String n,int el,int ord){
        this.name = n;
        this.emergencyLevel = el;
        this.arrivalOrder = ord;
    }
    // compare to compare between patients emergency and arrival levels
    @Override
    public int compareTo(Patient o) {
        if (this.emergencyLevel > o.emergencyLevel)
            return 1;
        else if (this.emergencyLevel < o.emergencyLevel)
            return -1;
        else{
            if (this.arrivalOrder > o.arrivalOrder)
                return 1;
            else if (this.arrivalOrder < o.arrivalOrder)
                return -1;
            return 0;
        }
    }
    @Override
    public String toString() {
        return "Name: "+ name +", Emergency Level: "+ emergencyLevel + ", ArrivalOrder: " + arrivalOrder;
    }
}
