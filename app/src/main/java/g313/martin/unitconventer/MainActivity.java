package g313.martin.unitconventer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spn_from;
    Spinner spn_to;
    EditText txt_from;
    TextView txt_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn_from = findViewById(R.id.spn_from);
        spn_to = findViewById(R.id.spn_to);
        txt_from = findViewById(R.id.txt_from);
        txt_to = findViewById(R.id.txt_to);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spn_from.setAdapter(adp);
        spn_to.setAdapter(adp);
    }

    public void on_convert(View v)
    {
        double from;
        try
        {
            from = Double.parseDouble(txt_from.getText().toString());
        }
        catch (Exception e)
        {
            txt_to.setText("Error");
            return;
        }
        String s_from = (String) spn_from.getSelectedItem();
        String s_to = (String)  spn_to.getSelectedItem();

        double to = 0.0f;
        double m = 0.0f;

        switch (s_from)
        {
            case "mm": m = from / 1000.0f; break;
            case "cm": m = from / 100.0f; break;
            case "m": m = from; break;
            case "km": m = from * 1000.0f; break;
        }

        switch (s_to)
        {
            case "mm": to = m * 1000.0f; break;
            case "cm": to = m * 100.0f; break;
            case "m": to = m; break;
            case "km": to = m / 1000.0f; break;
        }

        txt_to.setText(String.valueOf(to));

    }
}