public class TennisGame2 implements TennisGame
{
    private static final String CONST1 = "Fifteen";
    private static final String CONST2 = "Thirty";
    private static final String CONST3 = "Forty";
    private int p1point = 0;
    private int p2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (p1point >= 4 && p1point - p2point >= 2) {
            return "Win for player1";
        }
        if (p2point >= 4 && p2point - p1point >= 2) {
            return "Win for player2";
        }

        if (p1point == p2point) {
            if (p1point < 3) {
                return getScoreString(p1point) + "-All";
            }
            return "Deuce";
        }

        String p1Res = getScoreString(p1point);
        String p2Res = getScoreString(p2point);

        if (p1point > p2point) {
            return (p2point >= 3) ? "Advantage player1" : p1Res + "-" + p2Res;
        } else {
            return (p1point >= 3) ? "Advantage player2" : p1Res + "-" + p2Res;
        }
    }

    private String getScoreString(int points) {
        switch (points) {
            case 0: return "Love";
            case 1: return CONST1;
            case 2: return CONST2;
            case 3: return CONST3;
            default: return String.valueOf(points); // Pour gérer les points >= 4 si nécessaire
        }
    }


    public void setP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            p1Score();
        }

    }

    public void setP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            p2Score();
        }

    }

    public void p1Score(){
        p1point++;
    }

    public void p2Score(){
        p2point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            p1Score();
        else
            p2Score();
    }
}