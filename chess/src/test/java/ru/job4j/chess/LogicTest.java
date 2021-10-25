package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

public class LogicTest {

    @Test
    public void whenC1ToH6ThenOk()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenWayBusyThenException()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E2));
        logic.add(new PawnWhite(Cell.D3));
        logic.move(Cell.E2, Cell.C4);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenNoFigureThenException()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.E2, Cell.C4);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNoDiagonalThenException()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E2));
        logic.move(Cell.E2, Cell.C3);
    }
}