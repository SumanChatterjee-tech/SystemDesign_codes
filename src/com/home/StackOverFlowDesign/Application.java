package com.home.StackOverFlowDesign;

import java.util.Arrays;

public class Application {
	UserController userController;
	AnswerController answerController;
	QuestionController questionController;
	
	public Application(UserController userController, AnswerController answerController,
			QuestionController questionController) {
		super();
		this.userController = userController;
		this.answerController = answerController;
		this.questionController = questionController;
	}
	
	public User createUser(int id, String userName, String email) {
		User u = new User(id, userName, email);
		userController.addUser(u);
		return u;
	}
	public Question postAQuestion(String question, User user) {
		Question q = new Question(1, question, user);
		userController.addQuestion(q); //add for users
		questionController.addQuestion(q); //add for question list
		return q;
	}
	
	public Answer answerAQuestion(User user, Question question, String conenet) {
		Answer ans =  new Answer(1, conenet, user);
		userController.addAnswer(user, ans);
		answerController.addAnswer(ans);
		question.addAnswer(ans);
		return ans;
	}
	
	public void voteQuestion(User user, Question question, VoteType voteType) {
		Vote vote = new Vote(user, voteType);
		question.addVoteToQuestion(vote);
	}
	
	public void voteAnswer(User user, Answer ans, VoteType voteType) {
		Vote vote = new Vote(user, voteType);
		ans.addVoteToQuestion(vote);
	}
	public void acceptAQuestion(Question q) {
		q.setAccepted(true);
	}
	public void acceptAnAnswer(Answer ans) {
		ans.setAccepted(true);
	}
	public static void main(String[] args) {
		UserController userController = new UserController();
		QuestionController questionController = new QuestionController();
		AnswerController answerController = new AnswerController();
		
		Application app = new Application(userController, answerController, questionController);
		
	    // Create users
		User alice = app.createUser(1, "Alice", "alice@example.com");
        User bob = app.createUser(2, "Bob", "bob@example.com");
        User charlie = app.createUser(3, "Charlie", "charlie@example.com");
        
        User suman = app.createUser(4,"Suman", "sumb@example.com");
        User riju = app.createUser(5,"Riju", "rumb@example.com");
        
       // Alice asks a question
        Question javaQuestion = app.postAQuestion("Can someone explain polymorphism in Java with an example?", alice);
       
        //bob answer to alice
        Answer bobAnswer = app.answerAQuestion(bob, javaQuestion,
                "Polymorphism in Java is the ability of an object to take on many forms...");
        
        //riju answer to alice
        Answer rijuAnswer = app.answerAQuestion(riju, javaQuestion,
                "Ami janina kichu tao pakamo marchi");
        
        // Charlie upVote on the answer by bob
        app.voteAnswer(charlie, bobAnswer, VoteType.UPVOTE);  // Upvote
        app.voteAnswer(suman, bobAnswer, VoteType.UPVOTE); 
        app.voteAnswer(riju, bobAnswer, VoteType.DOWNVOTE);
        app.voteAnswer(bob, rijuAnswer, VoteType.DOWNVOTE);
        
        Answer ans = answerController.getQestionHasMaxUpVote(); //ans has max upVote should get automatically accepted
     
        app.acceptAnAnswer(ans);
        System.out.println("Answer is: "+ ans);
        
        User maxScoreUser = userController.userWithMaxReputationScore();
        
        System.out.println("Max reputation score wala user: "+maxScoreUser);
	}
}
