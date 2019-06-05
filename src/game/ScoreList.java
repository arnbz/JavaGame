package game;

public class ScoreList{
	private String name;
	private int scores;
	private String age;
	
	public ScoreList(String name,String age,int scores){
		this.name=name;
		this.age = age;
		this.scores= scores;
		
		
	}
	
	public void setName(String name){
		
		this.name=name;
		
		}
	
	public void setScores(int scores){
		
		this.scores = scores;
		
	}
	public void setAge(String age){
		
		
		this.age = age;
		
		
	}
	
	public String getName(){
		
		return this.name;
		
		}
	
	
	public int getScores(){
		
		return this.scores;
		
	}
	public String getAge(){
		
		return this.age;
		
	}
	
	
}