package com.gzeinnumer.mylibcurrencyconverterexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.etc.utils.CurrencyConverter;
import com.gzeinnumer.etc.utils.StringTools;
import com.gzeinnumer.mylibcurrencyconverterexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        sample1();
        sample3();
    }

    private void sample1() {
        binding.editText.addTextChangedListener(new CurrencyConverter(binding.editText));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = binding.editText.getText().toString();
                Log.d(TAG, "onClick: " + StringTools.trimCommaOfString(str));

                binding.textView.setText(StringTools.trimCommaOfString(str));
            }
        });
    }

    private void sample3() {
        binding.editText.addTextChangedListener(new CurrencyConverter(binding.editText, new CurrencyConverter.StringCallBack() {
            @Override
            public void realString(String value) {
                binding.textView.setText("(Real Value) : " + value + " && (Preview) : " + binding.editText.getText().toString());
            }
        }));
    }
}