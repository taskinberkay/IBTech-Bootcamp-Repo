package HW_01_04;

public class Test {
	public static void main(String[] args) {
		
		League myLeague = new League(601, "Superlig");
		
		Team team1 = new Team(801, "Godoro Spor");
		team1.setLeague(myLeague);
		Team team2 = new Team(802, "Fibiler Spor");
		team2.setLeague(myLeague);
		
		Player player1 = new Player(401, "Teaman Alpay", 4.67);
		player1.setTeam(team1);
		Player player2 = new Player(402, "Yusuf Nalkesen", 7.89);
		player2.setTeam(team1);
		Player player3 = new Player(403, "Yıldırım Gürses", 2.93);
		player3.setTeam(team2);
		Player player4 = new Player(405, "Erdoğan Berker", 8.11);
		player4.setTeam(team2);


		team1.addPlayer(player1);
		team1.addPlayer(player2);
		team2.addPlayer(player3);
		team2.addPlayer(player4);
		
		myLeague.addTeam(team1);
		myLeague.addTeam(team2);
		System.out.println(myLeague.getLeagueId() + " " + myLeague.getLeagueName());
		
		for(Team team : myLeague.getTeamList()) {
			System.out.println("\t" + team.getTeamId() + " " + team.getTeamName());
			for(Player player : team.getPlayerList()) {
				System.out.println("\t\t" + player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
			}
		}
		
		System.out.println("\n" + myLeague);

	}

}
