package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
            .flatMap(x -> x.getSubjects().stream())
            .mapToInt(Subject::getScore)
            .average()
            .orElse(100D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
            .map(pupil -> new Tuple(
                    pupil.getName(),
                    pupil.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .average()
                        .orElse(100D)
                )
            )
            .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
            .flatMap(x -> x.getSubjects().stream())
            .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                Collectors.averagingDouble(Subject::getScore)))
            .entrySet()
            .stream()
            .map(a -> new Tuple(a.getKey(), a.getValue()))
            .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
            .map(pupil -> new Tuple(
                pupil.getName(),
                pupil.getSubjects().stream().mapToDouble(Subject::getScore).sum())
            ).max(Comparator.comparingDouble(Tuple::getScore)).orElse(new Tuple("", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
            .flatMap(x -> x.getSubjects().stream())
            .collect(Collectors.groupingBy(
                Subject::getName,
                Collectors.summingDouble(Subject::getScore))
            )
            .entrySet()
            .stream()
            .map(a -> new Tuple(a.getKey(), a.getValue()))
            .max(Comparator.comparingDouble(Tuple::getScore)).orElse(new Tuple("", 0D));
    }
}