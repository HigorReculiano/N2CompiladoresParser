package compiladoresn2b1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompiladoresN2B1 {

    public static void main(String[] args) {
        try {
            FileReader arq = new FileReader("jquery.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            
            String code = "";
            
            String linha = null;
            Boolean ler = true;
            while (ler) {
                linha = lerArq.readLine();
                if (linha != null) {
                    //Removendo comentários
                    if (linha.indexOf("//") != -1) {
                        linha = linha.replace(linha.substring(linha.indexOf("//"), linha.length()), "");
                    }
                    //Removendo tabs e mais de um espaço em branco seguido
                    code += linha.replaceAll("\\t", "").replaceAll("\\s+", " ");
                } else {
                    ler = false;
                }
                
            }
            System.out.printf("code -> " +code);
            arq.close();
            
            FileWriter myWriter = new FileWriter("input_scring.txt");
            myWriter.write(code);
            myWriter.close();
                
        } catch (IOException e) {
            System.err.printf(e.getMessage());
        }
        
    }
    
}
