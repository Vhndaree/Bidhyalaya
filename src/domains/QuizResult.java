package domains;

public class QuizResult {
    private int id;
    private String question;
    private String usersAnswer;
    private String correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsersAnswer() {
        return usersAnswer;
    }

    public void setUsersAnswer(String usersAnswer) {
        this.usersAnswer = usersAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
