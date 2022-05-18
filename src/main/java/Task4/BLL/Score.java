package Task4.BLL;

public class Score {
    private final int scoreTeam1;
    private final int scoreTeam2;

    public Score(int scoreTeam1, int scoreTeam2){
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    public int getScoreTeam1(){
        return scoreTeam1;
    }
    public int getScoreTeam2(){
        return scoreTeam2;
    }
}
