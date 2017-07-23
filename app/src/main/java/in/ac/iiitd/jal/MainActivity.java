package in.ac.iiitd.jal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button applyButton;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        applyButton = (Button) findViewById(R.id.btn_apply_new);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference dataRef = database.getReference("TestKey");
//        dataRef.setValue(null);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ApplyActivity.class));
            }
        });
    }
}
