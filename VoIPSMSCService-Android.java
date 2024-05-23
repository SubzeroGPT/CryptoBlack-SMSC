package com.cryptoblack.smsc;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VoIPSMSCService {
    @GET("/?carrier=Sprint")
    Call<SMSCResponse> getSMSC(@Query("carrier") String carrier);
}
