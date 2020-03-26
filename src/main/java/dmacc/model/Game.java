package dmacc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	private final List<String> OPTIONS = Arrays.asList("rock", "paper", "scissors", "lizard", "spock");
	private String player1;
	private String computerPlayer;
	private String winner;
	
	public Game(String player1) {
		super();
		this.player1 = player1;
		this.setComputerPlayerToRandom();
		this.determineWinner();
	}
	
	public String getPlayer1() {
		return player1;
	}

	public String getComputerPlayer() {
		return computerPlayer;
	}

	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String w) {
		this.winner = w;
	}
	
	private void setComputerPlayerToRandom() {
		Random r = new Random();
		computerPlayer = OPTIONS.get(r.nextInt(OPTIONS.size()));
	}
	private void determineWinner() {
		
		winner = "Player";
		
		if (player1.contentEquals(computerPlayer))
			winner = "TIE";
		else if (player1.equals("rock"))
			winner = computerPlayer == "scissors" || computerPlayer == "lizard" ? "Player" : "Computer";
		else if (player1.equals("paper"))
			winner = computerPlayer == "rock" || computerPlayer == "spock" ? "Player" : "Computer";
		else if (player1.equals("scissors"))
			winner = computerPlayer == "paper" || computerPlayer == "lizard" ? "Player" : "Computer";
		else if (player1.equals("lizard"))
			winner = computerPlayer == "spock" || computerPlayer == "paper" ? "Player" : "Computer";
		else if (player1.equals("spock"))
			winner = computerPlayer == "rock" || computerPlayer == "scissors" ? "Player" : "Computer";
	}
}
