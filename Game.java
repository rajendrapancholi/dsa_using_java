class GameEntry {
    private String name;
    private int score;
    
    public GameEntry(String n, int s){
        name = n;
        score = s;
    }
    public String getName(){
            return name;
    }
    public int getScore(){
            return score;
    }
    public String toString(){
            return "("+name+", "+score+")";
    }
}

class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity){ 
        board = new GameEntry[capacity];
    }
    public void add(GameEntry e){
        int newScore = e.getScore();
        if(numEntries< board.length || newScore > board[numEntries-1].getScore()){
            if(numEntries<board.length){
                numEntries++;
            }
            int j = numEntries -1;
            while(j>0 && board[j-1].getScore()<newScore){
                j--;
            }
            board[j] = e;
        }
    }
}

public class Game{
    public static void main(String[] args){
       GameEntry d = new GameEntry("Akshat Nishod",10);
    //    Scoreboard sb = new Scoreboard(1);
    //    System.out.print(sb);
        // toString();
        System.out.print("Your name is: " + d.getName() + " and Score is: "+ d.getScore() );
    }
}