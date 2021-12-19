package ro.siit.universitymanagement.services;

import ro.siit.universitymanagement.model.Course;
import ro.siit.universitymanagement.model.Faculty;
import ro.siit.universitymanagement.model.University;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class UniversityManagementService implements MinimumRequirements {

    Map<String, University> universityMap = new TreeMap();

    public void startApp() {

        populateUniversities();
        populateFacultyList();
        populateCourses();

        printUniversities();
    }

    @Override
    public void populateUniversities() {
        University babes = new University("Babes-Bolyai", 1959, "Str. Mihail Kogălniceanu, nr. 1, " +
                "400084, Cluj-Napoca, România", "babes");
        University cuza = new University("Universitatea \"Alexandru Ioan Cuza\"", 1860, "Bulevardul Carol I, Nr.11, 700506, Iaşi, România", "cuza");

        universityMap.put("babes", babes);
        universityMap.put("cuza", cuza);
    }

    @Override
    public void printUniversities() {
        for (Map.Entry<String, University> universityEntry : universityMap.entrySet()) {
            System.out.println(universityEntry.getValue());
        }
    }

    @Override
    public void populateFacultyList() {
        for (Map.Entry<String, University> universityEntry : universityMap.entrySet()) {
            populateFacultyList4University(universityEntry.getValue());
        }
    }

    private void populateFacultyList4University(University university) {
        Map<String, Faculty> facultyMap = new TreeMap<>();

        if (university.equals("babes")) {
            Faculty mateInfo = new Faculty("Matematica si Informatica", "Anca ANDREICA", "Str. Mihail Kogalniceanu nr. 1, RO-400084, Cluj-Napoca", "mate-info");
            Faculty fizica = new Faculty("Fizica", "Daniel-Aurelian Andreica", "Str. Mihail Kogalniceanu nr. 1, RO-400084, Cluj-Napoca", "fizica");
            Faculty drept = new Faculty("Drept", "Serban Diaconescu", "Str.Avram Iancu nr. 11, RO-400089, Cluj-Napoca", "drept");

            facultyMap.put(mateInfo.getShortName(), mateInfo);
            facultyMap.put(fizica.getShortName(), fizica);
            facultyMap.put(drept.getShortName(), drept);
        } else if (university.getShortName().equals("cuza")) {
            Faculty biologie = new Faculty("Biologie", "Marius ȘTEFAN", "B-dul Carol I, Nr. 20A, RO-700505 – Iaşi", "biologie");
            Faculty litere = new Faculty("Litere", "Alexandru Arnold Francisc GAFTON", "B-dul Carol I, Nr. 11, RO-700506 – Iaşi", "litere");
            Faculty istorie = new Faculty("Istorie", "Lucrețiu Ion BÎRLIBA", "B-dul Carol I, Nr.11, RO-700506 – Iaşi", "istorie");

            facultyMap.put(biologie.getShortName(), biologie);
            facultyMap.put(litere.getShortName(), litere);
            facultyMap.put(istorie.getShortName(), istorie);
        }
        university.setFacultyMap(facultyMap);
    }

    public void populateCourses(){
        for (Map.Entry<String, University> universityEntry : universityMap.entrySet()) {
            University university = universityEntry.getValue();

            for (Map.Entry<String, Faculty> facultyEntry : university.getFacultyMap().entrySet()){
                populateCourses4Faculty(facultyEntry.getValue());
            }
        }
    }

    @Override
    public void populateCourses4Faculty(Faculty faculty) {
        Set courses = new TreeSet();
        switch (faculty.getShortName()) {
            case "mate-info":
                Course matetaticiAvansate = new Course("Matematici avansate", "matematici-avansate");
                courses.add(matetaticiAvansate);
                Course bazeDate = new Course("Baze de date", "baze-date");
                courses.add(bazeDate);
                Course inteligentaComputationala = new Course("Inteligenţă computaţională aplicată", "inteligenta-computationala");
                courses.add(inteligentaComputationala);
                break;
        }
        faculty.setCourses(courses);
    }
}
