package study.designpattern.strategy;


public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    // 전략에 따라 다음 손을 결정한다.
    public Hand nextHand() {
        return strategy.nextHand();
    }
    // 승리
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    // 무승부
    public void even() {
        gamecount++;
    }
    @Override
    public String toString() {
        return "[" +
                name + ":" +
                gamecount + " games, " +
                wincount + " win, " +
                losecount + " lose" +
                "]";
    }
}