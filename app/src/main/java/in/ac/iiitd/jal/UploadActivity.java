package in.ac.iiitd.jal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadActivity extends AppCompatActivity {

    private static final int RC_IMAGE = 10;
    private static final int RC_ID_PROOF = 11;
    private static final int RC_RES_PROOF = 12;

    private static final String META_IMAGE = "image";
    private static final String META_ID_PROOF = "ID_proof";
    private static final String META_RES_PROOF = "res_proof";

    private String phoneNo;
    private Context mContext;
    private String timeStamp;
    private DataModel dataModel;

    private ImageView imageImage;
    private ImageView imageIdProof;
    private ImageView imageResProof;
    private Button buttonImage;
    private Button buttonIdProof;
    private Button buttonResProof;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        mContext = this;
        SharedPreferences dataFile = getSharedPreferences(LoginActivity.DATA_FILE, MODE_PRIVATE);
        phoneNo = dataFile.getString(LoginActivity.PHONE_NO, "9876543210");

        Intent intent = getIntent();
        dataModel = intent.getParcelableExtra("DataModel");
        timeStamp = String.valueOf(System.currentTimeMillis());

        imageImage = (ImageView) findViewById(R.id.img_image);
        imageIdProof = (ImageView) findViewById(R.id.img_id_pr);
        imageResProof = (ImageView) findViewById(R.id.img_res_poof);

        buttonImage = (Button) findViewById(R.id.btn_upload_image);
        buttonIdProof = (Button) findViewById(R.id.btn_upload_id_proof);
        buttonResProof = (Button) findViewById(R.id.btn_upload_res_proof);
        buttonNext = (Button) findViewById(R.id.btn_next);
        initListeners();
    }

    private void initListeners(){
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImage(RC_IMAGE);
            }
        });

        buttonIdProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImage(RC_ID_PROOF);
            }
        });

        buttonResProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImage(RC_RES_PROOF);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uploadIntent = new Intent(mContext, DeclarationActivity.class);
                uploadIntent.putExtra("DataModel", dataModel);
                uploadIntent.putExtra("TIME", timeStamp);
                startActivity(uploadIntent);
            }
        });
    }

    private void getImage(int rc){
        Intent imageIntent = new Intent(Intent.ACTION_GET_CONTENT);
        imageIntent.setType("image/*");
        if(imageIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(imageIntent, rc);
        }
        else {
            Toast.makeText(getApplicationContext(), "No gallery app", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RC_IMAGE && resultCode == RESULT_OK){
            Log.e("Uri: ", String.valueOf(data.getData()));
            Glide.with(mContext).load(data.getData()).into(imageImage);
//            imageImage.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
            dataModel.setImageUrl(String.valueOf(data.getData()));
            uploadImage(data.getData(), META_IMAGE);
        }
        else if(requestCode == RC_ID_PROOF && resultCode == RESULT_OK){
            Log.e("Uri: ", String.valueOf(data.getData()));
            Glide.with(mContext).load(data.getData()).into(imageIdProof);
//            imageIdProof.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
            dataModel.setIdProofUrl(String.valueOf(data.getData()));
            uploadImage(data.getData(), META_ID_PROOF);
        }
        else if(requestCode == RC_RES_PROOF && resultCode == RESULT_OK){
            Log.e("Uri: ", String.valueOf(data.getData()));
            Glide.with(mContext).load(data.getData()).into(imageResProof);
//            imageResProof.setImageBitmap((Bitmap) data.getExtras().getParcelable("data"));
            dataModel.setResProofUrl(String.valueOf(data.getData()));
            uploadImage(data.getData(), META_RES_PROOF);
        }
    }

    private void uploadImage(Uri fileUri, String meta){
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference reference = firebaseStorage.getReference(phoneNo+"/"+timeStamp+"/"+meta);
        UploadTask uploadTask = reference.putFile(fileUri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Upload Failed", Toast.LENGTH_SHORT).show();
                Log.e("Upload Failed", e.getMessage());
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(), "Upload Success", Toast.LENGTH_SHORT).show();
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                Log.e("Upload Success", String.valueOf(downloadUrl));
            }
        });
    }
}
