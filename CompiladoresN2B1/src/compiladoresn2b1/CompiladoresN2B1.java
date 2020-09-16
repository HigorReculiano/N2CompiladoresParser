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
                    } else if (linha.indexOf("/*") != -1) {
                        linha = linha.substring(0, linha.indexOf("/*"));
                        String comentarios = "";
                        Boolean continuarLeitura = true;
                        while (continuarLeitura) {
                            comentarios = lerArq.readLine();
                            if (comentarios.indexOf("*/") != -1) {
                                if (comentarios.length() > 0) {
                                    linha += comentarios.substring(comentarios.indexOf("*/") + 2, comentarios.length());
                                }
                                    
                                continuarLeitura = false;
                            } else {
                                continuarLeitura = true;
                            }
                        }
                    }
                    //Removendo tabs e mais de um espaço em branco seguido
                    code += linha.replaceAll("\\t", "").replaceAll("\\s+", " ");
                } else {
                    ler = false;
                }
                
            }
            arq.close();
            
            FileWriter myWriter = new FileWriter("input_scring.txt");
            myWriter.write(code);
            myWriter.close();
                
        } catch (IOException e) {
            System.err.printf(e.getMessage());
        }
    }
    
}
