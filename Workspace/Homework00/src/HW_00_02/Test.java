package HW_00_02;

public class Test {
	public static void main(String[] args) {

		Team team = new Team(801, "Godoro Spor");

		Player player1 = new Player(401, "Teaman Alpay", 4.67);
		player1.setTeam(team);
		Player player2 = new Player(402, "Yusuf Nalkesen", 7.89);
		player2.setTeam(team);
		Player player3 = new Player(403, "Yıldırım Gürses", 2.93);
		player3.setTeam(team);
		Player player4 = new Player(405, "Erdoğan Berker", 8.11);
		player4.setTeam(team);

		team.addPlayer(player1);
		team.addPlayer(player2);

		System.out.println(team.getTeamId() + " " + team.getTeamName());
		
		for (Player player : team.getPlayerList()) {
			System.out.println(
					"\t" + player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
		}
	}
}
