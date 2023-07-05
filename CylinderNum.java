import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a logical block number: ");
        int logicalBlockNumber = scanner.nextInt();
        
        System.out.print("Enter HD number of cylinders: ");
        int cylinders = scanner.nextInt();
        
        System.out.print("Enter HD number of tracks: ");
        int tracks = scanner.nextInt();
        
        System.out.print("Enter HD number of sectors: ");
        int sectors = scanner.nextInt();
        scanner.close();
        
        int sectorsPerTrack = sectors * cylinders;
        
        int sectorOffset = logicalBlockNumber % sectors;
        
        int trackNumber = (logicalBlockNumber / sectors) % tracks;
        int cylinderNumber = logicalBlockNumber / sectorsPerTrack;
        
        System.out.printf("The logical block number %d is located at <%d, %d, %d>", logicalBlockNumber, cylinderNumber, trackNumber, sectorOffset);
    }
}
