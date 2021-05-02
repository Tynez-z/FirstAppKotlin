package com.example.firstappkotlin
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private var questionList: ArrayList<Questions>? = null
    private var selectedOptionPosition: Int = 0

    private var correctAnswers: Int = 0
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userName = intent.getStringExtra(Constants.USER_NAME)

        questionList = Constants.getQuestions()
        setQuestion()
        answerOne.setOnClickListener(this)
        answerTwo.setOnClickListener(this)
        answerThree.setOnClickListener(this)
        answerFour.setOnClickListener(this)
        buttonAnswer.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = questionList!![currentPosition - 1]
        defaultOptionView()
        if (currentPosition == questionList!!.size) {
            buttonAnswer.text = "Finish"
        } else {
            buttonAnswer.text = "SUBMIT"
        }
        progressBar.progress = currentPosition
        textProgressBar.text = "$currentPosition" + "/" + progressBar.max
        textViewQuestion.text = question!!.question
        imageView.setImageResource(question.img)
        answerOne.text = question.answerOptionOne
        answerTwo.text = question.answerOptionTwo
        answerThree.text = question.answerOptionThree
        answerFour.text = question.answerOptionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, answerOne)
        options.add(1, answerTwo)
        options.add(2, answerThree)
        options.add(3, answerFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#A9A9A9"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.answerOne -> {
                selectedOptionView(answerOne, 1)
            }
            R.id.answerTwo -> {
                selectedOptionView(answerTwo, 2)
            }
            R.id.answerThree -> {
                selectedOptionView(answerThree, 3)
            }
            R.id.answerFour -> {
                selectedOptionView(answerFour, 4)
            }
            R.id.buttonAnswer -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUSTION, questionList!!.size)
                            startActivity(intent)

                        }
                    }
                } else {
                    val question = questionList?.get(currentPosition - 1)
                    if (question!!.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.incorrect)
                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct)
                    if (currentPosition == questionList!!.size) {
                        buttonAnswer.text = "Finish"
                    } else {
                        buttonAnswer.text = "Go to next question"
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                answerOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                answerTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                answerThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                answerFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(TV: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        selectedOptionPosition = selectedOptionNum
        TV.setTextColor(Color.parseColor("#FF000000"))
        TV.setTypeface(TV.typeface, Typeface.BOLD)
        TV.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option
        )
    }
}


