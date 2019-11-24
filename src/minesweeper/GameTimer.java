package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * Represents a timer that keeps track of the current game duration in seconds.
 * 
 * @author laurencousin
 *
 */
public class GameTimer {
	private String time = "00";
	private Timer timer;
	public JLabel lblTimer;
	
	private long startTime;
	
	/**
	 * Initializes the timer to be refreshed every 1 second.
	 */
	public GameTimer() {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getTime();
			};
		});
	}
	
	/**
	 * Creates the timer label, containing a timer icon and displaying the current game 
	 * duration in seconds.
	 * 
	 * @return the timer label
	 */
	public JLabel createLblTimer() {
		// TODO: Margins, font. Possibly move this to Board
		lblTimer = new JLabel("");
		lblTimer.setOpaque(true);
		lblTimer.setIcon(Board.TIMER_ICON);
		lblTimer.setText(time);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTimer;
	}
	
	/**
	 * Starts the timer after a 1-second delay.
	 */
	public void start() {
		startTime = System.currentTimeMillis();
		timer.setInitialDelay(1000);
		timer.start();
	}
	
	/**
	 * Stops the timer.
	 */
	public void stop() {
		timer.stop();
	}
	
	/**
	 * Gets the elapsed time and updates the timer label with that time in seconds.
	 */
	public void getTime() {
		long currentTime = System.currentTimeMillis();
		long elapsedTime = (currentTime - startTime) / 1000;

		if(elapsedTime < 10) {
			lblTimer.setText("0" + String.valueOf(elapsedTime));
		}
		else {
			lblTimer.setText(String.valueOf(elapsedTime));
		}
	}

}
