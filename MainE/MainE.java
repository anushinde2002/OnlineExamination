import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Question {
    private String questionText;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Exam {
    private ArrayList<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startExam(User user) {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
            }
        }

        System.out.println("Exam completed. Your score: " + score + " out of " + questions.size());
    }
}

public class MainE {
    private static Map<String, User> users = new HashMap<>();
    private static Exam exam = new Exam();

    public static void main(String[] args) {
        initializeUsers();
        initializeQuestions();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Online Examination System");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Starting the exam...");
            exam.startExam(user);
        } else {
            System.out.println("Invalid username or password. Exiting.");
        }
    }

    private static void initializeUsers() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    private static void initializeQuestions() {
        exam.addQuestion(new Question("What is the capital of France?", "Paris"));
        exam.addQuestion(new Question("Which planet is known as the Red Planet?", "Mars"));
        exam.addQuestion(new Question("What is the largest mammal on Earth?", "Blue Whale"));
    }
}
