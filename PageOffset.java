import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter page size (in KB): ");
        int pageSize = scanner.nextInt() * 1024; // convert KB to bytes
        
        System.out.print("Enter a virtual address: ");
        int virtualAddress = scanner.nextInt();
        scanner.close();
        int pageNumber = virtualAddress / pageSize;
        int offset = virtualAddress % pageSize;
        
        System.out.printf("The address %d contains: page number=%d offset=%d", virtualAddress, pageNumber, offset);
    }
}
