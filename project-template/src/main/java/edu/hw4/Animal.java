package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("MagicNumber")
public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public static List<Animal> sortByHeight(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .sorted(Comparator.comparing(Animal::height)).toList();
        return animalsResult;
    }

    public static List<Animal> sortByWeight(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .sorted(Comparator.comparing(Animal::weight).reversed()).toList();
        return animalsResult;
    }

    public static Map<Type, Integer> coutingType(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .collect(Collectors.toMap(animal -> animal.type, animal -> 1, Integer::sum));
        return animalsResult;
    }

    public static Animal searchLongestName(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .max(Comparator.comparing(animal -> animal.name.length()))
            .orElse(null);
        return animalsResult;
    }

    public static Sex searchMostSexType(List<Animal> inputAnimals) {
        Map<Animal.Sex, Long> genderCount = inputAnimals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));

        long maleCount = genderCount.getOrDefault(Animal.Sex.M, 0L);
        long femaleCount = genderCount.getOrDefault(Animal.Sex.F, 0L);
        if (maleCount > femaleCount) {
            return Sex.M;
        } else if (femaleCount > maleCount) {
            return Sex.F;
        } else {
            return null;
        }

    }

    public static Map<Type, Animal> searchHeaviestAnimalByType(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .collect(Collectors.toMap(Animal::type, Function.identity(), BinaryOperator
                .maxBy(Comparator.comparing(Animal::weight))));
        return animalsResult;
    }

    public static Animal searchOldestAnimal(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .max(Comparator.comparing(Animal::age))
            .orElse(null);
        return animalsResult;
    }

    public static Optional<Animal> searchHeaviestAnimal(List<Animal> inputAnimals, int k) {
        var animalsResult = inputAnimals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
        return animalsResult;
    }

    public static Integer searchPawsCount(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .mapToInt(Animal::paws).sum();
        return animalsResult;
    }

    public static List<Animal> getAnimalsWhoseAgeIsNotEqualPaws(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .filter(animal -> animal.age != animal.paws())
            .toList();
        return animalsResult;
    }


    public static List<Animal> getBitingAnimals(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .filter(animal -> animal.bites && animal.height > 100)
            .toList();
        return animalsResult;
    }

    public static Integer getCountingByAnimalWeightGreaterHeight(List<Animal> inputAnimals) {
        var animalsResult = (int) inputAnimals.stream()
            .filter(animal -> animal.weight > animal.height)
            .count();
        return animalsResult;
    }

    public static List<Animal> getNameAnimalsWithTwoOrMoreWords(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .filter(animal -> animal.name.split(" ").length > 2)
            .toList();
        return animalsResult;
    }

    public static Boolean isDogWithKHight(List<Animal> inputAnimals, int k) {
        var animalsResult = inputAnimals.stream()
            .anyMatch(animal -> animal.type == Type.DOG && animal.height > k);
        return animalsResult;
    }

    public static Map<Type, Integer> getSumWeightInRangeOfAge(List<Animal> inputAnimals, int k, int l) {
        var animalsResult = inputAnimals.stream()
            .filter(animal -> animal.age >= k && animal.age <= l)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
        return animalsResult;
    }

    public static List<Animal> specialSort(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .sorted(Comparator.comparing(Animal::type)
                                .thenComparing(Animal::sex)
                                    .thenComparing(Animal::name)).toList();
        return animalsResult;
    }

    public static Boolean isSpidersBitesMoreOftenThanDogs(List<Animal> inputAnimals) {
        long bitingSpiders = inputAnimals.stream()
            .filter(animal -> animal.type == Type.SPIDER && animal.bites)
            .count();
        long bitingDogs = inputAnimals.stream()
            .filter(animal -> animal.type == Type.DOG && animal.bites)
            .count();
        if (bitingDogs == 0 && bitingSpiders == 0) {
            return false;
        } else {
            return bitingSpiders > bitingDogs;
        }
    }

    public static Animal getHeaviestFishInLists(List<List<Animal>> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .flatMap(Collection::stream)
            .filter(animal -> animal.type == Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
        return animalsResult;
    }

    public static Map<String, Set<ValidationError>> errorsInRecords(List<Animal> inputAnimals) {
        var animalsResult = inputAnimals.stream()
            .collect(Collectors.toMap(Animal::name, Animal::validationErrors));
        return animalsResult;
    }

    private static Set<ValidationError> validationErrors(Animal animal) {
        Set<ValidationError> validationErrors = new HashSet<>();
        if (animal.type == null || animal.name == null || animal.sex == null) {
            validationErrors.add(new ValidationError(
                "Type, Name and Sex must not be null", ValidationErrorType.NULL_VALUE));
        }
        if (animal.age <= 0 || animal.weight <= 0 || animal.height <= 0) {
            validationErrors.add(new ValidationError(
                "Age, Height and Weight must be greater than 0", ValidationErrorType.INCORRECT_VALUE));
        }
        return validationErrors;
    }

    public static Map<String, String> moreReadableResult(List<Animal> inputAnimals) {
        var animalsResult = errorsInRecords(inputAnimals)
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.join(". ", entry.getValue()
                .stream().map(ValidationError::getMessage).toList())));
        return animalsResult;
    }
}
