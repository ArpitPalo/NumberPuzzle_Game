import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...
	public boolean check(int buttonId, int emptyCellId) {
		int b_row=0,b_col=0,e_row=0,e_col=0;
		b_row = buttonId/4;
		b_col = buttonId%4;
		e_row = emptyCellId/4;
		e_col = emptyCellId%4;
		boolean isValid = false;
		if(b_row == e_row) {
			if(b_col == e_col-1 || b_col == e_col +1) {
				return true;
			}
			return false;
		}
		else if(b_row == e_row + 1) {
			if(b_col == e_col-1 || b_col == e_col +1 || b_col == e_col) {
				return true;
			}
			return false;
		}
		else if(b_row == e_row - 1) {
			if(b_col == e_col-1 || b_col == e_col +1 || b_col == e_col) {
				return true;
			}
			return false;
		}
		return false;
	}
	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		//Your logic here
		int buttonId = 0;
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i] == buttonClicked) {
				buttonId = i;
				break;
			}
		}
		boolean isValid = check(buttonId,emptyCellId);
		if(isValid) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = buttonId;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int a = getRandomNumber();
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<=15; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<15; i++) {
            arr[i] = list.get(i);
        }
			
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				winner = false;
				break;
			}
		}
		return winner;
	}
}