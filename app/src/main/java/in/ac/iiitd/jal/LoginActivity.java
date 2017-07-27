package in.ac.iiitd.jal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

/**
 * version 1 of the app
 */
public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        else {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()))
                    .setTheme(R.style.AppTheme)
                    .setLogo(R.drawable.logo)
                    .build(), RC_SIGN_IN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            IdpResponse idpResponse = IdpResponse.fromResultIntent(data);

            if(resultCode == ResultCodes.OK){
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return;
            }
            else {
                if (idpResponse == null) {
                    // User pressed back button
                    showToast(getString(R.string.sign_in_cancelled));
                    onBackPressed();
                    return;
                }

                if (idpResponse.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    showToast(getString(R.string.no_internet_connection));
                    onBackPressed();
                    return;
                }

                if (idpResponse.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    showToast(getString(R.string.unknown_error));
                    onBackPressed();
                    return;
                }
                showToast(getString(R.string.unknown_sign_in_response));
                onBackPressed();
            }
        }
    }

    private void showToast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
