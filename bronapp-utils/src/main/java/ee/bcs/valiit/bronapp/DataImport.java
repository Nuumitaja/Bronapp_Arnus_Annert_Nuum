package ee.bcs.valiit.bronapp;

import ee.bcs.valiit.bronapp.data.Doctor;
import ee.bcs.valiit.bronapp.data.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DataImport {

    @Autowired
    private DoctorRepository doctorRepository;

    private void start(String[] args) {
        try {
            String filePath = args[0];
            Path path = Paths.get(filePath);
            List<String> fileLines = Files.readAllLines(path);
            for (String fileLine : fileLines) {
                String[] lineParts = fileLine.split(", ");
                Doctor doctor = new Doctor();
                doctor.setDoctorname(lineParts[0]);

                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                Date date = format.parse(lineParts[1] +" "+ lineParts[2]);
                doctor.setDate(date);

                doctor = doctorRepository.save(doctor);
                doctor.setActive(true);
            }
        } catch (IOException | ParseException e) {
            System.err.println("Importfaili lugemine ebaõnnestus!");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            DataImport dataImport = applicationContext.getBean(DataImport.class);
            dataImport.start(args);
        } else {
            System.out.println("Importfaili asukoht on kohustuslik!");
        }
    }

}

