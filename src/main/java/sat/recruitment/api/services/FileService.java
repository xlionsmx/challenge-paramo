/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sat.recruitment.api.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author lsanmartin
 */
@Service
public class FileService {
    
    
    public List<String> getResourceFileAsListString(String fileName) throws IOException {
        InputStream is = getResourceFileAsInputStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            List<String> lines = reader.lines().collect(Collectors.toList());
            is.close();
            return lines;
        } else {
            throw new RuntimeException("resource not found");
        }
    }
    
    public InputStream getResourceFileAsInputStream(String filename){
        return getClass().getResourceAsStream(filename);
    }
    
    
}
