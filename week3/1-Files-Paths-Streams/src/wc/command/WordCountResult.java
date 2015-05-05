package wc.command;

public class WordCountResult {
    private int word_count;
    private int lines_count;
    private int characters_count;
    public WordCountResult(int word_count,int lines_count,int characters_count){
        this.word_count=word_count;
        this.lines_count=lines_count;
        this.characters_count=characters_count;
    }
    public String toString(){
        return this.word_count+ " " + this.lines_count + " " + characters_count;
    }
    
}
