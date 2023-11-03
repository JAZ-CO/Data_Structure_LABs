import java.util.Arrays;

public class Hospital {
    public static void main(String[] args) {
        Patient[] patients = new Patient[10];
        patients[0] = new Patient("Ali",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[1] = new Patient("Saleem",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[2] = new Patient("Jamaal",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[3] = new Patient("Thamer",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[4] = new Patient("Muhsin",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[5] = new Patient("Said",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[6] = new Patient("Qasim",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[7] = new Patient("Maryam",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[8] = new Patient("Ramadhan",(int)(Math.random()*5+1),(int)(Math.random()*10+1));
        patients[9] = new Patient("Zainab",(int)(Math.random()*5+1),(int)(Math.random()*10+1));

        System.out.println("The original order of patients arrival is:");
        for (Patient p: patients)
            System.out.println(p);

        BinaryHeap<Patient> patientsOrder = new BinaryHeap<>();
        for (int i = 0; i < patients.length; i++) {
            patientsOrder.enqueue(patients[i]);
        }

        // to give spacing
        System.out.println();

        System.out.println("The TREATMENT order of patients arrival is:");
        Object[] patientSort = patientsOrder.heapSort();
        for (Object p: patientSort)
            System.out.println(p);
    }
}