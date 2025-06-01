package main.java.proiect.services;


import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Audit {
    private static final String filePath = "files/audit.txt";
    private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void addToAudit(String activity) {
        File file = new File(filePath);
        boolean fileExists = file.exists();
        boolean fileIsEmpty = true;
        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            if (fileExists) {
                fileIsEmpty = file.length() == 0;
            }

            FileWriter outputfile = new FileWriter(file,true);
            CSVWriter writer = new CSVWriter(outputfile);

            if (!fileExists || fileIsEmpty) {
                String[] header = { "Activity", "Date", "Time" };
                writer.writeNext(header);
            }

            LocalDateTime dateTime = LocalDateTime.now();
            String[] data1 = { activity, dateTime.format(formatterDate), dateTime.format(formatterTime)  };
            writer.writeNext(data1);

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
