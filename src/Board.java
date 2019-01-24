public class Board {
    public int getNumberOfPiles() {
        return numberOfPiles;
    }

    private int numberOfPiles, totalXor, totalStones;
    private int[] stones;

    private void updateTotalValues() {
        this.totalXor = 0;
        this.totalStones = 0;
        for(int i = 0; i < numberOfPiles; i++) {
            this.totalXor ^= stones[i];
            this.totalStones += stones[i];
        }
    }

    public Board(int numberOfPiles, int[] stones) {
        this.numberOfPiles = numberOfPiles;
        this.stones = stones;
        updateTotalValues();
    }

    public Board(int numberOfPiles) {
        this.numberOfPiles = numberOfPiles;
        this.stones = new int[numberOfPiles];
        updateTotalValues();
    }

    public int getStones(int i) throws  IndexOutOfBoundsException {
        if(i >= this.numberOfPiles) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.stones[i];
    }

    public int getTotalXor() {
        return this.totalXor;
    }

    public int getTotalStones() {
        return this.totalStones;
    }

    public void getStonesFromPile(int i, int stonesToGet)
            throws  IndexOutOfBoundsException, NumberOfStonesException{
        if(i >= this.numberOfPiles) {
            throw new ArrayIndexOutOfBoundsException("There is no pile with the index " + i);
        }
        if(this.stones[i] < stonesToGet) {
            throw new NumberOfStonesException(
                    "There is no enough stones in the pile to get it.");
        }
        if(stonesToGet == 0) {
            throw new NumberOfStonesException(
                    "You should take a non-zero number of stones from the pile.");
        }

        int newStonesI = this.stones[i] - stonesToGet;

        this.totalXor ^= this.stones[i];
        this.totalXor ^= newStonesI;

        this.totalStones -= stonesToGet;

        stones[i] = newStonesI;
    }

}
