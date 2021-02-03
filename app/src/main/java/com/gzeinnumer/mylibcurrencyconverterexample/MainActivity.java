package com.gzeinnumer.mylibcurrencyconverterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.gzeinnumer.mylibcurrencyconverter.utils.CurrencyConverter;
import com.gzeinnumer.mylibcurrencyconverter.utils.StringTools;
import com.gzeinnumer.mylibcurrencyconverterexample.databinding.ActivityMainBinding;
import com.gzeinnumer.mylibsimpletextwatcher.SimpleTextWatcher;
import com.gzeinnumer.mylibsimpletextwatcher.interfaceCallBack.AfterTextChanged;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initEditText();
    }

    private void initEditText() {
        binding.ed1.addTextChangedListener(new CurrencyConverter(binding.ed1, "RP ", new CurrencyConverter.StringCallBack() {
            @Override
            public void realString(String value) {
                binding.tvReal.setText("(Real Value) : " + value);
            }
        }));

        binding.ed2.addTextChangedListener(new SimpleTextWatcher(new AfterTextChanged() {
            @Override
            public void afterTextChanged(Editable s) {
                String str = StringTools.trimCommaOfString(s.toString(), "RP ");

                binding.tvReal.setText("(Real Value) : " + str);
            }
        }));

        binding.ed3.addTextChangedListener(new SimpleTextWatcher(new AfterTextChanged() {
            @Override
            public void afterTextChanged(Editable s) {
                String str = StringTools.trimCommaOfString(s.toString(), "RP ");

                binding.tvReal.setText("(Real Value) : " + str);
            }
        }));
    }
}