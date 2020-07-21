package com.example.assignment2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.fragment.StartFragment
import com.example.assignment2.util.constant.HelpConstant
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Monil Panchal, B00838558 on 2020-03-27.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * This is the Main Activity, serving as an entry point for the application.
 * This is a Single-activity android app.
 * Three fragments [StartFragment], [ListFragment] and [FinalFragment] attach to it.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            val fragment = StartFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit()
        }

        /**
         * This is a show help function.
         * It displays [AlertDialog] when help button is clicked .
         */
        helpButton.setOnClickListener {
            Log.i("button", "button")
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle(HelpConstant.TITLE)
            builder.setMessage(
                HelpConstant.MESSAGE_1 +
                        "\n" + HelpConstant.MESSAGE_2 +
                        "\n" + HelpConstant.MESSAGE_3
            )
            builder.setPositiveButton(HelpConstant.OKAY_BUTTON) { dialog, which ->
                //Toast.makeText(null, "Ok, we change the app background.", Toast.LENGTH_SHORT).show()
                Toast.makeText(
                    applicationContext,
                    HelpConstant.PROCEED,
                    Toast.LENGTH_SHORT
                ).show()
            }
            val alert = builder.create()
            alert.setTitle(HelpConstant.HELP_TITLE)
            alert.show()
        }
    }

}