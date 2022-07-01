package myapp.test;

public class Main {

    private static String csvFile;
    private static String templateFile;

    public static void main(String[] args) {

        csvFile = args[0];
        templateFile = args[1];
        Rows rows = new Rows();
        rows.something(csvFile, templateFile);
        
        
    }
    
}
