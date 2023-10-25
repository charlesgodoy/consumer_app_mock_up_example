package com.charlesgodoy.consumer_app_mock_up_example.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.charlesgodoy.consumer_app_mock_up_example.AccountAdapter;
import com.charlesgodoy.consumer_app_mock_up_example.R;
import com.charlesgodoy.consumer_app_mock_up_example.model.AccountModel;

import java.util.ArrayList;
import java.util.List;


public class AccountFragment extends Fragment {

    public static String VERSION = "Version 2.89.0.45";
    public static String BUILD = "Build: 1299921";

    RecyclerView recyclerView;
    AccountAdapter adapter;
    Context context;
    List<AccountModel> accountModelList;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_account, container, false);

        recyclerView = view.findViewById(R.id.rv);
        accountModelList = new ArrayList<>();
        textView = view.findViewById(R.id.tv_version_build);

        accountModelList.add(new AccountModel(R.drawable.ic_baseline_manage_accounts_24, "Account info"));
        accountModelList.add(new AccountModel(R.drawable.ic_baseline_shopping_bag_24, "Shopping list"));
        accountModelList.add(new AccountModel(R.drawable.ic_baseline_payment_24, "Payment methods"));
        accountModelList.add(new AccountModel(R.drawable.ic_baseline_house_24, "Delivery addresses"));
        accountModelList.add(new AccountModel(R.drawable.ic_baseline_discount_24, "Your couppons"));
        accountModelList.add(new AccountModel(R.drawable.ic_baseline_help_24, "Help"));
        accountModelList.add(new AccountModel(R.drawable.ic_baseline_format_italic_24, "Legal"));

        textView.setText(VERSION + "     " + BUILD);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new AccountAdapter(context, accountModelList);
        recyclerView.setAdapter(adapter);

        return view;

    }
}