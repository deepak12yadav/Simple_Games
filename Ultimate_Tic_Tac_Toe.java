import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Ultimate_Tic_Tac_Toe{
	private GridLayout grid[][]=new GridLayout[3][3];
	private JPanel panel[][]=new JPanel[3][3];
	private JButton button[][][][]=new JButton[3][3][3][3];
	private JPanel pout=new JPanel();
	public static String s="X";
	Ultimate_Tic_Tac_Toe(){
		// structure is as follows JFrame->Jpanel(GridLayout(3*3))->9*JPanels(GridLayout(3*3))
		JFrame jfr = new JFrame("Ultimate Tic Tac Toe");
		//JLabel label = new JLabel("Ultimate Tic Tac Toe");
		//jfr.setLocationRelativeTo(null);
		//jfr.add(label);
		jfr.add(pout);
		pout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pout.setLayout(new GridLayout(3,3,10,10));
		jfr.setSize(720,720);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pout.setFocusable(true);
		
		//adding 3*3 panels to the panel of iframe and addng grid layout to them
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				panel[i][j]=new JPanel();
				grid[i][j]=new GridLayout(3,3);
				panel[i][j].setLayout(grid[i][j]);
				panel[i][j].putClientProperty("isWin",0);
				pout.add(panel[i][j]);
			}
		}
		
		//adding buttons to the individual panels 
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					for(int l=0;l<3;l++){
						button[i][j][k][l]=new JButton("");
						panel[i][j].add(button[i][j][k][l]);
						button[i][j][k][l].putClientProperty("i", i);
						button[i][j][k][l].putClientProperty("j", j);
						button[i][j][k][l].putClientProperty("k", k);
						button[i][j][k][l].putClientProperty("l", l);
						button[i][j][k][l].putClientProperty("enable", true);
						button[i][j][k][l].addMouseListener(new focus(this));
					}
				}
			}
		}

		jfr.setVisible(true);
	}
	
	//mere helper function for implementation
	private int helper(String str){
		if(str=="X")
			return 0;
		if(str=="O")
			return 1;
		return 2;
	}

	private int helper1(int a){
		if(a==1)
			return 0;
		if(a==2)
			return 1;
		if(a==-1)
			return 2;
		return 3;
	}


	//just a helper function
	private  int win(String str1,String str2,String str3){
		int c[]=new int[3];
		c[0]=0;
		c[1]=0;
		c[2]=0;
		c[helper(str1)]=1;
		c[helper(str2)]=1;
		c[helper(str3)]=1;
		if(c[0]==c[1]&&c[0]!=0){
			return -1;
		}
		if((c[0]+c[1]+c[2])==1){
			if(c[0]==1)
				return 1;
			if(c[1]==1){
				return 2;
			}
		}
		return 0;
	}

	private int check(int a,int b,int g){
		int c[]=new int[4];
		c[0]=0;
		c[1]=0;
		c[2]=0;
		c[3]=0;
		c[helper1(a)]=1;
		c[helper1(b)]=1;
		c[helper1(g)]=1;
		if(c[0]==c[1]&&c[0]!=0){
			return -1;
		}
		if(c[2]==1)
			return -1;
		if((c[0]+c[1]+c[3])==1){
			if(c[0]==1)
				return 1;

			if(c[1]==1)
				return 2;
		}
		return 0;
	}
	
	//To check if the whole game should be over 
	private  int check_advance(){
			
			int flag=0;
			if(check((int)panel[0][1].getClientProperty("isWin"),(int)panel[2][1].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"))!=-1){
				if(check((int)panel[0][1].getClientProperty("isWin"),(int)panel[2][1].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"))!=0)
					return check((int)panel[0][1].getClientProperty("isWin"),(int)panel[2][1].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"));
				flag=1;
			}
			if(check((int)panel[1][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"))!=-1){
				if(check((int)panel[1][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"))!=0)
					return check((int)panel[1][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"));
				flag=1;
			}
			if(check((int)panel[0][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"))!=-1){
				if(check((int)panel[0][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"))!=0)
					return check((int)panel[0][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"));
				flag=1;
			}
			if(check((int)panel[2][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"))!=-1){
				if(check((int)panel[2][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"))!=0)
					return check((int)panel[2][0].getClientProperty("isWin"),(int)panel[1][1].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"));
				flag=1;
			}
		
		
			if(check((int)panel[2][0].getClientProperty("isWin"),(int)panel[2][1].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"))!=-1){
				if(check((int)panel[2][0].getClientProperty("isWin"),(int)panel[2][1].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"))!=0)
					return check((int)panel[2][0].getClientProperty("isWin"),(int)panel[2][1].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"));
				flag=1;
			}
			if(check((int)panel[0][2].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"))!=-1){
				if(check((int)panel[0][2].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"))!=0)
					return check((int)panel[0][2].getClientProperty("isWin"),(int)panel[1][2].getClientProperty("isWin"),(int)panel[2][2].getClientProperty("isWin"));
				flag=1;
			}
			
			if(check((int)panel[0][0].getClientProperty("isWin"),(int)panel[0][1].getClientProperty("isWin"),(int)panel[0][2].getClientProperty("isWin"))!=-1){
				if(check((int)panel[0][0].getClientProperty("isWin"),(int)panel[0][1].getClientProperty("isWin"),(int)panel[0][2].getClientProperty("isWin"))!=0)
					return check((int)panel[0][0].getClientProperty("isWin"),(int)panel[0][1].getClientProperty("isWin"),(int)panel[0][2].getClientProperty("isWin"));
				flag=1;
			}
			if(check((int)panel[0][0].getClientProperty("isWin"),(int)panel[1][0].getClientProperty("isWin"),(int)panel[2][0].getClientProperty("isWin"))!=-1){
				if(check((int)panel[0][0].getClientProperty("isWin"),(int)panel[1][0].getClientProperty("isWin"),(int)panel[2][0].getClientProperty("isWin"))!=0)
					return check((int)panel[0][0].getClientProperty("isWin"),(int)panel[1][0].getClientProperty("isWin"),(int)panel[2][0].getClientProperty("isWin"));
				flag=1;
			}
		
		if(flag!=1)
			return -1;
		return 0;
	}
	
	//To check if the panel is won by someone
	private  int check(int pi,int pj,int i,int j){
		
			int flag=0;
			if(win((String)button[pi][pj][0][1].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][2][1].getLabel())!=-1){
				if(win((String)button[pi][pj][0][1].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][2][1].getLabel())!=0)
					return win((String)button[pi][pj][0][1].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][2][1].getLabel());
				flag=1;
			}
			if(win((String)button[pi][pj][1][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][1][2].getLabel())!=-1){
				if(win((String)button[pi][pj][1][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][1][2].getLabel())!=0)
					return win((String)button[pi][pj][1][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][1][2].getLabel());
				flag=1;
			}
			if(win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][2][2].getLabel())!=-1){
				if(win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][2][2].getLabel())!=0)
					return win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][2][2].getLabel());
				flag=1;
			}
			if(win((String)button[pi][pj][2][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][1][2].getLabel())!=-1){
				if(win((String)button[pi][pj][2][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][1][2].getLabel())!=0)
					return win((String)button[pi][pj][2][0].getLabel(),(String)button[pi][pj][1][1].getLabel(),(String)button[pi][pj][1][2].getLabel());
				flag=1;
			}
		
		
			if(win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][0][1].getLabel(),(String)button[pi][pj][0][2].getLabel())!=-1){
				if(win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][0][1].getLabel(),(String)button[pi][pj][0][2].getLabel())!=0)
					return win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][0][1].getLabel(),(String)button[pi][pj][0][2].getLabel());
				flag=1;
			}
			if(win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][1][0].getLabel(),(String)button[pi][pj][2][0].getLabel())!=-1){
				if(win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][1][0].getLabel(),(String)button[pi][pj][2][0].getLabel())!=0)
					return win((String)button[pi][pj][0][0].getLabel(),(String)button[pi][pj][1][0].getLabel(),(String)button[pi][pj][2][0].getLabel());
				flag=1;
			}
			
			if(win((String)button[pi][pj][2][0].getLabel(),(String)button[pi][pj][2][1].getLabel(),(String)button[pi][pj][2][2].getLabel())!=-1){
				if(win((String)button[pi][pj][2][0].getLabel(),(String)button[pi][pj][2][1].getLabel(),(String)button[pi][pj][2][2].getLabel())!=0)
					return win((String)button[pi][pj][2][0].getLabel(),(String)button[pi][pj][2][1].getLabel(),(String)button[pi][pj][2][2].getLabel());
				flag=1;
			}
			if(win((String)button[pi][pj][0][2].getLabel(),(String)button[pi][pj][1][2].getLabel(),(String)button[pi][pj][2][2].getLabel())!=-1){
				if(win((String)button[pi][pj][0][2].getLabel(),(String)button[pi][pj][1][2].getLabel(),(String)button[pi][pj][2][2].getLabel())!=0)
					return win((String)button[pi][pj][0][2].getLabel(),(String)button[pi][pj][1][2].getLabel(),(String)button[pi][pj][2][2].getLabel());
				flag=1;
			}
		
		if(flag!=1)
			return -1;
		return 0;
	}
	
	//The function that is initiated on a click
	public  void click_reaction(int pi,int pj,int x,int y)
	{
		int che;
		if(Ultimate_Tic_Tac_Toe.s=="X"){
			Ultimate_Tic_Tac_Toe.s="O";
		}
		else{
			Ultimate_Tic_Tac_Toe.s="X";
		}
		
		che=check(pi,pj,x,y);
		panel[pi][pj].putClientProperty("isWin",che);
		if(che!=0){
			if(che==1){
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						button[pi][pj][i][j].setLabel("1");
						button[pi][pj][i][j].putClientProperty("enable",false);
					}
			}
			else if(che==2){
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						button[pi][pj][i][j].setLabel("2");
						button[pi][pj][i][j].putClientProperty("enable",false);
					}
			}
			else if(che==-1){
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						button[pi][pj][i][j].setLabel("D");
						button[pi][pj][i][j].putClientProperty("enable",false);
					}
			}
		}

		int chead=check_advance();
		if(chead!=0){
				//player win stop the window 
				if(chead==1){
					JOptionPane.showMessageDialog(null, " Player 1 Won the game,Congratulations!!! ","Message", JOptionPane.ERROR_MESSAGE);
				}
				else if(chead==2){
					JOptionPane.showMessageDialog(null, " Player 2 Won the game,Congratulations!!! ","Message", JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "		Game Draw		","Message", JOptionPane.ERROR_MESSAGE);
		}

		if((int)panel[x][y].getClientProperty("isWin")==0){
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					for(int k=0;k<3;k++){
						for(int l=0;l<3;l++){
							if(i==x&&j==y){
								if((boolean)button[i][j][k][l].getClientProperty("enable")==false)
									button[i][j][k][l].setEnabled(false);
								else
									button[i][j][k][l].setEnabled(true);
							}
							else
							{
								button[i][j][k][l].setEnabled(false);
							}
						}
					}
				}
			}
		}
		else
		{
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					for(int k=0;k<3;k++){
						for(int l=0;l<3;l++){
							if((int)panel[i][j].getClientProperty("isWin")==0){
								if((boolean)button[i][j][k][l].getClientProperty("enable")==false)
									button[i][j][k][l].setEnabled(false);
								else
									button[i][j][k][l].setEnabled(true);
							}
							else
							{
								button[i][j][k][l].setEnabled(false);
							}
						}
					}
				}
			}
		}
		
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Ultimate_Tic_Tac_Toe();
			}
		});
	}
	
}

class focus extends MouseAdapter{
	Ultimate_Tic_Tac_Toe f;
	public focus(Ultimate_Tic_Tac_Toe f){
		this.f=f;
	}
	public void mouseClicked(MouseEvent ae){
		JButton b=(JButton)ae.getSource();
		if((boolean)b.getClientProperty("enable")==true){
			b.setLabel(Ultimate_Tic_Tac_Toe.s);
			b.putClientProperty("enable",false);
			f.click_reaction((int)b.getClientProperty("i"),(int)b.getClientProperty("j"),(int)b.getClientProperty("k"),(int)b.getClientProperty("l"));
		
		}
		
	}

}