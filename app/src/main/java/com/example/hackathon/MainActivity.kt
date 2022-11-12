package com.example.hackathon

import TransactionFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupFragment = SignUpFragment()
        val emergencyFragment = EmergencyFragment()
        val transactionFragment= TransactionFragment()

        val logo = findViewById<ImageView>(R.id.app_logo)
        val appName = findViewById<TextView>(R.id.app_name)
        val login_btn = findViewById<Button>(R.id.login_btn)
        val loginUserBtn= findViewById<TextView>(R.id.login_user_btn)
        val loginOrgBtn= findViewById<TextView>(R.id.login_org_btn)

        val phone = findViewById<EditText>(R.id.phone_field)
        val password = findViewById<EditText>(R.id.pass_field)
        val text = findViewById<TextView>(R.id.registerText)
        val register_btn = findViewById<TextView>(R.id.signup_btn)
        //val emergency = findViewById<Button>(R.id.Emergency)

        val spinner= findViewById<Spinner>(R.id.bloodBank_name)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.bloodBankName_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.onItemSelectedListener=this
        }


        phone.visibility=View.GONE
        spinner.visibility=View.VISIBLE
        loginOrgBtn.visibility=View.GONE
        loginUserBtn.visibility=View.VISIBLE

        loginUserBtn.setOnClickListener {
            spinner.visibility = View.GONE
            phone.visibility=View.VISIBLE

            loginOrgBtn.visibility=View.VISIBLE
            loginUserBtn.visibility=View.GONE
        }

        loginOrgBtn.setOnClickListener {
            spinner.visibility = View.VISIBLE
            phone.visibility=View.GONE

            loginOrgBtn.visibility=View.GONE
            loginUserBtn.visibility=View.VISIBLE
        }

        register_btn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.replace_layout, signupFragment)
                //addToBackStack(null)
                commit()
                login_btn.visibility = View.GONE
                register_btn.visibility = View.GONE
                phone.visibility = View.GONE
                password.visibility = View.GONE
                text.visibility = View.GONE
                logo.visibility = View.GONE
                appName.visibility = View.GONE
                loginUserBtn.visibility=View.GONE
                spinner.visibility=View.GONE
                //emergency.visibility = View.GONE
            }
        }



        login_btn.setOnClickListener {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

           val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

            /*val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("http://www.google.com"))
            startActivity(intent)*/


          /*  supportFragmentManager.beginTransaction().apply {
                replace(R.id.replace_layout, exploreFragment)
                //addToBackStack(null)
                commit()
                login_btn.visibility = View.GONE
                register_btn.visibility = View.GONE
                phone.visibility = View.GONE
                password.visibility = View.GONE
                text.visibility = View.GONE
                logo.visibility = View.GONE
                appName.visibility = View.GONE
                emergency.visibility = View.GONE

            }*/
}
/*
emergency.setOnClickListener {
*//* val intent = Intent(this, DocumentsFragment::class.java)
startActivity(intent)
*//*
supportFragmentManager.beginTransaction().apply {
   replace(R.id.replace_layout, emergencyFragment)
   //addToBackStack(null)
   commit()
   login_btn.visibility = View.GONE
   register_btn.visibility = View.GONE
   phone.visibility = View.GONE
   password.visibility = View.GONE
   text.visibility = View.GONE
   logo.visibility = View.GONE
   appName.visibility = View.GONE
   emergency.visibility = View.GONE

}*/
}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        val item= parent?.selectedItem
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
