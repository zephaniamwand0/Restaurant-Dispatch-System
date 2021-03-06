package com.example.restaurantdispatch;

import com.example.restaurantdispatch.AllOrders.ModelClass;
import com.example.restaurantdispatch.SingleOrder.ModelClass2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * GetData.java - Class that acts as the API Service to all orders
 *
 * @author Zephania Mwando
 * @version 1.0
 */

public interface GetData {

    //String baseUrl = "https://demo.kilimanjarofood.co.ke/api/";

    @Headers("Content-Type: application/json")
    //Request type
    @GET("v1/dispatch/orders")
        //Response in a call object
    Call<ModelClass> getOrders();

    @GET("v1/dispatch/order")
        //Response in a call object
    Call<ModelClass2> getOrder(@Query("orderId") int orderId);

    @POST("v1/dispatch/order")
    Call<ModelClass2> dispatchOrder(@Query("orderId") int orderId);

}
