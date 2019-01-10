package Setup;
import java.util.List;
import Setup.Card;
import Setup.Deck;
import Setup.Board;
import Setup.CardGameGUI;
import java.util.ArrayList;


/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of Setup.cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the Setup.cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the Setup.cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the Setup.cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected Setup.cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face Setup.cards
     * whose values add to 11, and (2) a group of three Setup.cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected Setup.cards.
     * @return true if the selected Setup.cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2) {
            if (containsPairSum11(selectedCards)) {
                return true;
            }
        }
        if (selectedCards.size() == 3) {
            if (containsJQK(selectedCards)) {
                return true;
            }
        }

        return false;

    }


    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face Setup.cards whose values add to 11, or (2) a group
     * of three Setup.cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        List selectedCards = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            for(int j = i; j < cards.length; j++) {
                for (int k = j; k < cards.length; k++) {
                    selectedCards.add(cards[i]);
                    selectedCards.add(cards[j]);
                    selectedCards.add(cards[k]);
                    if (isLegal(selectedCards)) {
                        return true;
                    }

                }
            }
        }
        selectedCards.remove(0);
        selectedCards.remove(1);
        selectedCards.remove(2);
        for(int j = 0; j < cards.length; j++) {
            for (int k = j; k < cards.length; k++) {
                selectedCards.add(cards[j]);
                selectedCards.add(cards[k]);
                if (isLegal(selectedCards)) {
                    return true;
                }

            }
        }
        selectedCards.remove(0);
        selectedCards.remove(1);
        return false;

    }

    /**
     * Check for an 11-pair in the selected Setup.cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
      boolean n = false;
      if (cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(0)).pointValue() == 11) {
          n = true;
      }


        if (n) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Check for a JQK in the selected Setup.cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        boolean n = false;

        if (((cardAt(selectedCards.get(0)).rank()) == "king") && ((cardAt(selectedCards.get(1)).rank()) == "queen")&& ((cardAt(selectedCards.get(2)).rank()) == "jack")) {
            n = true;
        }
        else if (((cardAt(selectedCards.get(0)).rank()) == "queen") && ((cardAt(selectedCards.get(1)).rank()) == "king")&& ((cardAt(selectedCards.get(2)).rank()) == "jack")) {
            n = true;
        }
        else if (((cardAt(selectedCards.get(0)).rank()) == "queen") && ((cardAt(selectedCards.get(1)).rank()) == "jack")&& ((cardAt(selectedCards.get(2)).rank()) == "king")) {
            n = true;
        }
        else if (((cardAt(selectedCards.get(0)).rank()) == "king") && ((cardAt(selectedCards.get(1)).rank()) == "jack")&& ((cardAt(selectedCards.get(2)).rank()) == "queen")) {
            n = true;
        }
        else if (((cardAt(selectedCards.get(0)).rank()) == "jack") && ((cardAt(selectedCards.get(1)).rank()) == "king")&& ((cardAt(selectedCards.get(2)).rank()) == "queen")) {
            n = true;
        }
        else if (((cardAt(selectedCards.get(0)).rank()) == "queen") && ((cardAt(selectedCards.get(1)).rank()) == "queen")&& ((cardAt(selectedCards.get(2)).rank()) == "king")) {
            n = true;
        }



        if (n) {
            return true;
        }
        else {
            return false;
        }
    }
}