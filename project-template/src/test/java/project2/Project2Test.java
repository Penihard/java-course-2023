package project2;

import edu.project2.console.ConsoleRender;
import edu.project2.gen.PrimGenerator;
import edu.project2.maze.Cell;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import edu.project2.solver.BFSSolver;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project2Test {
    Maze maze = new Maze( 4, 4, new Cell[][] {
        new Cell[] {new Cell(new Coordinate(0, 0), Cell.Type.PASSAGE),
            new Cell(new Coordinate(0, 1), Cell.Type.WALL),
            new Cell(new Coordinate(0, 2), Cell.Type.PASSAGE),
            new Cell(new Coordinate(0, 3), Cell.Type.PASSAGE)},
        new Cell[] {new Cell(new Coordinate(1, 0), Cell.Type.PASSAGE),
            new Cell(new Coordinate(1, 1), Cell.Type.WALL),
            new Cell(new Coordinate(1, 2), Cell.Type.PASSAGE),
            new Cell(new Coordinate(1, 3), Cell.Type.WALL)},
        new Cell[] {new Cell(new Coordinate(2, 0), Cell.Type.PASSAGE),
            new Cell(new Coordinate(2, 1), Cell.Type.WALL),
            new Cell(new Coordinate(2, 2), Cell.Type.PASSAGE),
            new Cell(new Coordinate(2, 3), Cell.Type.WALL)},
        new Cell[] {new Cell(new Coordinate(3, 0), Cell.Type.PASSAGE),
            new Cell(new Coordinate(3, 1), Cell.Type.PASSAGE),
            new Cell(new Coordinate(3, 2), Cell.Type.PASSAGE),
            new Cell(new Coordinate(3, 3), Cell.Type.WALL)},
    });
    ConsoleRender consoleRenderer = new ConsoleRender();
    BFSSolver solver = new BFSSolver();
    PrimGenerator generator = new PrimGenerator();

    @Test
    public void project2_consoleRendererWithCorrectValuesTest() {
        // given
        var testCaseOne = maze;
        // when
        var answer = consoleRenderer.render(testCaseOne);

        // then
        var expectedResult = "*|**\n" +
            "*|*|\n" +
            "*|*|\n"+
            "***|\n";
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void project2_consoleRendererWithIncorrectValuesTest() {
        // given
        var testCaseOne = new Maze( 5, 3, new Cell[][] {
            new Cell[] {new Cell(new Coordinate(0, 0), Cell.Type.PASSAGE),
                new Cell(new Coordinate(0, 1), Cell.Type.WALL),
                new Cell(new Coordinate(0, 2), Cell.Type.PASSAGE)},
            new Cell[] {new Cell(new Coordinate(1, 0), Cell.Type.PASSAGE),
                new Cell(new Coordinate(1, 1), Cell.Type.WALL),
                new Cell(new Coordinate(1, 2), Cell.Type.PASSAGE)},
            new Cell[] {new Cell(new Coordinate(2, 0), Cell.Type.PASSAGE),
                new Cell(new Coordinate(2, 1), Cell.Type.PASSAGE),
                new Cell(new Coordinate(2, 2), Cell.Type.PASSAGE)}});
        // when
        var answer = consoleRenderer.render(testCaseOne);

        // then
        Maze expectedResult = null;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void project2_consoleRendererWithPathTest() {
        // given
        var testCaseOne = maze;
        List<Coordinate> path = List.of(new Coordinate(0, 0), new Coordinate(1, 0),
            new Coordinate(2, 0), new Coordinate(3, 0), new Coordinate(3, 1), new Coordinate(3, 2),
            new Coordinate(2, 2), new Coordinate(1, 2), new Coordinate(0, 2), new Coordinate(0, 3));

        // when
        var answer = consoleRenderer.render(testCaseOne,path);

        // then
        var expectedResult = "*|**\n" +
            "*|*|\n" +
            "*|*|\n"+
            "***|\n";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void project2_consoleRendererWithIncorrectPathTest() {
        // given
        var testCaseOne = maze;
        List<Coordinate> path =  List.of(new Coordinate(10, 0));
        // when
        var answer = consoleRenderer.render(testCaseOne,path);

        // then
        Maze expectedResult = null;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void project2_BFSSolverWithCorrectValuesTest() {
        // given
        var testCaseOne = maze;
        // when
        var answer = solver.solve(testCaseOne, new Coordinate(0, 0), new Coordinate(0, 3));

        // then
        var expectedResult = List.of(new Coordinate(0,0), new Coordinate(1,0),
            new Coordinate(2,0), new Coordinate(3,0), new Coordinate(3,1), new Coordinate(3,2),
            new Coordinate(2,2) ,new Coordinate(1,2),new Coordinate(0,2),new Coordinate(0,3));
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
