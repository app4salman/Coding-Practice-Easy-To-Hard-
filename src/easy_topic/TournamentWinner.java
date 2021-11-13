package easy_topic;
/*

  There's an algorithms tournament taking place in which teams of programmers
  compete against each other to solve algorithmic problems as fast as possible.
  Teams compete in a round robin, where each team faces off against all other
  teams. Only two teams compete against each other at a time, and for each
  competition, one team is designated the home team, while the other team is the
  away team. In each competition there's always one winner and one loser; there
  are no ties. A team receives 3 points if it wins and 0 points if it loses. The
  winner of the tournament is the team that receives the most amount of points.

  Given an array of pairs representing the teams that have competed against each
  other and an array containing the results of each competition, write a
  function that returns the winner of the tournament. The input arrays are named
  competitions and results, respectively. The competitions array has elements in the form of
  [homeTeam, awayTeam], where each team is a string of at most 30
  characters representing the name of the team. The <span>results</span> array
  contains information about the winner of each corresponding competition in the
  competitions</span> array. Specifically, <span>results[i]</span> denotes
  the winner of <span>competitions[i]</span>, where a <span>1</span> in the
  <span>results</span> array means that the home team in the corresponding
  competition won and a <span>0</span> means that the away team won.


  It's guaranteed that exactly one team will win the tournament and that each
  team will compete against all other teams exactly once. It's also guaranteed
  that the tournament will always have at least two teams.

    Sample Input:
    competitions = [
          ["HTML", "C#"],
          ["C#", "Python"],
          ["Python", "HTML"],
    ]
    results = [0, 0, 1]

    Sample Output:
    Python

 */

import java.util.*;

public class TournamentWinner {

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < results.size(); i++) {
            int cnt = 1 - results.get(i);
            String winner = competitions.get(i).get(cnt);
            if (res.containsKey(winner)) {
                int counter = res.get(winner);
                res.put(winner, counter + 1);
            } else {
                res.put(winner, 1);
            }
        }
        String maxName = null;
        int cnt = 0;
        for (Map.Entry<String, Integer> map : res.entrySet()) {
            if (maxName == null) {
                maxName = map.getKey();
                cnt = map.getValue();
                continue;
            } else {
                if (cnt < map.getValue()) {
                    maxName = map.getKey();
                    cnt = map.getValue();
                }
            }
        }
        return maxName;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> dataForCompetitions = new ArrayList<>();
        dataForCompetitions.add("HTML");
        dataForCompetitions.add("C#");
        competitions.add(dataForCompetitions);
        dataForCompetitions = new ArrayList<>();
        dataForCompetitions.add("C#");
        dataForCompetitions.add("Python");
        competitions.add(dataForCompetitions);
        dataForCompetitions = new ArrayList<>();
        dataForCompetitions.add("Python");
        dataForCompetitions.add("HTML");
        competitions.add(dataForCompetitions);

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        System.out.println(tournamentWinner(competitions,results));

    }
}

