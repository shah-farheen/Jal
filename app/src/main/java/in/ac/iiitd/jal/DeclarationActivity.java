package in.ac.iiitd.jal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeclarationActivity extends AppCompatActivity {

    private Context mContext;
    private String timeStamp;
    private DataModel dataModel;
    private SharedPreferences dataFile;

    private Button buttonApply;
    private CheckBox checkAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaration);
        mContext = this;
        dataFile = getSharedPreferences(LoginActivity.DATA_FILE, MODE_PRIVATE);
        buttonApply = (Button) findViewById(R.id.btn_apply);
        checkAgree = (CheckBox) findViewById(R.id.check_agree);

        Intent intent = getIntent();
        timeStamp = intent.getStringExtra("TIME");
        dataModel = intent.getParcelableExtra("DataModel");
        initListeners();
    }

    private void initListeners(){
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAgree.isChecked()){
                    sendForm();
                }
                else {
                    makeToast("Agree to the Declarations");
                }
            }
        });
    }

    private void sendForm(){
        DatabaseReference dateRef = FirebaseDatabase.getInstance()
                .getReference(dataFile.getString(LoginActivity.PHONE_NO, "9876543210"));
        dateRef.child(timeStamp).setValue(dataModel);
        makeToast("Applied Successfully");

        Intent loginIntent = new Intent(mContext, MainActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(loginIntent);
        finish();
    }

    private void makeToast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
