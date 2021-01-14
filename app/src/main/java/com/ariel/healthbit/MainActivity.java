package com.ariel.healthbit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ariel.healthbit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{
    public static String uid = null;  // Erez add this line 1
    Toolbar toolbar;
    Button signupbutton,signinbutton;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.upload);
        setSupportActionBar(toolbar);

        user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null)
        {
            uid = user.getUid().toString(); // Erez add this line 2
            Intent myIntent = new Intent(getApplicationContext(),MainProfile.class);
            startActivity(myIntent);
            this.finish();

        }
        signupbutton = (Button) findViewById(R.id.activitymain_signup); //move to the sign up activity
        signupbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                Intent myIntent = new Intent(getApplicationContext(), signup.class);
                startActivity(myIntent);
            }

        });

        signinbutton = (Button) findViewById(R.id.activitymain_signin); //move to the sign in activity
        signinbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                Intent myIntent = new Intent(getApplicationContext(), signin.class);
                startActivity(myIntent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)//toolbar definition
    {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuAbout) {
            // About activity
            Intent myIntent = new Intent(getApplicationContext(), About_activity.class);
            startActivity(myIntent);
            return true;
        } else if (id == R.id.menuSettings) {
            // Contact activity
            Intent myIntent = new Intent(getApplicationContext(), ContactActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {
        finishAffinity();
    }
}