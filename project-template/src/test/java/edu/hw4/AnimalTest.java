package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class AnimalTest {
    List<Animal> animalList = new ArrayList<>(List.of(
        new Animal("Ptichka", Animal.Type.BIRD, Animal.Sex.F, 4, 1, 2, false),
        new Animal("Sobachka", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
        new Animal("Tyzik", Animal.Type.DOG, Animal.Sex.M, 3, 10, 6, false),
        new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false),
        new Animal("Paychok", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 5, true),
        new Animal("PaychokVtoroy", Animal.Type.SPIDER, Animal.Sex.F, 1, 4, 2, false),
        new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false)));
    @Test
    public void animal_testSortByHeightWithValues() {

        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.sortByHeight(testCaseOne);

        // then
        var expectedResult = List.of(
            new Animal("Ptichka", Animal.Type.BIRD, Animal.Sex.F, 4, 1, 2, false),
            new Animal("Paychok", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 5, true),
            new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false),
            new Animal("Sobachka", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false),
            new Animal("PaychokVtoroy", Animal.Type.SPIDER, Animal.Sex.F, 1, 4, 2, false),
            new Animal("Tyzik", Animal.Type.DOG, Animal.Sex.M, 3, 10, 6, false)
            );
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animal_testSortByHeightWithEmptyList() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.sortByHeight(List.of());

        // then
        var expectedResult = List.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animal_sortByWeightWithValuesTest() {

        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.sortByWeight(testCaseOne);

        // then
        var expectedResult = List.of(
            new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false),
            new Animal("Tyzik", Animal.Type.DOG, Animal.Sex.M, 3, 10, 6, false),
            new Animal("Sobachka", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Paychok", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 5, true),
            new Animal("Ptichka", Animal.Type.BIRD, Animal.Sex.F, 4, 1, 2, false),
            new Animal("PaychokVtoroy", Animal.Type.SPIDER, Animal.Sex.F, 1, 4, 2, false),
            new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false)
        );
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animal_weightSortWithEmptyValueTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.sortByWeight(List.of());

        // then
        var expectedResult = List.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animal_coutingTypeWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.coutingType(testCaseOne);

        // then
        var expectedResult = Map.of(
            Animal.Type.DOG, 2,
            Animal.Type.CAT, 1,
            Animal.Type.SPIDER, 2,
            Animal.Type.BIRD, 1,
            Animal.Type.FISH, 1
        );
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_coutingTypeWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.coutingType(List.of());

        // then
        var expectedResult = Map.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_searchLongestNameWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchLongestName(testCaseOne);

        // then
        var expectedResult = new Animal("PaychokVtoroy", Animal.Type.SPIDER, Animal.Sex.F, 1, 4, 2, false);
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_searchLongestNameWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.searchLongestName(List.of());

        // then
        String expectedResult = null;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void animals_searchMostSexTypeWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchMostSexType(testCaseOne);

        // then
        var expectedResult = Animal.Sex.F;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_searchMostSexTypeWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.searchMostSexType(List.of());

        // then
        String expectedResult = null;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_searchHeaviestAnimalByTypeWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchHeaviestAnimalByType(testCaseOne);

        // then
        var expectedResult = Map.of(
            Animal.Type.DOG, new Animal("Tyzik", Animal.Type.DOG, Animal.Sex.M, 3, 10, 6, false),
            Animal.Type.CAT, new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false),
            Animal.Type.SPIDER, new Animal("Paychok", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 5, true),
            Animal.Type.BIRD, new Animal("Ptichka", Animal.Type.BIRD, Animal.Sex.F, 4, 1, 2, false),
            Animal.Type.FISH, new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false)

        );
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_searchHeaviestAnimalByTypeWithEmptyTest() {

        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.searchHeaviestAnimalByType(List.of());

        // then
        var expectedResult = Map.of();
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_searchOldestAnimalWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchOldestAnimal(testCaseOne);

        // then
        var expectedResult = new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false);
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_searchOldestAnimalWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.searchOldestAnimal(List.of());

        // then
        Animal expectedResult = null;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void animals_searchHeaviestAnimalWithAnswerTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchHeaviestAnimal(testCaseOne,3);

        // then
        Optional<Animal> expectedResult = Optional.of(new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false));
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void heaviestAnimalWithoutAnswerTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchHeaviestAnimal(testCaseOne,1);

        // then
        Optional<Animal> expectedResult = Optional.empty();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_searchPawsCountWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.searchPawsCount(testCaseOne);

        // then
        var expectedResult = 30;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_pawsCountWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.searchPawsCount(List.of());

        // then
        var expectedResult = 0;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_getAnimalsWhoseAgeIsNotEqualPaws() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.getAnimalsWhoseAgeIsNotEqualPaws(testCaseOne);

        // then
        var expectedResult = List.of(
            new Animal("Ptichka", Animal.Type.BIRD, Animal.Sex.F, 4, 1, 2, false),
            new Animal("Sobachka", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Tyzik", Animal.Type.DOG, Animal.Sex.M, 3, 10, 6, false),
            new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false),
            new Animal("Paychok", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 5, true),
            new Animal("PaychokVtoroy", Animal.Type.SPIDER, Animal.Sex.F, 1, 4, 2, false),
            new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false)

        );
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getAnimalsWhoseAgeIsNotEqualPawsWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.getAnimalsWhoseAgeIsNotEqualPaws(List.of());

        // then
        var expectedResult = List.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getBitingAnimalsWithAnswerTest() {
        // given
        var testCaseOne = animalList;
        testCaseOne.add(new Animal("acool", Animal.Type.FISH, Animal.Sex.M, 1, 101, 30, true));
        // when
        var answer = Animal.getBitingAnimals(testCaseOne);

        // then
        var expectedResult = List.of(new Animal("acool", Animal.Type.FISH, Animal.Sex.M, 1, 101, 30, true));

        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getBitingAnimalsEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.getBitingAnimals(List.of());

        // then
        var expectedResult = List.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getCountingByAnimalWeightGreaterHeightWithValuesTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.getCountingByAnimalWeightGreaterHeight(testCaseOne);

        // then
        var expectedResult = 4;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_getCountingByAnimalWeightGreaterHeightWithEmptyTest() {

        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.getCountingByAnimalWeightGreaterHeight(List.of());

        // then
        var expectedResult = 0;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_getNameAnimalsWithTwoOrMoreWordsWithAnswerTest() {
        // given
        var testCaseOne = animalList;
        testCaseOne.add(new Animal("acool coola lu", Animal.Type.FISH, Animal.Sex.M, 1, 101, 30, true));
        // when
        var answer = Animal.getNameAnimalsWithTwoOrMoreWords(testCaseOne);

        // then
        var expectedResult = List.of(new Animal("acool coola lu", Animal.Type.FISH, Animal.Sex.M, 1, 101, 30, true));

        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getNameAnimalsWithTwoOrMoreWordsWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.getNameAnimalsWithTwoOrMoreWords(List.of());

        // then
        var expectedResult = List.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_isDogWithKHightTrueTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.isDogWithKHight(testCaseOne,2);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_isDogWithKHightWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.isDogWithKHight(List.of(),2);

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getSumWeightInRangeOfAgeWithAnswerTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.getSumWeightInRangeOfAge(testCaseOne,4,4);

        // then
        var expectedResult = Map.of(
            Animal.Type.BIRD, 2
        );
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_getSumWeightInRangeOfAgeWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.getSumWeightInRangeOfAge(List.of(),4,4);

        // then
        var expectedResult = Map.of(
        );
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_specialSortWithValuesTest() {

        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.specialSort(testCaseOne);

        // then
        var expectedResult = List.of(
            new Animal("Kitty", Animal.Type.CAT, Animal.Sex.F, 5, 2, 10, false),
            new Animal("Sobachka", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Tyzik", Animal.Type.DOG, Animal.Sex.M, 3, 10, 6, false),
            new Animal("Ptichka", Animal.Type.BIRD, Animal.Sex.F, 4, 1, 2, false),
            new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false),
            new Animal("Paychok", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 5, true),
            new Animal("PaychokVtoroy", Animal.Type.SPIDER, Animal.Sex.F, 1, 4, 2, false)
        );
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_specialSortWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.specialSort(List.of());

        // then
        var expectedResult = List.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_isSpidersBitesMoreOftenThanDogsWithAnswerTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.isSpidersBitesMoreOftenThanDogs(testCaseOne);

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_isSpidersBitesMoreOftenThanDogsWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.isSpidersBitesMoreOftenThanDogs(List.of());

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_getHeaviestFishInListsWithAnswerTest() {
        // given
        var testCaseOne = animalList;
        // when
        var answer = Animal.getHeaviestFishInLists(List.of(testCaseOne));

        // then
        var expectedResult = new Animal("Fishka", Animal.Type.FISH, Animal.Sex.M, 2, 3, 1, false);
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void animals_getHeaviestFishInListsWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.getHeaviestFishInLists(List.of());

        // then
        Animal expectedResult = null;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void animals_errorsInRecordsWithValuesTest() {
        // given
        var testCaseOne = animalList;
        testCaseOne.add(new Animal("", Animal.Type.CAT, null, -10, 2, 5, true));
        testCaseOne.add(new Animal("ip", null, null, 100,3456, 4, true));
        // when
        var answer = Animal.errorsInRecords(testCaseOne);

        // then
        var expectedResult = Map.of(
            "Fishka", Set.of(),
            "Paychok", Set.of(),
            "PaychokVtoroy", Set.of(),
            "Ptichka", Set.of(),
            "Kitty", Set.of(),
            "Sobachka", Set.of(),
            "Tyzik", Set.of(),
            "", Set.of(new ValidationError("Type, Name and Sex must not be null", ValidationErrorType.NULL_VALUE), new ValidationError("Age, Height and Weight must be greater than 0", ValidationErrorType.INCORRECT_VALUE)),
            "ip", Set.of(new ValidationError("Type, Name and Sex must not be null", ValidationErrorType.NULL_VALUE)));
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void errorsInRecordsWithEmptyTest() {
        // given
        var testCaseOne = List.of();
        // when
        var answer = Animal.errorsInRecords(List.of());

        // then
        var expectedResult = Map.of();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void moreReadableResultWithValuesTest() {
        // given
        var testCaseOne = animalList;
        testCaseOne.add(new Animal("ip", null, null, 100,3456, 4, true));
        // when
        var answer = Animal.moreReadableResult(testCaseOne);

        // then
        var expectedResult = Map.of(
            "Fishka", "",
            "Paychok", "",
            "PaychokVtoroy", "",
            "Ptichka", "",
            "Kitty", "",
            "Sobachka", "",
            "Tyzik", "",
            "ip", "Type, Name and Sex must not be null"
        );
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}

