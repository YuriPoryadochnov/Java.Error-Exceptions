import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class ExceptionsTask{
    static public void main(String[] args) {
    ExceptionsTask excp = new ExceptionsTask();
    HashMap<String,Student> ex = new HashMap<String,Student>();
    HashMap<String,Integer> emptySubjects = new HashMap<String,Integer>();
    emptySubjects.put("Dudakov",11);
    ex.put("Pyotr",new Student("id",56,emptySubjects));
    System.out.println(excp.averageScoreOnSpecificSubject("Dudakov",ex));
    }
    public int averageScoreOnAllSubjects(HashMap<String,Student> mapOfStudents, String student)
    {
        if(mapOfStudents.isEmpty()) throw new IllegalArgumentException("No students");
        int sumOfScore = 0;
        int count =0;
        Iterator<Map.Entry<String,Student>> iterator = mapOfStudents.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Student> pair = iterator.next();
            if(pair.getValue().getFaculty() == null) throw new IllegalArgumentException("No faculty");
            if(pair.getValue().getGroup()==0) throw new IllegalArgumentException("No group");
            if (pair.getKey().equals(student)) {
                if (pair.getValue().getDisciplines().isEmpty()) throw new IllegalArgumentException("No subjects in map");
                Iterator<Map.Entry<String, Integer>> iteratorOfSubject = pair.getValue().getDisciplines().entrySet().iterator();
                while (iteratorOfSubject.hasNext()) {
                    Map.Entry<String, Integer> pairOfSubject = iteratorOfSubject.next();
                    if (pairOfSubject.getValue() < 0 || pairOfSubject.getValue() > 10) throw new IllegalArgumentException("Score < 0 or score > 10");
                    sumOfScore += pairOfSubject.getValue();
                    count++;
                }
            }
        }
        return sumOfScore / count;
    }
    public int averageScoreOnSpecificSubjectGroupFaculty(String subject, int group, String faculty, HashMap<String,Student> mapOfStudents)
    {
        if(mapOfStudents.isEmpty()) throw new IllegalArgumentException("No students");
        int sumOfScore = 0;
        int counter = 0;
        Iterator<Map.Entry<String,Student>> iterator = mapOfStudents.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,Student> pair = iterator.next();
            if(pair.getValue().getFaculty() == null) throw new IllegalArgumentException("No faculty");
            if(pair.getValue().getGroup()==0) throw new IllegalArgumentException("No group");
            if(pair.getValue().getGroup() == group && pair.getValue().getFaculty().equals(faculty))
            {
                if (pair.getValue().getDisciplines().isEmpty()) throw new IllegalArgumentException("No subjects in map");
                Iterator<Map.Entry<String,Integer>> iteratorOfSubjects = pair.getValue().getDisciplines().entrySet().iterator();
                while (iteratorOfSubjects.hasNext())
                {
                    Map.Entry<String,Integer> pairOfSubject = iteratorOfSubjects.next();
                    if(pairOfSubject.getKey().equals(subject))
                    {
                        if (pairOfSubject.getValue() < 0 || pairOfSubject.getValue() > 10) throw new IllegalArgumentException("Score < 0 or score > 10");
                        sumOfScore += pairOfSubject.getValue();
                        counter++;
                    }
                }
            }
        }
        return sumOfScore / counter;
    }
    public int averageScoreOnSpecificSubject(String subject,  HashMap<String,Student> mapOfStudents)
    {
        if(mapOfStudents.isEmpty()) throw new IllegalArgumentException("No students");
        int sumOfScore = 0;
        int counter = 0;
        Iterator<Map.Entry<String,Student>> iterator = mapOfStudents.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,Student> pair = iterator.next();
            if(pair.getValue().getFaculty() == null) throw new IllegalArgumentException("No faculty");
            if(pair.getValue().getGroup()==0) throw new IllegalArgumentException("No group");
            if (pair.getValue().getDisciplines().isEmpty()) throw new IllegalArgumentException("No subjects in map");
                Iterator<Map.Entry<String,Integer>> iteratorOfSubjects = pair.getValue().getDisciplines().entrySet().iterator();
                while (iteratorOfSubjects.hasNext())
                {
                    Map.Entry<String,Integer> pairOfSubject = iteratorOfSubjects.next();
                    if(pairOfSubject.getKey().equals(subject))
                    {
                        if (pairOfSubject.getValue() < 0 || pairOfSubject.getValue() > 10) throw new IllegalArgumentException("Score < 0 or score > 10");
                        sumOfScore += pairOfSubject.getValue();
                        counter++;
                    }
                }
        }
        return sumOfScore / counter;
    }

}