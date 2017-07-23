package in.ac.iiitd.jal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddressActivity extends AppCompatActivity {

    private Context mContext;
    private DataModel dataModel;

    private EditText editEmployeeId;
    private EditText editRetirementYear;
    private EditText editOfficeAddress;

    private EditText editPinCode;
    private EditText editLocality;
    private EditText editSubLocality;
    private EditText editHouseNo;
    private EditText editVillage;
    private EditText editKhasraNo;
    private EditText editSociety;

    private EditText editPropertyType;
    private EditText editAreaType;
    private EditText editFloorCount;
    private EditText editPlotArea;
    private EditText editBuiltUpArea;

    private EditText editZroLocation;
    private EditText editChildCount;
    private EditText editAdultCount;

    private EditText editBankName;
    private EditText editBranchName;
    private EditText editIfscCode;
    private EditText editAccountNo;

    private CheckBox checkJjr;
    private Button nextButton;

    private SharedPreferences dataFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        mContext = this;
        dataFile = getSharedPreferences("DATA_FILE", MODE_PRIVATE);
        Intent intent = getIntent();
        dataModel = intent.getParcelableExtra("DataModel");

        editEmployeeId = (EditText) findViewById(R.id.edit_employee_id);
        editRetirementYear = (EditText) findViewById(R.id.edit_retire_year);
        editOfficeAddress = (EditText) findViewById(R.id.edit_office_address);

        editPinCode = (EditText) findViewById(R.id.edit_pin_code);
        editLocality = (EditText) findViewById(R.id.edit_locality);
        editSubLocality = (EditText) findViewById(R.id.edit_sub_locality);
        editHouseNo = (EditText) findViewById(R.id.edit_house_no);
        editVillage = (EditText) findViewById(R.id.edit_village);
        editKhasraNo = (EditText) findViewById(R.id.edit_khasra_no);
        editSociety = (EditText) findViewById(R.id.edit_society_name);

        editPropertyType = (EditText) findViewById(R.id.edit_property_type);
        editAreaType = (EditText) findViewById(R.id.edit_area_type);
        editFloorCount = (EditText) findViewById(R.id.edit_num_floors);
        editPlotArea = (EditText) findViewById(R.id.edit_plot_area);
        editBuiltUpArea = (EditText) findViewById(R.id.edit_built_area);

        editZroLocation = (EditText) findViewById(R.id.edit_zro_location);
        editChildCount = (EditText) findViewById(R.id.edit_child_count);
        editAdultCount = (EditText) findViewById(R.id.edit_adult_count);

        editBankName = (EditText) findViewById(R.id.edit_bank_name);
        editBranchName = (EditText) findViewById(R.id.edit_branch_name);
        editIfscCode = (EditText) findViewById(R.id.edit_ifsc_code);
        editAccountNo = (EditText) findViewById(R.id.edit_account_no);

        checkJjr = (CheckBox) findViewById(R.id.check_jjr);
        nextButton = (Button) findViewById(R.id.btn_next);

        initListeners();
    }

    private void initListeners(){
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataModel.setEmployeeId(editEmployeeId.getText().toString());
                dataModel.setRetirementYear(editRetirementYear.getText().toString());
                dataModel.setOfficeAddress(editOfficeAddress.getText().toString());

                dataModel.setPinCode(editPinCode.getText().toString());
                dataModel.setLocality(editLocality.getText().toString());
                dataModel.setSubLocality(editSubLocality.getText().toString());
                dataModel.setHouseNo(editHouseNo.getText().toString());
                dataModel.setVillage(editVillage.getText().toString());
                dataModel.setKhasraNo(editKhasraNo.getText().toString());
                dataModel.setSocietyName(editSociety.getText().toString());

                dataModel.setPropertyType(editPropertyType.getText().toString());
                dataModel.setAreaType(editAreaType.getText().toString());
                dataModel.setFloorCount(editFloorCount.getText().toString());
                dataModel.setPlotArea(editPlotArea.getText().toString());
                dataModel.setBuiltUpArea(editBuiltUpArea.getText().toString());

                dataModel.setZroLocation(editZroLocation.getText().toString());
                dataModel.setChildCount(editChildCount.getText().toString());
                dataModel.setAdultCount(editAdultCount.getText().toString());

                dataModel.setBankName(editBankName.getText().toString());
                dataModel.setBankBranch(editBranchName.getText().toString());
                dataModel.setIfscCode(editIfscCode.getText().toString());
                dataModel.setBankAccountNo(editAccountNo.getText().toString());
            }
        });
    }

    private void sendForm(){
        DatabaseReference dateRef = FirebaseDatabase.getInstance().getReference();
    }
}
