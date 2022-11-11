package com.example.hackathon

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupFragment= SignUpFragment()

        val logo= findViewById<ImageView>(R.id.app_logo)
        val appName= findViewById<TextView>(R.id.app_name)
        val login_btn= findViewById<Button>(R.id.login_btn)

        val phone= findViewById<EditText>(R.id.phone_field)
        val password= findViewById<EditText>(R.id.pass_field)
        val text= findViewById<TextView>(R.id.registerText)
        val register_btn= findViewById<TextView>(R.id.signup_btn)
        val emergency= findViewById<Button>(R.id.Emergency)

        register_btn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.replace_layout, signupFragment)
                //addToBackStack(null)
                commit()
                login_btn.visibility= View.GONE
                register_btn.visibility= View.GONE
                phone.visibility= View.GONE
                password.visibility= View.GONE
                text.visibility= View.GONE
                logo.visibility= View.GONE
                appName.visibility=View.GONE
                emergency.visibility=View.GONE
            }
        }

        login_btn.setOnClickListener {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

        }
    }

}