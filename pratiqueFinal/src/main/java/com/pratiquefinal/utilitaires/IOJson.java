/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pratiquefinal.utilitaires;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
//import org.json.JSONObject;
import net.sf.json.JSONObject;


/**
 *
 * @author Rova
 */
public class IOJson {
    //lecture du fichier
    public static void loadFileIntoString (String filePath, String fileEncoding) throws
            FileNotFoundException, IOException {
            String mainJSON = IOUtils.toString(new FileInputStream(filePath), fileEncoding);

            JSONObject student = JSONObject.fromObject(mainJSON);
            int id = student.getInt("student_id");
            String fName = student.getString("first_name");
            String lName = student.getString("last_name");
            String dob = student.getString("date_birth");
            boolean active = student.getBoolean("active");
            double gpa = student.getDouble("GPA");
            System.out.println(id+"-"+fName+"-"+lName+"-"+dob+"-"+active+"-"+gpa);
            
            JSONArray listeResultat = student.getJSONArray("results");
            JSONObject singleCourse;
            String title, cid;
            double mark;
            System.out.println("RESULTATS: ");
            for(int i = 0; i < listeResultat.size(); i++){
                singleCourse = listeResultat.getJSONObject(i);
                cid=singleCourse.getString("course_id");
                title = singleCourse.getString("course_title");
                mark = singleCourse.getDouble("mark");
                
                System.out.println(cid+"-"+title+"-"+mark);
            }
            
        
    }
    
    //ecriture de fichier
    public static void saveStringIntoFile (String filePath, String contentToSave) throws 
            FileNotFoundException, IOException{
        File f = new File (filePath);
        FileUtils.writeStringToFile(f, contentToSave, "UTF-8");
    }
    
}
