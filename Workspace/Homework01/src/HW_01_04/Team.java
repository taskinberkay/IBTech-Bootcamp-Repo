package HW_01_04;
import java.util.ArrayList;
import java.util.List;

public class Team {
	private long teamId;
	private String teamName;
	private League league;
	private List<Player> playerList = new ArrayList<>();
	
	public Team(long teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public boolean addPlayer(Player player) {
		return playerList.add(player);
	}
	public void removePlayer(Player player) {
		playerList = playerList.stream().filter(p -> p.getPlayerId() != player.getPlayerId()).toList();
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", playerList=" + playerList
				+ "]";
	}
	
	
}
