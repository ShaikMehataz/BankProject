import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws IOException{
    	
        // TODO Auto-generated method stub
    	
        List<String> bankAccount=Files.readAllLines(Paths.get("C:\\FresherFeb\\bankaccount.txt"));
        List<String> bankTransaction=Files.readAllLines(Paths.get("C:\\FresherFeb\\banktransactions.txt"));
        List<String> result=new ArrayList();
        result.add("Name,Age,Gender,Bank,CardNumber,TransactionDate,Amount");
        bankAccount.remove(0);
        bankTransaction.remove(0);
        for(String str:bankAccount) {
            String[] s=str.split(",");
            for(String str2:bankTransaction) {
                String[] s1=str2.split(",");
                if(Objects.equals(s[4],s1[0])) {
                    result.add(s[0]+"\t"+s[1]+"\t"+s[2]+"\t"+s[3]+"\t\t"+s[4]+"\t\t"+s1[1]+"\t\t"+s1[2]);
                }
            }
        }
        
        Files.write(Paths.get("C:\\FresherFeb\\BankData.txt"),result);
        
         
        ReadFile readFile=new ReadFile();
        readFile.readFile("C:\\FresherFeb\\BankData.txt");
    }
    public void readFile(String fileName)throws IOException{
    	
        File file=new File(fileName);
        FileReader fr=null;
        Scanner scnr=new Scanner(System.in);
        String searchName,str;
        System.out.println("Enter the name:");
        
        searchName=scnr.nextLine();
        
        try {
        	
        	System.out.println("Name"+"\t"+"Age"+"\t"+"Gender"+"\t"+"Bank Name"+"\t"+"Card Number"+"\t"+"Transaction Date"+"\t"+"Amount");
            fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            while((str=br.readLine())!=null) {
                if(str.contains(searchName)) {
                    System.out.println(str);
                }
            }
            
        }catch(FileNotFoundException ex) {
        	
            System.out.println(ex.getMessage());
            
        }catch(Exception e) {
        	
            System.out.println(e.getMessage());
            System.exit(0);
            
        }finally {
        	
            fr.close();
        }
        
    }
    

 

}