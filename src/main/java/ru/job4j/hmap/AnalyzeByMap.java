package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        double count = 0;
        for (Pupil gpa : pupils) {
            for (Subject subject : gpa.subjects()) {
                rsl += subject.score();
                count++;
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> avg = new ArrayList<>();
        for (Pupil gpa : pupils) {
            double average = 0;
            double count = 0;
            for (Subject subject : gpa.subjects()) {
                average += subject.score();
                count++;
            }
            Label students = new Label(gpa.name(), average / count);
            avg.add(students);
        }
        return avg;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> gpaSubject = new LinkedHashMap<>();
        for (int i = 0; i < pupils.size(); i++) {
            double average = 0;
            double count = 0;
            Pupil gpa = pupils.get(i);
            i++;
            List<Subject> subjects = gpa.subjects();
            for (int j = 0; j < subjects.size(); j++) {
                Subject subject = subjects.get(j);
                average += subject.score();
                count++;
                j++;
            }
            gpaSubject.put(pupils.get(i).subjects().get((int) count).name(), average / count);
        }
        return gpaSubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> best = new ArrayList<>();
        for (Pupil gpa : pupils) {
            double max = 0;
            for (Subject subject : gpa.subjects()) {
                max += subject.score();
            }
            Label students = new Label(gpa.name(), max);
            best.add(students);
        }
        Comparator.naturalOrder();
        return avg;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}