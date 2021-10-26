package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenBishopC1ThenPositionC1() {
        Figure bishop = new BishopBlack(Cell.C1);
        assertEquals(bishop.position(), Cell.C1);
    }

    @Test
    public void whenBishopC1ToF4ThenPositionF4() {
        Figure bishop = new BishopBlack(Cell.C1);
        bishop = bishop.copy(Cell.F4);
        assertEquals(bishop.position(), Cell.F4);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayNotDiagonalThenException() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell dest = Cell.D3;
        bishop.way(dest);
    }

    @Test
    public void whenWayE2ToB5ThenD3C4B5() {
       Figure bishop = new BishopBlack(Cell.E2);
       Cell dest = Cell.B5;
       Cell[] expected = {Cell.D3, Cell.C4, Cell.B5};
       assertThat(bishop.way(dest), is(expected));
    }
}