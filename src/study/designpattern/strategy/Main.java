package study.designpattern.strategy;


public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("KIM", new WinningStrategy(seed1));
        Player player2 = new Player("LEE", new ProbStrategy(seed2));

        for(int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if(nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result");
        System.out.println(player1);
        System.out.println(player2);
    }
}

//이 코드는 **전략 패턴(Strategy Pattern)**을 사용하여 가위바위보 게임을 구현한 것입니다. 각 플레이어는 서로 다른 전략(알고리즘)에 따라 손을 결정하고, 그에 따라 승패를 가리는 방식으로 동작합니다. 코드의 주요 구성 요소와 동작을 설명하겠습니다.
//
//        1. Hand 클래스 (Enum)
//
//	•	이 클래스는 가위바위보에서 사용할 손의 종류를 나타냅니다.
//	•	ROCK, SCISSORS, PAPER 세 가지 값을 가지며, 각각 “바위”, “가위”, “보”로 이름이 정해져 있습니다.
//        •	각 손에는 고유한 값(0, 1, 2)이 할당되며, 이 값은 가위바위보에서 비교하는 데 사용됩니다.
//
//주요 메서드:
//
//        •	getHand(int handvalue): 주어진 handvalue에 해당하는 Hand 객체를 반환합니다.
//        •	fight(Hand h): 현재 객체와 h 객체의 승부를 가립니다. 비기면 0, 이기면 1, 지면 -1을 반환합니다.
//        •	isStrongerThan(Hand h), isWeakerThan(Hand h): 각각 현재 손이 상대 손보다 강한지, 약한지를 확인하는 메서드입니다.
//
//        2. Player 클래스
//
//	•	각 플레이어는 이름과 전략(Strategy)을 가지고 있습니다. Player 클래스는 플레이어가 어떤 전략을 사용할지 결정하고, 승패와 관련된 정보를 관리합니다.
//
//주요 메서드:
//
//        •	nextHand(): 플레이어가 설정한 전략에 따라 다음에 낼 손을 반환합니다.
//        •	win(): 플레이어가 이겼을 때 호출됩니다. 이긴 결과를 전략에 반영하고 승리 횟수와 게임 횟수를 업데이트합니다.
//	•	lose(): 플레이어가 졌을 때 호출됩니다.
//        •	even(): 플레이어가 비겼을 때 호출됩니다.
//
//        3. Strategy 인터페이스
//
//	•	전략 패턴의 핵심 인터페이스입니다. 다음 손을 결정하는 nextHand() 메서드와 승패 결과를 학습하는 study() 메서드를 정의합니다.
//
//        4. WinningStrategy 클래스
//
//	•	이 전략은 플레이어가 직전에 이겼다면 그때 낸 손을 계속해서 유지하고, 만약 졌다면 랜덤하게 새로운 손을 고릅니다.
//
//주요 메서드:
//
//        •	nextHand(): 승리했다면 이전 손을 그대로 반환하고, 패배했다면 랜덤하게 새 손을 고릅니다.
//	•	study(boolean win): 승패 여부를 저장하여 다음 번에 어떤 손을 낼지 결정합니다.
//
//5. ProbStrategy 클래스
//
//	•	이 전략은 통계적 확률을 기반으로 다음에 낼 손을 결정합니다. 현재 손이 무엇이었는지에 따라 각 손의 선택 확률이 변화하며, 이긴 경우 확률을 더 높이고 진 경우 다른 손들의 확률을 높입니다.
//
//주요 메서드:
//
//        •	nextHand(): 현재 손에 따라 확률적으로 다음 손을 결정합니다.
//	•	study(boolean win): 이긴 경우 현재 손의 확률을 높이고, 진 경우 다음 손들의 확률을 높입니다.
//
//6. Main 클래스
//
//	•	이 클래스는 프로그램을 실행하는 메인 로직을 가지고 있습니다.
//        •	두 명의 플레이어가 각각 다른 전략(WinningStrategy, ProbStrategy)을 사용해 10,000번의 가위바위보 게임을 수행합니다.
//
//주요 흐름:
//
//        1.	입력: 두 개의 난수 시드를 인자로 받아 두 플레이어의 전략에 사용합니다.
//        2.	게임 루프: 10,000번 동안 두 플레이어가 가위바위보 게임을 하고, 각각의 게임 결과에 따라 승자와 패자를 결정합니다.
//	3.	결과 출력: 최종 결과로 각 플레이어가 몇 번의 승리, 패배, 무승부를 했는지 출력합니다.
//
//전체 흐름 요약:
//
//        1.	Player 객체는 Strategy 객체를 이용해 다음에 낼 손을 결정합니다.
//	2.	Hand 객체는 가위바위보의 손 동작을 정의하고 승패를 결정합니다.
//        3.	각 플레이어는 전략에 따라 손을 결정하고, 게임 결과에 따라 승리 또는 패배 여부를 전략에 학습시킵니다.
//        4.	10,000번의 게임이 끝난 후 각 플레이어의 승/패/무승부 결과를 출력합니다.
//
//전략 패턴의 장점:
//
//        •	각 전략을 클래스로 캡슐화하여 플레이어의 행동을 유연하게 변경할 수 있습니다.
//        •	새 전략을 추가하고 싶다면 기존 코드를 수정할 필요 없이 Strategy 인터페이스를 구현하는 새로운 클래스를 작성하면 됩니다.