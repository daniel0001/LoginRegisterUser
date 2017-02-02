package mycompany.freecoffeev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        final EditText etTownCity = (EditText) findViewById(R.id.etTownCity);
        final EditText etCountry = (EditText) findViewById(R.id.etCountry);
        final EditText etEmailAddress = (EditText) findViewById(R.id.etEmailAddress);

        // retrieve data passed to this activty from LoginActivity

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String city = intent.getStringExtra("city");
        String country = intent.getStringExtra("country");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        int phone = intent.getIntExtra("phone", -1);

        String message = name + " welcome to your User Area";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etCountry.setText(country);
        etEmailAddress.setText(email);
        etPhone.setText(phone + "");
        etTownCity.setText(city);
        etName.setText(name);

    }
}
