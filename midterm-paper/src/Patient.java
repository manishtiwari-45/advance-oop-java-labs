public class Patient implements Comparable<Patient>{
    String name;
    int severity;
    long arrivalTime;

    public Patient(String name, int severity, long arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Patient other){
        if(this.severity != other.severity){
            return Integer.compare(this.severity,other.severity);
        }
        return Long.compare(this.severity, other.severity);
    }
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ", Arrival: " + arrivalTime + ")";
    }
}


