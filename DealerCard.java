public class DealerCard {       // same as UserCard class but DealerCard difference helps me
    String [] deck = {"2C", "2S", "2H", "2D", "3C", "3S", "3H", "3D", "4C", "4S", "4H", "4D", "5C", "5S", "5H", "5D", "6C", "6S", "6H", "6D", "7C", "7S", "7H", "7D", "8C", "8S", "8H", "8D", "9C", "9S", "9H", "9D", "TC", "TS", "TH", "TD", "JC", "JD", "JH", "JD", "QC", "QS", "QH", "QD", "KC", "KS", "KH", "KD", "AC", "AS", "AH", "AD"};
    String cardNumber;
    String cardType;
    int [] cardValue = new int[2];
    public void setNumber(char c) {
        if (c == '2') {
            cardNumber = "2";
        }
        if (c == '3') {
            cardNumber = "3";
        }
        if (c == '4') {
            cardNumber = "4";
        }
        if (c == '5') {
            cardNumber = "5";
        }
        if (c == '6') {
            cardNumber = "6";
        }
        if (c == '7') {
            cardNumber = "7";
        }
        if (c == '8') {
            cardNumber = "8";
        }
        if (c == '9') {
            cardNumber = "9";
        }
        if (c == 'T') {
            cardNumber = "10";
        }
        if (c == 'J') {
            cardNumber = "Jack";
        }
        if (c == 'Q') {
            cardNumber = "Queen";
        }
        if (c == 'K') {
            cardNumber = "King";
        }
        if (c == 'A') {
            cardNumber = "Ace";
        }
    }
    public void setType(char c) {
        if (c == 'C') {
            cardType = "clubs";
        }
        if (c == 'S') {
            cardType = "spades";
        }
        if (c == 'H') {
            cardType = "hearts";
        }
        if (c == 'D') {
            cardType = "diamonds";
        }
    }
    public void setValue(char c) {
        if (c == '2') {
            cardValue[0] = cardValue[1] = 2;
        }
        if (c == '3') {
            cardValue[0] = cardValue[1] = 3;
        }
        if (c == '4') {
            cardValue[0] = cardValue[1] = 4;
        }
        if (c == '5') {
            cardValue[0] = cardValue[1] = 5;
        }
        if (c == '6') {
            cardValue[0] = cardValue[1] = 6;
        }
        if (c == '7') {
            cardValue[0] = cardValue[1] = 7;
        }
        if (c == '8') {
            cardValue[0] = cardValue[1] = 8;
        }
        if (c == '9') {
            cardValue[0] = cardValue[1] = 9;
        }
        if (c == 'T') {
            cardValue[0] = cardValue[1] = 10;
        }
        if (c == 'J') {
            cardValue[0] = cardValue[1] = 10;
        }
        if (c == 'Q') {
            cardValue[0] = cardValue[1] = 10;
        }
        if (c == 'K') {
            cardValue[0] = cardValue[1] = 10;
        }
        if (c == 'A') {
            cardValue[0] = 1;
            cardValue[1] = 11;
        }
    }
    public String getNumber() {
        return cardNumber;
    }
    public String getType() {
        return cardType;
    }
    public int[] getValue() {
        return cardValue;
    }
    public String getDeck(int a) {
        return deck[a];
    }
}