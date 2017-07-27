package in.ac.iiitd.jal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ApplyActivity extends AppCompatActivity {

    private Context mContext;
    private DataModel dataModel;
    private RadioGroup radioGroupRequestType;

    private EditText editFirstName;
    private EditText editMiddleName;
    private EditText editLastName;
    private EditText editFatherName;
    private EditText editEmail;
    private EditText editMobile;
    private EditText editHomeNo;
    private EditText editOfficeNo;

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        mContext = this;
        radioGroupRequestType = (RadioGroup) findViewById(R.id.radio_grp_request_type);

        editFirstName = (EditText) findViewById(R.id.edit_first_name);
        editMiddleName = (EditText) findViewById(R.id.edit_middle_name);
        editLastName = (EditText) findViewById(R.id.edit_last_name);
        editFatherName = (EditText) findViewById(R.id.edit_father_name);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editMobile = (EditText) findViewById(R.id.edit_mobile);
        editHomeNo = (EditText) findViewById(R.id.edit_home_no);
        editOfficeNo = (EditText) findViewById(R.id.edit_office_no);

        nextButton = (Button) findViewById(R.id.btn_next);

        dataModel = new DataModel();
        initListeners();
    }

    private void initListeners(){
        radioGroupRequestType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i == R.id.radio_btn_water_connection){
                    dataModel.setTypeOfRequest("Water");
                }
                else if(i == R.id.radio_btn_sewer_connection){
                    dataModel.setTypeOfRequest("Sewer");
                }
                else if(i == R.id.radio_btn_water_sewer_connection){
                    dataModel.setTypeOfRequest("Water and Sewer");
                }
                else {
                    dataModel.setTypeOfRequest("Regularization");
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataModel.setFirstName(editFirstName.getText().toString());
                dataModel.setMiddleName(editMiddleName.getText().toString());
                dataModel.setLastName(editLastName.getText().toString());
                dataModel.setFatherName(editFatherName.getText().toString());
                dataModel.setEmail(editEmail.getText().toString());
                dataModel.setMobile(editMobile.getText().toString());
                dataModel.setHomeNumber(editHomeNo.getText().toString());
                dataModel.setOfficeNumber(editOfficeNo.getText().toString());

                Intent addressIntent = new Intent(mContext, AddressActivity.class);
                addressIntent.putExtra("DataModel", dataModel);
                startActivity(addressIntent);
            }
        });
    }

}
