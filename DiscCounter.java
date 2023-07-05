import java.util.Arrays;

public class DiscCounter {

    private static int initialHead = 0;
    private static int[] disk = new int[1000];

    public static void main(String[] args) {
        // Populate disk array with random 1000
        for (int i = 0; i < 1000; i++) {
            disk[i] = (int) (Math.random() * 5000);
        }
        Arrays.sort(disk);

        // Print the number of runs per disk
        System.out.println("FCFS: " + FCFS(disk));
        System.out.println("CSCAN: " + SCAN(disk));
        System.out.println("SCAN: " + CSCAN(disk));
    }

    public static int FCFS(int[] ranArray) {
        int count = 0;
        int currentPos = initialHead;

        for (int i = 0; i < ranArray.length; i++) {
            int diff = Math.abs(ranArray[i] - currentPos);
            count += diff;
            currentPos = ranArray[i];
        }

        return count;
    }

 // Implements the SCAN disk scheduling algorithm
    public static int SCAN(int[] disk) {
        int currentValue = 0;
        int savedValue = disk[initialHead]; // initialize the saved value to the initial head position
        int difference = 0;
        int count = 0;

        // Iterate over the disk queue in reverse order from the initial head position to the beginning of the queue
        for (int i = initialHead - 1; i >= 0; --i) {
            currentValue = disk[i]; // get the current disk request
            difference = Math.abs(savedValue - currentValue); 
            count += difference; 
            savedValue = currentValue; 
        }

        count += savedValue; 
        savedValue = 0; 
        // Iterate over the remaining 1000 in the disk queue in forward order from the initial head position to the end of the queue
        for (int i = initialHead + 1; i < 1000; i++) {
            currentValue = disk[i]; 
            difference = Math.abs(currentValue - savedValue); 
            count += difference; 
            savedValue = currentValue; 
        }

        return count; 
    }

    public static int CSCAN(int[] disk) {
        int currentValue = 0;
        int savedValue = disk[initialHead]; // initialize the saved value to the initial head position
        int difference = 0;
        int count = 0;
        int lastIndex = 4999;

        // Iterate over the remaining 1000 in the disk queue in forward order from the initial head position to the end of the queue
        for (int i = initialHead + 1; i < 1000; i++) {
            currentValue = disk[i]; // get the current disk request
            difference = Math.abs(savedValue - currentValue); // calculate the difference between the current and saved values
            count += difference; // add the difference to the total head movement
            savedValue = currentValue; 
        }

        count += lastIndex - savedValue; 
        savedValue = 0; 
        count += 4999; 

        // Iterate over the remaining 1000 in the disk queue in forward order from the beginning of the queue up to the initial head position
        for (int i = 0; i < initialHead; i++) {
            currentValue = disk[i]; 
            difference = Math.abs(currentValue - savedValue); 
            count += difference; 
            savedValue = currentValue; 
        }

        return count; 
    }


}


