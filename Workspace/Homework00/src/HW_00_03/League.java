package HW_00_03;
import java.util.ArrayList;
import java.util.List;

public class League {
	private long leagueId;
	private String leagueName;
	private List<Team> teamList = new ArrayList<>();
	
	public League(long leagueId, String leagueName) {
		this.leagueId = leagueId;
		this.leagueName = leagueName;
	}
	public long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public List<Team> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
	public boolean addTeam(Team team) {
		return teamList.add(team);
	}
	public void removeTeam(Team team) {
		teamList = teamList.stream().filter(t -> t.getTeamId() != team.getTeamId()).toList();
	}
	@Override
	public String toString() {
		return "League [leagueId=" + leagueId + ", leagueName=" + leagueName + ", teamList=" + teamList + "]";
	}
	

}
