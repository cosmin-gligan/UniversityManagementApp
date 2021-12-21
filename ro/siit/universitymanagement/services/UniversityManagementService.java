package ro.siit.universitymanagement.services;

import ro.siit.universitymanagement.model.*;

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
        populateProfessors();
        populateEmployees();
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
            Faculty mateInfo = new Faculty("Matematica si Informatica", "Anca ANDREICA", "Str. Mihail Kogalniceanu nr. 1, RO-400084, Cluj-Napoca", "mate-info", FacultyProfileEnum.REAL);
            Faculty fizica = new Faculty("Fizica", "Daniel-Aurelian Andreica", "Str. Mihail Kogalniceanu nr. 1, RO-400084, Cluj-Napoca", "fizica", FacultyProfileEnum.REAL);
            Faculty drept = new Faculty("Drept", "Serban Diaconescu", "Str.Avram Iancu nr. 11, RO-400089, Cluj-Napoca", "drept", FacultyProfileEnum.UMAN);

            facultyMap.put(mateInfo.getShortName(), mateInfo);
            facultyMap.put(fizica.getShortName(), fizica);
            facultyMap.put(drept.getShortName(), drept);
        } else if (university.getShortName().equals("cuza")) {
            Faculty biologie = new Faculty("Biologie", "Marius ȘTEFAN", "B-dul Carol I, Nr. 20A, RO-700505 – Iaşi", "biologie", FacultyProfileEnum.REAL);
            Faculty litere = new Faculty("Litere", "Alexandru Arnold Francisc GAFTON", "B-dul Carol I, Nr. 11, RO-700506 – Iaşi", "litere", FacultyProfileEnum.UMAN);
            Faculty istorie = new Faculty("Istorie", "Lucrețiu Ion BÎRLIBA", "B-dul Carol I, Nr.11, RO-700506 – Iaşi", "istorie", FacultyProfileEnum.UMAN);

            facultyMap.put(biologie.getShortName(), biologie);
            facultyMap.put(litere.getShortName(), litere);
            facultyMap.put(istorie.getShortName(), istorie);
        }
        university.setFacultyMap(facultyMap);
    }

    public void populateCourses() {
        for (Map.Entry<String, University> universityEntry : universityMap.entrySet()) {
            University university = universityEntry.getValue();

            for (Map.Entry<String, Faculty> facultyEntry : university.getFacultyMap().entrySet()) {
                populateCourses4Faculty(facultyEntry.getValue());
            }
        }
    }

    public void populateProfessors() {
        for (Map.Entry<String, University> universityEntry : universityMap.entrySet()) {
            University university = universityEntry.getValue();

            for (Map.Entry<String, Faculty> facultyEntry : university.getFacultyMap().entrySet()) {
                Faculty faculty = facultyEntry.getValue();
                for (Course course : faculty.getCourses()) {
                    populateTeachers4Courses(course);
                }
            }
        }
    }

    @Override
    public void populateCourses4Faculty(Faculty faculty) {
        Set courses = new TreeSet();
        switch (faculty.getShortName()) {
            case "mate-info":
                Course matematiciAvansate = new Course("Matematici avansate", "matematici-avansate");
                courses.add(matematiciAvansate);
                Course bazeDate = new Course("Baze de date", "baze-date");
                courses.add(bazeDate);
                Course inteligentaComputationala = new Course("Inteligenţă computaţională aplicată", "inteligenta-computationala");
                courses.add(inteligentaComputationala);
                break;
            case "fizica":
                Course metodeExperimentale = new Course("Metode experimentale", "metode-experimentale");
                courses.add(metodeExperimentale);
                Course complementeSpectrometrieMoleculara = new Course("Complemente spectrometrie modeleculara", "spectrometrie-moleculara");
                courses.add(complementeSpectrometrieMoleculara);
                Course fizicaSolidului = new Course("Fizica solidului", "fizica-solidului");
                courses.add(fizicaSolidului);
                break;
            case "drept":
                Course teoriaDreptului = new Course("Teoria generală a dreptului", "teoria-dreptului");
                courses.add(teoriaDreptului);
                Course dreptCivil = new Course("Drept civil", "drept-civil");
                courses.add(dreptCivil);
                Course dreptComercial = new Course("Drept comercial", "drept-comercial");
                courses.add(dreptComercial);
                break;
            case "biologie":
                Course biologiaNevertebratelor = new Course("Biologie nevertebratelor", "nevertebrate");
                courses.add(biologiaNevertebratelor);
                Course citologieAnimala = new Course("Citologie animala", "citologie");
                courses.add(citologieAnimala);
                break;
            case "litere":
                Course literaturaUniversala = new Course("Literatura universala", "literatura-universala");
                courses.add(literaturaUniversala);
                Course jurnalism = new Course("Jurnalism", "jurnalism");
                courses.add(jurnalism);
                Course tehniciEditoriale = new Course("Tehnici de productie editoriala", "tehnici-editoriale");
                courses.add(tehniciEditoriale);
                break;
            case "istorie":
                Course arheologie = new Course("Arheologie", "arheologie");
                courses.add(arheologie);
                Course europaMedievala = new Course("Europa medievala", "europa-medievala");
                courses.add(europaMedievala);
                Course europaSecolul20 = new Course("Europa şi lumea în secolul XX. Democraţie şi totalitarism", "europa-secolul20");
                courses.add(europaSecolul20);
                break;
        }
        faculty.setCourses(courses);
    }

    @Override
    public void populateTeachers4Courses(Course course) {
        Set<Professor> professorList = new TreeSet<>();
        switch (course.getShortName()) {
            case "matematici-avansate":
                Professor gheorgheI = new Professor("Gheorghe", "Iutis", "1901222520036", 31, 7600);
                professorList.add(gheorgheI);
                break;
            case "baze-date":
                Professor roxanaC = new Professor("Roxana", "Ciurea", "2950519173255", 26, 7650);
                professorList.add(roxanaC);
                break;
            case "inteligenta-computationala":
                Professor neculaiBolohan = new Professor("Neculai", "Bolohan", "1930310437855", 28, 8000);
                professorList.add(neculaiBolohan);
                break;
            case "metode-experimentale":
                Professor floricaMatau = new Professor("Florica", "Matau", "2900820101278", 31, 8010);
                professorList.add(floricaMatau);
                break;
            case "spectrometrie-moleculara":
                Professor laurentiuRadvan = new Professor("Laurentiu", "Radvan", "1880521328054", 33, 8100);
                professorList.add(laurentiuRadvan);
                break;
            case "fizica-solidului":
                Professor cristinaPreutu = new Professor("Cristina", "Preutu", "2951228220111", 25, 8300);
                professorList.add(cristinaPreutu);
                break;
            case "teoria-dreptului":
                Professor gabrielLeanca = new Professor("Gabriel", "Leanca", "1870711319845", 34, 5570);
                professorList.add(gabrielLeanca);
                break;
            case "drept-civil":
                Professor mihaiCojocaru = new Professor("Mihai", "Cojocaru", "1920406281997", 29, 6750);
                professorList.add(mihaiCojocaru);
                break;
            case "drept-comercial":
                Professor alexandraSavoiu = new Professor("Alexandra", "Savoiu", "2970409271456", 24, 6230);
                professorList.add(alexandraSavoiu);
                break;
            case "nevertebrate":
                Professor danielLazar = new Professor("Daniel", "Lazar", "1980419323644", 23, 4750);
                professorList.add(danielLazar);
                break;
            case "citologie":
                Professor adrianVital = new Professor("Adrian", "Vital", "1910510256905", 30, 5900);
                professorList.add(adrianVital);
                break;
            case "literatura-universala":
                Professor cristianaPacuraru = new Professor("Cristiana", "Pacuraru", "2930825023659", 28, 6300);
                professorList.add(cristianaPacuraru);
                break;
            case "jurnalism":
                Professor adrianLeustean = new Professor("Adrian", "Leustean", "1860622292295", 35, 8400);
                professorList.add(adrianLeustean);
                break;
            case "tehnici-editoriale":
                Professor ovidiuBuruiana = new Professor("Ovidiu", "Buruiana", "1920306169542", 29, 7700);
                professorList.add(ovidiuBuruiana);
                break;
            case "arheologie":
                Professor ioanaNistor = new Professor("Ioana", "Nistor", "2980121187966", 23, 6100);
                professorList.add(ioanaNistor);
                break;
            case "europa-medievala":
                Professor gabrielaPriscaru = new Professor("Gabriela", "Prisacaru", "2871025271861", 34, 9000);
                professorList.add(gabrielaPriscaru);
                break;
            case "europa-secolul20":
                Professor mariaDan = new Professor("Maria", "Dan", "2861025385221", 35, 9250);
                professorList.add(mariaDan);
                break;
        }
        course.setProfessorList(professorList);
    }

    @Override
    public void populateEmployees() {
        for (Map.Entry<String, University> universityEntry : universityMap.entrySet()) {
            University university = universityEntry.getValue();

            for (Map.Entry<String, Faculty> facultyEntry : university.getFacultyMap().entrySet()) {
                populateEmployees4Faculty(facultyEntry.getValue());
            }
        }
    }

    @Override
    public void populateEmployees4Faculty(Faculty faculty) {
        Map<String, Employee> employeeMap = faculty.getEmployees();
        for (Course course : faculty.getCourses()) {
            for (Professor professor : course.getProfessorList()){
                if (!employeeMap.containsKey(professor.getCnp())) {
                    Employee employee = new Employee(professor.getFirstName(), professor.getLastName(), professor.getCnp(), professor.getAge(), professor.getCnp(), professor.getIncome(), DepartmentEnum.PROFESORAT);
                    employeeMap.put(employee.getCnp(), employee);
                }
            }
        }
        faculty.setEmployees(employeeMap);
    }
}
