import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testRoundFirstPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 35);
        Player player2 = new Player(2, "Player2", 30);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Player1", "Player2");
        int expected = 1;

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void testRoundSecondPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 30);
        Player player2 = new Player(2, "Player2", 35);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Player1", "Player2");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundEqualStrength() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 30);
        Player player2 = new Player(2, "Player2", 30);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Player1", "Player2");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundexeption1() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 30);
        Player player2 = new Player(2, "Player2", 30);
        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("jack", "Player1")
        );
    }

    @Test
    public void testRoundexeption2() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 30);
        Player player2 = new Player(2, "Player2", 30);
        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Player2", "leader")
        );
    }

    @Test
    public void tesRoundExeptionboth() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 30);
        Player player2 = new Player(2, "Player2", 30);
        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("jack", "leader")
        );
    }
}
