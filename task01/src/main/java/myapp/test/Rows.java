package myapp.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Rows {

    public void something(String csvFile, String templateFile){

        //read the csv file downloaded and print it out
        String sauce = csvFile;
        String sauce2 = templateFile;

        File dataSource = new File(sauce);


        try {
            BufferedReader br = new BufferedReader(new FileReader(dataSource));
            
            //create an arrayList to store each line
            ArrayList<String> lines = new ArrayList<>();
            String line = "";

            while((line=br.readLine())!=null){
                lines.add(line);
            }
            br.close();
            
            //remove the first line 
            lines.remove(0);

            //testing
            for(int i=0; i<lines.size(); i++){
                System.out.println(lines.get(i));
            }


            //store each Row object in an Array List
            ArrayList<Row> listOfRows = new ArrayList<>();

            //with each element in the array create a new Row object and assign the instnace variables of each object with .split,
            for(int i=0; i<lines.size(); i++){
                String[] variablez = lines.get(i).split(",");
                String fn = variablez[0];
                String ln = variablez[1];
                String ad = variablez[2];
                String ys = variablez[3]; 
                Row row = new Row(fn,ln,ad,ys);
                listOfRows.add(row);
            }

            //testing
            // System.out.println(listOfRows.size());
            // System.out.println(listOfRows.get(2).first_name);
            // System.out.println("");
            // System.out.println(" ");
            

            //READING THE TEMPLATE FILE
            BufferedReader br2 = new BufferedReader(new FileReader(sauce2));
            String wordz;
            //storing each line in the template file in an ArrayList<String>
            ArrayList<String> forTemp = new ArrayList<>();
            while((wordz=br2.readLine())!=null){
                forTemp.add(wordz);
            }
            br2.close();

            //printing out the array list to check
            for(int i=0; i<forTemp.size(); i++){
                
                ArrayList<String> forTemp2 = new ArrayList<>();

                for(String pp: forTemp){
                    forTemp2.add(pp);
                }


                if(forTemp2.get(i).contains("__address__")){
                    String replacement = forTemp.get(i).replaceAll("__address__", listOfRows.get(i).getAddress());

                    forTemp.set(i, replacement);
                }

                if(forTemp2.get(i).contains("__first_name__")){
                    String replacement = forTemp.get(i).replaceAll("__first_name__", listOfRows.get(i).getFirst_name());

                    forTemp.set(i, replacement);
                }

                if(forTemp2.get(i).contains("__years__")){
                    String replacement = forTemp.get(i).replaceAll("__years__", listOfRows.get(i).getYears());

                    forTemp.set(i, replacement);
                }


                for(int j=0;j<forTemp.size(); j++){
                    System.out.println(forTemp.get(j));
                }
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
    
}
