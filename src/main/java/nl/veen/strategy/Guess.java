package nl.veen.strategy;

public class Guess {
    private int id;
    private String code;
    private String answer;



    public Guess(int id, String code, String answer) {
        this.id = id;
        this.code = code;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString(){
        return this.id + this.code + this.answer;
    }

}
