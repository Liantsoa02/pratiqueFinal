/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pratiquefinal.utilitaires;

import com.pratiquefinal.modele.Resultat;
import com.pratiquefinal.modele.Student;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.spi.DirStateFactory;
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
    private static String loadFileIntoString(String filePath, String fileEncoding) throws
            FileNotFoundException, IOException {
        String mainJSON = IOUtils.toString(new FileInputStream(filePath), fileEncoding);
        return mainJSON;
    }

    public static Student parseStudent(String filePath, String fileEncoding) throws IOException {
        String mainJSON = loadFileIntoString(filePath, fileEncoding);

        //objet student class
        Student stu = new Student();

        JSONObject student = JSONObject.fromObject(mainJSON);
        stu.setId(student.getInt("student_id"));
        stu.setfName(student.getString("first_name"));
        stu.setlName(student.getString("last_name"));
        stu.setDob(student.getString("date_birth"));
        stu.setActive(student.getBoolean("active"));
        stu.setGpa(student.getDouble("GPA"));
        //System.out.println(id+"-"+fName+"-"+lName+"-"+dob+"-"+active+"-"+gpa);

        JSONArray listeResultat = student.getJSONArray("results");
        JSONObject singleCourse;
        Resultat result = new Resultat();
        ArrayList<Resultat> resultats = new ArrayList<>();
        System.out.println("RESULTATS: ");
        for (int i = 0; i < listeResultat.size(); i++) {
            result = new Resultat();
            singleCourse = listeResultat.getJSONObject(i);
            result.setCid(singleCourse.getString("course_id"));
            result.setTitle(singleCourse.getString("course_title"));
            result.setMark(singleCourse.getDouble("mark"));
            resultats.add(result);
            //System.out.println(cid+"-"+title+"-"+mark);
        }
        stu.setResultats(resultats);
        System.out.println(stu.toString());
        return stu;
    }

    //ecriture de fichier
    public static void saveStringIntoFile(String filePath, String contentToSave) throws
            FileNotFoundException, IOException {
        File f = new File(filePath);
        FileUtils.writeStringToFile(f, contentToSave, "UTF-8");
    }

    public static void saveStudent(Student s, String filePath) throws IOException {
        
        JSONObject st = new JSONObject();

        st.accumulate("first_Name", s.getfName());
        st.accumulate("last_Name", s.getlName());
        st.accumulate("date_birth", s.getDob());
        JSONObject address = new JSONObject();
        address.accumulate("streetnumber", 1001);
        address.accumulate("streetname", "Sherbrooke");
        address.accumulate("postalcode", "H3S1S1");
        st.accumulate("adresse", address);
        
        saveStringIntoFile(filePath, st.toString());
    }

    public static void saveOther(String filePath) throws IOException {
        
        JSONObject obj = new JSONObject();
        obj.accumulate("id", 12345);
        obj.accumulate("first_Name", "Rova");
        obj.accumulate("last_Name", "Liantsoa");
        
        Date date = new Date ();
        long timestamp = date.getTime();
        obj.accumulate("time_stamp", timestamp);
        
        JSONArray adresses = new JSONArray();
        JSONObject address = new JSONObject();
        address.accumulate("streetnumber", 1001);
        address.accumulate("streetname", "Sherbrooke");
        address.accumulate("postalcode", "H3S1S1");
        adresses.add(address);
        
        address.clear();
        address.accumulate("streetnumber", 3205);
        address.accumulate("streetname", "Linton");
        address.accumulate("postalcode", "H3S1S2");
        adresses.add(address);
        
        obj.accumulate("adresse",adresses);
        saveStringIntoFile(filePath, obj.toString());
    }
}
