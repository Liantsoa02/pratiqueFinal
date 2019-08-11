/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pratiquefinal.main;

import com.pratiquefinal.utilitaires.IOJson;
import java.io.IOException;

/**
 *
 * @author Rova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        IOJson lireficher = new IOJson();
        lireficher.loadFileIntoString("json/student.json", "UTF-8");
    }
    
}
