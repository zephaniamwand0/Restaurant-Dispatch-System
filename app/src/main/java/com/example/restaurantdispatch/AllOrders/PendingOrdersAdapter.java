package com.example.restaurantdispatch.AllOrders;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantdispatch.R;
import com.example.restaurantdispatch.SingleOrder.SingleOrderActivity;

import java.util.List;

public class PendingOrdersAdapter extends RecyclerView.Adapter<PendingOrdersAdapter.CustomViewHolder> {
    private List<Orders> ordersList;

    PendingOrdersAdapter(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Reference the views in the layout

        public final View ordersView;
        TextView orderId;
        TextView userName;
        TextView userEmail;
        TextView orderDispatchStatus;

        CustomViewHolder(View itemView) {
            super(itemView);
            ordersView = itemView;

            orderId = ordersView.findViewById(R.id.tvOrderId);
            userName = ordersView.findViewById(R.id.tvUserName);
            userEmail = ordersView.findViewById(R.id.tvUserEmail);
            orderDispatchStatus = ordersView.findViewById(R.id.tvOrderDispatchStatus);

        }
    }

    //RecyclerView View Holder
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_order_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder
            (@NonNull CustomViewHolder holder, int position) {
        String status = ordersList.get(position).getDispatch_status();
        final String orderIdentity = ordersList.get(position).getId();
        if (status.equals("0")) {

            String id = "Order: " + ordersList.get(position).getId();
            String name = "Customer Name: " + ordersList.get(position).getName();
            String email = "Customer Email: "+ ordersList.get(position).getEmail();
            String dispatchStatus = "Dispatch Status: Not Dispatched";

            holder.orderId.setText(id);
            holder.userName.setText(name);
            holder.userEmail.setText(email);
            holder.orderDispatchStatus.setText(dispatchStatus);

            holder.ordersView.setOnClickListener(view -> {
                Intent clickOrderIntent = new Intent(view.getContext(),
                        SingleOrderActivity.class);
                clickOrderIntent.putExtra("orderId", orderIdentity);
                view.getContext().startActivity(clickOrderIntent);
            });
        }else{
           // holder.mView.setVisibility(View.GONE);
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            params.height = 0;
            holder.ordersView.setLayoutParams(params);
        }
    }

    //Calculate the Item count
    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}
