package com.example.whichnumberisbigger;

public class BiggerNumberGame {
    private int number1;
    private int number2;
    private int score;
    private int lowerLimit;
    private int upperLimit;
    private String question;

    public BiggerNumberGame(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        generateRandomNumbers();
    }
    public void generateRandomNumbers(){
        // generate a number between the lower and upper limits inclusive
        number1 = (int)(Math.random()*(upperLimit-lowerLimit+1)+lowerLimit);
        // store number in number1
        //generate another number and make sure that it's different
        do{
            number2 = (int)(Math.random()*(upperLimit-lowerLimit+1)+lowerLimit);
        } while (number1 == number2);
        //store number in number2
        question = "Which Number is Bigger?";
    }
    public int max(int firstNumber,int secondNumber){
        if (firstNumber >= secondNumber){
            return firstNumber;
        }
        else {
            return secondNumber;
        }
    }

    public String checkAnswer(int answer){
        // determine if the answer is right?
        if (answer == max(number1,number2)){
            score++;
            return "Correct";
        }
        else {
            score--;
            return "Wrong";
        }
            //based on the values of number1 & number2
        // update the score accordingly
        //return relevant message

    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
