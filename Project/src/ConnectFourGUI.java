import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton; 

import javax.swing.JFrame; 

import javax.swing.JLabel;
import javax.swing.JPanel; 

  
/* 
 * Class Name: ConnectFourGUI 
 * Author: Lindsey Arndt, Kailee Brower, and Isabelle Gile 
 * Date: 10/ 20/ 2020 
 * Role: To display a GUI for 2 players to play Connect Four 
 * Problem Description: For our final project, we decided to code the Connect Four Game. We designed the game for two players using a GUI. The program allows each player to place a chip in a column and the first player to get 4 of their colored chips in a row, wins! We always loved this game as kids and thought it would be fun and interesting to code it in Eclipse. 
 * Goals: To display GUI of Connect Four game.  
 * Inputs: private JButton [] btn = new JButton[8 
 * private JLabel turn = new JLabel("Player 1"); //tells the player who's turn it is 
 * private JButton newGame = new JButton("New Game") 
 * private JLabel[][] gameBoard = new JLabel[6][8];; //game board 
 * private ImageIcon redChip, whiteChip, yellowChip = new ImageIcon(); 
 * private JPanel panel = new JPanel() 
 * private JPanel panel2 = new JPanel() 
 * private JPanel panel3 = new JPanel() 
 * private JPanel panel4 = new JPanel() 
 * private int player = 1 
 * Outputs: GUI Program    
 * java packages: 
 *    import java.awt.BorderLayout;  
 *    import java.awt.ComponentOrientation; 
 *    import java.awt.Dimension; 
 *    import java.awt.FlowLayout; 
 *    import java.awt.GridLayout; 
 *    import java.awt.Image; 
 *           import java.awt.event.ActionEvent;  
 *    import java.awt.event.ActionListener; 
 *    import javax.swing.AbstractButton; 
 *    import javax.swing.Icon; 
 *    import javax.swing.ImageIcon; 
 *    import javax.swing.JButton;  
 *    import javax.swing.JFrame;  
 *    import javax.swing.JLabel; 
 *    import javax.swing.JPanel;  
 * output screen formats – 

*/ 
public class ConnectFourGUI extends JFrame implements ActionListener { 

	//instance variables 
	//variables to set up the GUI
	private JButton [] btn = new JButton[8];//buttons for dropping chips
    private JLabel turn = new JLabel("Player 1"); //tells the player who's turn it is
    private JButton newGame = new JButton("New Game");
    private JLabel[][] gameBoard = new JLabel[6][8];; //game board 
    private ImageIcon redChip, whiteChip, yellowChip = new ImageIcon();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    
    //keep track of the turn it is
    private int player = 1; 

    /* 
     * Method Name: ConnectFourGUI() 
     * Role: The constructor method to set up the GUI 
     * Input: none - has access to instance variables
     * Output: GUI 
     * Pseudocode:  
     * 1. set title of GUI using setTitle() 
     * 2. set size of the form 
     * 3. set layout 
     * 4. set default close operation 
     * 5. add components 
     * 6. add buttons and chip images 
     * 7. fill gameboard 
     * 8. use action listener and set visible 
     */  
    public ConnectFourGUI() { 
        //set the title of the GUI using the setTitle() method  
        setTitle("Connect Four"); 

        //set the size of the form 
        setSize(1000, 1000); 

        //set layout 
        panel.setLayout(new GridLayout(7, 8, 3, 7)); //panel that holds the buttons 
        panel2.setLayout(new BorderLayout()); //panel that holds the persons turn
        panel2.setSize(1000, 100);
        panel3.setLayout(new BorderLayout());
        panel4.setLayout(new BorderLayout());
        
        //set panel 1 to go left to right
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        //set the default close operation 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        //adding panel components to GUI panels
        panel2.add(turn);
        panel3.add(panel2);
        panel3.add(panel); // holding the buttons 
        panel4.add(newGame); //holding the new game button 
        
        //adding the panels with sizes in the GUI
        this.add(panel3, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel4, BorderLayout.SOUTH);
        
        //Set the font bigger to fill the turn label and the newGame button 
        Font f1 = new Font("Diag", Font.BOLD, 30); 
        turn.setFont(f1); 
        newGame.setFont(f1); 
        
        //create column buttons to add to the panel 
        for (int x = 0; x < btn.length; x++)
        {
        	btn[x] = new JButton("" + x); 
        	btn[x].setPreferredSize(new Dimension(120, 120));
        	//add the buttons to the panel 
        	panel.add(btn[x]);
        	//Make the font bigger to fill the buttons properly
            btn[x].setFont(f1); 
        }  
        
        //ImageIcon transformations
        redChip = new ImageIcon(getClass().getResource("red.png"));
        Image imager = redChip.getImage(); // transform it into an image
        Image newimgr = imager.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale the item to fit by using scale smooth
        //transform the image back into an imageIcon
        redChip = new ImageIcon(newimgr); 
        
        
        whiteChip = new ImageIcon(getClass().getResource("white.png"));
        Image imagew = whiteChip.getImage(); // transform it 
        Image newimgw = imagew.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
        //transform the image back into an imageIcon
        whiteChip = new ImageIcon(newimgw);
        
        yellowChip = new ImageIcon(getClass().getResource("yellow.png"));
        Image imagey = yellowChip.getImage(); // transform it  
        Image newimgy = imagey.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
        //transform the image back into an imageIcon 
        yellowChip = new ImageIcon(newimgy);
        
        //filling the game board each with white chips 
        for (int cur = 0; cur < 48; cur++) 
        { 
            int row = cur / 8; 
            int col = cur % 8; 
            
            gameBoard[row][col]= new JLabel(); 
            gameBoard[row][col].setIcon(whiteChip);          
            panel.add(gameBoard[row][col]);

        }

        //use ActionListener to listen for each button being pressed 
        for (int x = 0; x < btn.length; x++) 
        {
        	btn[x].addActionListener(this);
        }
        
        //add ActionListener to the JButton newGame 
        newGame.addActionListener(this);
        
        //set visible and set the size of the GUI to hold all of the panels
        setVisible(true);
        pack();
    } 

  
    /* 
     * Method Name: actionPerformed(ActionEvent e)  
     * Role: To check where the user clicked on a button and to perform that button’s action.   
     * Input: ActionEvent e  
     * Output: none 
     * Pseudo code:   
     * 1. call new game() method when new game button is clicked       
     * 2. use for and if else statement to write who’s turn it is and if that player wins, by calling the methods checkHoriz(row, col), checkDown(row col), and checkdiag(row, col)  
     */   
    @Override 

    public void actionPerformed(ActionEvent e) { 
    	
    	//call the newGame method to clear the board and set all spots to white when the JButton newGame is pressed
		if(e.getSource() == newGame) 
		{	
			newGame();
		}
		
		//Check each button and determine which button was pressed by the index of the column  
    	for (int col = 0; col < btn.length; col++) 
    	{
    		if(e.getSource() == btn[col] && (player == 1 || player == 2))
    		{
    			//When Player 1 presses a button, find the last row in the column to fill it with the correct chip
    			int row = lastRow(col); 
    			
    			if(gameBoard[row][col].getIcon().equals(whiteChip))
    			{
    				if(e.getSource() == btn[col] && player == 1)
    				{
    					gameBoard[row][col].setIcon(redChip); 
    				}
    				if(e.getSource() == btn[col] && player == 2)
    				{
    					gameBoard[row][col].setIcon(yellowChip); 
    				}
    				//call methods to check if the player wins in any direction
    				boolean winsH1 = checkHoriz(row, col);
    				boolean winsD1 = checkDown(row, col);
    				boolean winsDiag = checkDiag(row, col);
    				if(winsH1 || winsD1 || winsDiag) 
    				{
    					//Print Player WINNER 
    					turn.setText("Player "+player+" WINNER");
    					//stop the game by setting player to 0 so actionListener will not run 
    					player = 0;
    				}
    				else
    				{
    					player = 3 - player;
    					turn.setText("Player "+player);		
    				}
    			}
    		}
    	}
    }
    			
    
    
    /*  

     * Method Name: checkHoriz()   
     * Role: Checks 3 chips to the right and 3 chips to the left of the last chip played to check if there are 4 of the same-colored chips in a row.  
     * Input: int r (row), int c (column)  
     * Output: True – if there are four in a row horizontally, false – if there are not four in a row horizontally   
     * Pseudocode:   
     * 1. int rowTotal = 0;  
     * 2. int rightCount = -3;  
     * 3. int leftCount = c;  
     * 4. if player 1 or player 2   
     * 5. if c is greater than 4 , change the rightCount to be c – 7  
     * 6. for each column in the row   
     * 7. if the column in the row is a red chip and its player 1 or the column in the row is a yellow chip and its player 2,  rowTotal + 1  
     * 8. If the chip in the column does not correspond with the player, rowTotal = 0  
     * 9. if rowTotal = 4, return true   
     * 10.After the for loop goes through each column without the rowTotal being true, return false  
     */ 
    public boolean checkHoriz(int r, int c) {
    	
    	int rowTotal = 0;
    	int rightCount = -3;
    	int leftCount = c;
    	
    	//Check the row for player 1
    	
    	if(player == 1 || player == 2) 
    	{
    		if(c > 4) 
    		{
    			rightCount = c-7;
    		}
    			for (int col = rightCount; col <= leftCount; col++)
    			{
    				if((gameBoard[r][c - col].getIcon().equals(redChip) && player == 1) || gameBoard[r][c - col].getIcon().equals(yellowChip) && player == 2 ) 
    				{
    					rowTotal ++;
    				}
    				if(((gameBoard[r][c - col].getIcon().equals(yellowChip) && (player == 1 )) || gameBoard[r][c - col].getIcon().equals(redChip) && player == 2) || gameBoard[r][c - col].getIcon().equals(whiteChip)) 
    				{
    					rowTotal = 0;
    				}	
    				if (rowTotal == 4)
    				{
    					return true;
    				}
    			}
    	}
    	
    	

    	// return false when there are no four in a row 
    	return false;
    }
    
    
    
    	
    /* 
     * Method Name: CheckDown (int r, int c)  
     * Role: To check four in a row below the chip entered  
     * Input: int r – the row the last chip was entered, int c – the column the last chip was entered  
     * Output: true – if there are four in a kind below the chip entered, false – if there are not four in a kind below the chip entered  
     * Pseudo code:  
     * 1. int downCount = 0;  
     * 2. if the player is either player 1 or player 2 for each row in the column  
     * 3. if the chip is red and the player is 1 or the chip is yellow and the player is 2, downCount + 1  
     * 4. if the chip does not match with the corresponding player, downCount = 0  
     * 5. if downCount = 4, return true after iterating through each of the rows in the column below the chip placed, return false  
     */ 
    public boolean checkDown(int r, int c) {
    	int downCount = 0; //Counter to check how many times a chip is places in the col
	
    	if(player == 1 || player == 2) {
    		for (int row = r; row <= 5; row++) 
    		{
 				if((gameBoard[row][c].getIcon().equals(redChip) && player == 1) || gameBoard[row][c].getIcon().equals(yellowChip) && player == 2) 
 				{
 					downCount ++;
 				}
 				if((!gameBoard[row][c].getIcon().equals(redChip) && player == 1) || !gameBoard[row][c].getIcon().equals(yellowChip) && player == 2)
 				{
 					downCount = 0;
 				}
 				if (downCount == 4)
 				{
 					return true;
 				}
 				
 			}
 	}

 	//return false if there are not four in a row 
 	return false;
 }
 
    /* 
     * Method Name: checkDiag()  
     * Role: Check the back slash and forward slash diagonals from the last placed chip to search for a win.  
     * Input: int r (row), int c (column)  
     * Output: true- if there is four in a row in a diagonal, false- if there is not four of the same color in a diagonal.  
     * Pseudo code:  
     * 1. int diagD = 0;  
     * 2. int diagU = 0;  
     * 3. if the player is 1, for each diagonal, if the chip is red add one to diagD and diagU.  
     * 4. if the chip is yellow or white set diagD or diagU back to 0.  
     * 5. if either diagD or diagU is greater than f repeat true else report false.  
     * 6. repeat for player two.  
     */ 
    public boolean checkDiag(int r, int c)
    {
    	int diagD = 0;
    	int diagU = 0;
    	
    	if(player == 1 || player == 2)
    	{
    		for(int rO = 3; rO >= -3; rO--)
    		{
    			for(int cO = 3; cO >= -3; cO--)
    			{
    				if(diagD == 4 || diagU == 4) 
    				{
    					return true;
    				}
    				
    				if(r + rO < 0 || c + cO < 0 || r + rO >= gameBoard.length || c + cO >= gameBoard[r + rO].length)
    				{
    					continue;
    				}
    				
    				JLabel tile = gameBoard[r + rO][c + cO];
    				
    				if(tile.getIcon().equals(whiteChip))
    				{
    					continue;
    				}
    				
					if(Math.abs(rO) == Math.abs(cO))
					{
						if(rO == cO && cO == 0)
						{
							diagD++;
							diagU++;
						}
						else
						{
							 
							if(rO > 0 && cO > 0 || rO < 0 && cO < 0)
							{
								if((!tile.getIcon().equals(redChip) && player == 1) || !tile.getIcon().equals(yellowChip) && player == 2)
								{
									diagD = 0;
    		    					continue;
								}
								else
								{
									diagD++;    		    					
								}
							}
							else
							{
								if((!tile.getIcon().equals(redChip) && player == 1) || !tile.getIcon().equals(yellowChip) && player == 2)
								{
									diagU = 0;
									continue;
								}
								else
								{
									diagU++;   		    					
								}
    						}
							
						}
					}
					else
					{
						continue;
					}
    				
    			}
    		}
    	}
    	
    	return false;
    }
    
 
 
 
 
    
    
    
    /* 
     * Method Name: lastRow(int col) 
     * Role: to find the last row in the grid 
     * Input: int col - representing the column the last chip was placed in 
     * Output: 
     * 		row - representing the last row in the column that has a white chip
     * 		0 - when there is not a chip  
     * Pseudo code:  
     * 1. use for and if statement to find the last row in the grid 
     * 2. Return row if the last row is open 
     * 3. return 0 if the last row is not open 
     */ 
    public int lastRow (int col) 
    {
        for (int row = 5; row >= 0; row--) //iterate through the row in the column 
        { 
        	if(gameBoard[row][col].getIcon().equals(whiteChip)) 
        	{
        		return row; 
        	}
        }
        return 0;
    }
    
    
   
    
    /* 
     * Method name: newGame() 
     * Role: restarts the game by filling each spot with white chips and reverts back to player 1 
     * Input: none 
     * Output: none
     * Pseudo code:  
     * 1. set player = 1 
     * 2. use for to clear the game board with white chips when the new game button is clicked 
     * 3. setText back to Player 1 
     */ 
    public void newGame () {
    	player = 1; 
        for (int cur = 0; cur < 48; cur++) 
        { 
            int row = cur / 8; 
            int col = cur % 8;  
           //set the gameBoard to white chips 
            gameBoard[row][col].setIcon(whiteChip);
        }
        turn.setText("Player "+player);
    }
    
    
    
    
    /* 
     * Method name: main(String[] args) 
     * Role: To implement the ConnectFourGUI() 
     * Input: none 
     * Output: none
     * Pseudo code:  
     * 1. create a new connectFourGUI object by calling ConnectFourGUI() 
     */  
    public static void main(String[] args) { 

        new ConnectFourGUI(); 
    } 

} 

 
 