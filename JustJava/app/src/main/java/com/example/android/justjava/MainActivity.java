package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        if(quantity < 100){
            quantity++;
            displayQuantity(quantity);
        } else{
            Toast.makeText(this, "You cannot order more than a hundred cups!", Toast.LENGTH_SHORT).show();
        }
    }

    public void decrement(View view){
        if(quantity > 1){
            quantity--;
            displayQuantity(quantity);
        } else{
            Toast.makeText(this, "You cannot order less than a cup!", Toast.LENGTH_SHORT).show();
        }
    }

    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameField = (EditText) findViewById(R.id.name_field);

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        String name = nameField.getText().toString();
        String message = createOrderSummary(calculatePrice(hasWhippedCream, hasChocolate), hasWhippedCream, hasChocolate, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, ("Order for " + name));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
        int basePrice = 5;

        if (addChocolate){
            basePrice += 2;
        }
        if (addWhippedCream){
            basePrice += 1;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name){

        String message = "Name: " + name + "\nAdd Whipped Cream?";

        if (addWhippedCream){
            message += " True\nAdd Chocolate?";
        } else{
            message += " False\nAdd Chocolate?";
        }

        if (addChocolate){
            message += " True\n";
        } else{
            message += " False\n";
        }

        return message + "Quantity: " + quantity + "\nTotal: $" + price + "\nThank you!";
    }
}