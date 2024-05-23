package com.cryptoblack.smsc;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView smscTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smscTextView = findViewById(R.id.smscTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://your-server-ip:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoIPSMSCService service = retrofit.create(VoIPSMSCService.class);

        service.getSMSC("Sprint").enqueue(new Callback<SMSCResponse>() {
            @Override
            public void onResponse(Call<SMSCResponse> call, Response<SMSCResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    smscTextView.setText(response.body().getSmsc());
                }
            }

            @Override
            public void onFailure(Call<SMSCResponse> call, Throwable t) {
                smscTextView.setText("Error: " + t.getMessage());
            }
        });
    }
}
