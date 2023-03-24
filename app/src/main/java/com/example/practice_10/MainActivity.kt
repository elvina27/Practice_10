package com.example.practice_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt
//import com.example.practice_10.MainActivity.GameRules.Stone
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Game = findViewById(R.id.btnGame)
        Stone = findViewById(R.id.btnStone)
        Paper = findViewById(R.id.btnPaper)
        Spok = findViewById(R.id.btnSpok)
        Scissors = findViewById(R.id.btnScissors)
        Lizard = findViewById(R.id.btnLizard)
        End = findViewById(R.id.btnEnd)
        Viewing = findViewById(R.id.imgViewing)
        User = findViewById(R.id.imgUser)
        Comp = findViewById(R.id.imgComp)
        ResultView = findViewById(R.id.txtResultView)
        View2 = findViewById(R.id.txtView2)
        View4 = findViewById(R.id.txtView4)
        View5 = findViewById(R.id.txtView5)
        tView = findViewById(R.id.txtView)
        View3 = findViewById(R.id.txtView3)
        Winning = findViewById(R.id.txtWinning)
        Draw = findViewById(R.id.txtDraw)
        Losst = findViewById(R.id.txtLoss)
    }

    lateinit var Game: Button
    lateinit var Stone: Button
    lateinit var Paper: Button
    lateinit var Spok: Button
    lateinit var Scissors: Button
    lateinit var Lizard: Button
    lateinit var End: Button
    lateinit var Viewing: ImageView
    lateinit var User: ImageView
    lateinit var Comp: ImageView
    lateinit var ResultView: TextView
    lateinit var View2: TextView
    lateinit var View4: TextView
    lateinit var View5: TextView
    lateinit var Winning: TextView
    lateinit var Draw: TextView
    lateinit var Losst: TextView
    lateinit var tView: TextView
    lateinit var View3: TextView

    var user: Int = 0
    var comp: Int = 0
    var winningg: Int = 0
    var loss: Int = 0
    var draw: Int = 0
    var timeStart: Long = 0
    var timeFinish: Long = 0


    fun btnGameClick(view: View) {
        Stone.isEnabled = true
        Paper.isEnabled = true
        Scissors.isEnabled = true
        Lizard.isEnabled = true
        Spok.isEnabled = true
        Game.isEnabled = false

        val compChoise = intArrayOf(1, 2, 3, 4, 5)
        comp = compChoise.random()
        timeStart = System.currentTimeMillis()
        winningg = 0
        Winning.text = "0"
        draw = 0
        Draw.text = "0"
        loss = 0
        Losst.text = "0"
        ResultView.text = ""
        User.setVisibility(View.VISIBLE);
        Comp.setVisibility(View.VISIBLE);
        Viewing.setVisibility(View.VISIBLE);
        ResultView.setVisibility(View.VISIBLE);
        View2.setVisibility(View.INVISIBLE);
        View4.setVisibility(View.INVISIBLE);
        View3.setVisibility(View.INVISIBLE);
        tView.setVisibility(View.INVISIBLE);
        View5.setVisibility(View.INVISIBLE);
        Winning.setVisibility(View.INVISIBLE);
        Draw.setVisibility(View.INVISIBLE);
        Losst.setVisibility(View.INVISIBLE);

        Viewing.setImageResource(R.drawable.all)
        User.setImageResource(R.drawable.nothing)
        Comp.setImageResource(R.drawable.nothing)
    }

    fun GameClick() {
        Stone.isEnabled = true
        Paper.isEnabled = true
        Scissors.isEnabled = true
        Lizard.isEnabled = true
        Spok.isEnabled = true
        End.isEnabled = true
    }

    fun btnEndClick(view: View) {
        Stone.isEnabled = false
        Paper.isEnabled = false
        Scissors.isEnabled = false
        Lizard.isEnabled = false
        Spok.isEnabled = false
        Game.isEnabled = true
        End.isEnabled = false

        timeFinish = System.currentTimeMillis()
        var time = ((((timeFinish.toDouble() - timeStart.toDouble()) / 1000.0) * 100).roundToInt()
            .toDouble() / 100)
        View3.text = time.toString()

        View2.setVisibility(View.VISIBLE);
        View4.setVisibility(View.VISIBLE);
        View5.setVisibility(View.VISIBLE);
        Winning.setVisibility(View.VISIBLE);
        Draw.setVisibility(View.VISIBLE);
        Losst.setVisibility(View.VISIBLE);
        View3.setVisibility(View.VISIBLE);
        tView.setVisibility(View.VISIBLE);
        User.setVisibility(View.INVISIBLE);
        Comp.setVisibility(View.INVISIBLE);
        Viewing.setVisibility(View.INVISIBLE);
        ResultView.setVisibility(View.INVISIBLE);
    }

    fun btnStoneClick(view: View) {
        user = 1
        val compChoise = intArrayOf(1, 2, 3, 4, 5)
        comp = compChoise.random()
        User.setImageResource(R.drawable.stone)
        Gamee()
        Comp.setImageResource(ImageComp(comp))
        Game.isEnabled = false
    }

    fun btnPaperClick(view: View) {
        user = 2
        val compChoise = intArrayOf(1, 2, 3, 4, 5)
        comp = compChoise.random()
        User.setImageResource(R.drawable.paper)
        Gamee()
        Comp.setImageResource(ImageComp(comp))
        Game.isEnabled = false
    }

    fun btnSpokClick(view: View) {
        user = 3
        val compChoise = intArrayOf(1, 2, 3, 4, 5)
        comp = compChoise.random()
        User.setImageResource(R.drawable.spok)
        Gamee()
        Comp.setImageResource(ImageComp(comp))
        Game.isEnabled = false
    }

    fun btnScissorsClick(view: View) {
        user = 4
        val compChoise = intArrayOf(1, 2, 3, 4, 5)
        comp = compChoise.random()
        User.setImageResource(R.drawable.scissors)
        Gamee()
        Comp.setImageResource(ImageComp(comp))
        Game.isEnabled = false
    }

    fun btnLizardClick(view: View) {
        user = 5
        val compChoise = intArrayOf(1, 2, 3, 4, 5)
        comp = compChoise.random()
        User.setImageResource(R.drawable.lizard)
        Gamee()
        Comp.setImageResource(ImageComp(comp))
        Game.isEnabled = false
    }

    fun Gamee() {
        if (user == comp) {
            draw++
            Draw.text = draw.toString()
            ResultView.text = "Ничья!"
            Viewing.setImageResource(R.drawable.draw)
            GameClick()
        } else if (user == 1 && comp == 4 || user == 1 && comp == 5 ||
            user == 2 && comp == 1 || user == 2 && comp == 3 ||
            user == 3 && comp == 1 || user == 3 && comp == 4 ||
            user == 4 && comp == 2 || user == 4 && comp == 5 ||
            user == 5 && comp == 2 || user == 5 && comp == 3
        ) {
            winningg++
            Winning.text = winningg.toString()
            ResultView.text = "Выиграл!"
            Viewing.setImageResource(R.drawable.winn)
            GameClick()
        } else {
            loss++
            Losst.text = loss.toString()
            ResultView.text = "Проиграл!"
            Viewing.setImageResource(R.drawable.lose)
            GameClick()
        }
    }

    fun ImageComp(comp: Int): Int {
        return when (comp) {
            1 -> R.drawable.stone
            2 -> R.drawable.paper
            3 -> R.drawable.spok
            4 -> R.drawable.scissors
            5 -> R.drawable.lizard
            else -> R.drawable.all
        }
    }
}