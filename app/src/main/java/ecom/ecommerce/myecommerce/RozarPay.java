package ecom.ecommerce.myecommerce;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import static ecom.ecommerce.myecommerce.MyAddressesActivity.NAME;
import static ecom.ecommerce.myecommerce.MyAddressesActivity.PHONE;
import static ecom.ecommerce.myecommerce.MyAddressesActivity.SP;


public class RozarPay extends AppCompatActivity implements PaymentResultListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozar_pay);
        Checkout.preload(getApplicationContext());
startPayment();

        }
    public void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_qgja3UyOIgwDCr");
        /**
         * Instantiate Checkout
         */

        /**
         * Set your logo here
         */
        checkout.setImage(R.drawable.haircare);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();
            SharedPreferences sharedPreferences=getSharedPreferences(SP,MODE_PRIVATE);
            options.put("name", sharedPreferences.getString(NAME,"Srujan Patel"));
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", String.valueOf((sharedPreferences.getInt("t",100)*100)));//pass amount in currency subunits
            options.put("prefill.email", "srujanpatel@gmail.com");
            options.put("prefill.contact",sharedPreferences.getString(PHONE,"1234567890"));
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("tag", "Error in starting Razorpay Checkout", e);
        }
    }


    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this,"Payment Success",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this,"Payment Failed ",Toast.LENGTH_LONG).show();
    }
}
