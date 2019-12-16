import java.util.HashMap;
import java.util.Map;

public class Student extends Group
{
    private Map<String, Integer>  disciplines  = new HashMap<>();

    public Student(String faculty, int group, Map<String, Integer> disciplines) {
        super(faculty, group);
        this.disciplines = disciplines;
    }


    public Map<String, Integer> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Map<String, Integer> disciplines) {
        this.disciplines = disciplines;
    }

    public void addToDisciplines(String nameSubject, int score) {
        this.disciplines.put(nameSubject,Integer.valueOf(score));
    }


}
