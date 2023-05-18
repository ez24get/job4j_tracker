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
            for (Subject subject : gpa.subjects()) {
                average += subject.score();
            }
            avg.add(new Label(gpa.name(), average / pupils.size()));
        }
        return avg;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> gpaSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject s : pupil.subjects()) {
                gpaSubject.merge(s.name(), s.score(), Integer::sum);
            }

        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> i : gpaSubject.entrySet()) {
            result.add(new Label(i.getKey(), (double) i.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject s : pupil.subjects()) {
                sum += s.score();
            }
            result.add(new Label(pupil.name(), sum));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                temp.merge(s.name(), s.score(), Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : temp.entrySet()) {
            result.add(new Label(e.getKey(), e.getValue()));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}