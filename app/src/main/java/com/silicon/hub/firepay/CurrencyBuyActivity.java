package com.silicon.hub.firepay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyBuyActivity extends AppCompatActivity {

    public static final String BUY_BITCOIN = "com.silicon.hub.firepay.BUY_BITCOIN";
    public static final String BUY_PERFECT_MONEY = "com.silicon.hub.firepay.BUY_PERFECT_MONEY";
    public static final String BUY_MASTER_TRADER = "com.silicon.hub.firepay.BUY_MASTER_TRADER";
    public static final String BUY_ETHEREUM = "com.silicon.hub.firepay.BUY_ETHEREUM";

    private TextView currencyTextView;
    private TextInputLayout currencyAddressTextLayout;
    private EditText amountEditText;
    private EditText amountToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_buy);

        Intent intent = getIntent();
        String callingIntent = intent.getAction();

        currencyTextView = findViewById(R.id.textview_currency);
        currencyAddressTextLayout = findViewById(R.id.text_layout_currency_address);
        amountEditText = findViewById(R.id.edittext_amount_entered);
        amountToPay = findViewById(R.id.edittext_amount_to_pay);

        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    amountToPay.setText("\u20a60");
                } else{
                    long exchange_rate = 360;
                    long amount_to_convert = Long.parseLong(amountEditText.getText().toString());
                    long convertAmount = amount_to_convert * exchange_rate;
                    Locale locale = new Locale("en", "NG");
                    String formatConvertAmount = NumberFormat.getCurrencyInstance(locale).format(convertAmount);
                    //String convertAmountString = "\u20a6" + formatConvertAmount;
                    amountToPay.setText(formatConvertAmount);
                }
            }
        });

        populateViews(callingIntent);
    }

    public void populateViews(String action) {
        switch (action) {
            case BUY_BITCOIN:
                currencyTextView.setText("BITCOIN");
                currencyAddressTextLayout.setHint("Bitcoin Address");
                break;
            case BUY_PERFECT_MONEY:
                currencyTextView.setText("PERFECT MONEY");
                currencyAddressTextLayout.setHint("Perfect Money Address");
                break;
            case BUY_MASTER_TRADER:
                currencyTextView.setText("MASTER TRADER");
                currencyAddressTextLayout.getEditText().setHint("Master Trader Address");
                break;
            case BUY_ETHEREUM:
                currencyTextView.setText("ETHEREUM");
                currencyAddressTextLayout.getEditText().setHint("Ethereum Address");
                break;

        }
    }
}
