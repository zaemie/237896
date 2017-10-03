//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #237896
//Name: #Mohamad Zaemie Azamry Bin Mohamed Zain
package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Scan {
    File file;
    String fileContent[][];
    LinkedList<String> listFileContent;
    public int noIssue;
    public int totalJava;

    public void scan(String[] listJavaFile) {
        for (String listJavaFile1 : listJavaFile) {
            try (final BufferedReader br = new BufferedReader(new FileReader(listJavaFile1))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("public static void main")) {
                        noIssue++;
                    }
                }
            }catch (IOException e) {
                
            }
            totalJava++;
        }
    }
    static String[] filterJava(Collection<File> listAllFileName) {
        LinkedList<String> fb = new LinkedList();
        Iterator<File> a = listAllFileName.iterator();
        File c;
        while (a.hasNext()) {
            c = a.next();
            if (c.getName().endsWith(".java")) {
                fb.add(c.getAbsolutePath());
            }
        }
        String[] listJavaFile = new String[fb.size()];
        for (int i = 0; i < fb.size(); i++) {
            listJavaFile[i] = fb.get(i);
        }
        return listJavaFile;
    }
    
}
