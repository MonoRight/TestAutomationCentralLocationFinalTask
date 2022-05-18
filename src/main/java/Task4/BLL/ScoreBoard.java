package Task4.BLL;

import Task4.pages.FootballScoresAndFixturesPage;

public class ScoreBoard {
    public Score GetScore(FootballScoresAndFixturesPage footballScoresAndFixturesPage, String team1, String team2)
    {
        for(int i = 0; i < footballScoresAndFixturesPage.getTeamsList().size() - 1; i++){
            if(footballScoresAndFixturesPage.getTextTeamByIndex(i).equals(team1) && footballScoresAndFixturesPage.getTextTeamByIndex(i + 1).equals(team2)){
                int score1 = footballScoresAndFixturesPage.getIntScoreByIndex(i);
                int score2 = footballScoresAndFixturesPage.getIntScoreByIndex(i + 1);
                return new Score(score1, score2);
            }
        }
        return null;
    }
}
