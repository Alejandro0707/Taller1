package com.example.android.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText cajaCantidad;
    private TextView cajaResultado, cajaUnitario;
    private Spinner comboGenero, comboTipoC, comboMarca;
    private String[] opc_sexo, opc_tipo, opc_marca;
    private ArrayAdapter adapter_g, adapter_t, adapter_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaCantidad = (EditText)findViewById(R.id.txtcantidad);
        cajaResultado = (TextView)findViewById(R.id.txtResultado);
        cajaUnitario = (TextView)findViewById(R.id.txtUnitario);
        comboGenero = (Spinner)findViewById(R.id.cmbSexo);
        comboTipoC = (Spinner)findViewById(R.id.cmbTipoZapato);
        comboMarca = (Spinner)findViewById(R.id.cmbMarca);

        opc_sexo = this.getResources().getStringArray(R.array.opc_sexo);
        opc_tipo = this.getResources().getStringArray(R.array.opc_tipo);
        opc_marca = this.getResources().getStringArray(R.array.opc_marca);
        adapter_g = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opc_sexo);
        adapter_t = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opc_tipo);
        adapter_m = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opc_marca);

        comboGenero.setAdapter(adapter_g);
        comboTipoC.setAdapter(adapter_t);
        comboMarca.setAdapter(adapter_m);
    }

    public void calcular (View v) {
        int op_g, op_t, op_m;
        float cant, res = 0;

        if (validar()) {
            cant = Float.parseFloat(cajaCantidad.getText().toString());
            op_g = comboGenero.getSelectedItemPosition();
            op_t = comboTipoC.getSelectedItemPosition();
            op_m = comboMarca.getSelectedItemPosition();

            switch (op_g) {
                case 0:
                    switch (op_t) {
                        case 0:
                            switch (op_m) {
                                case 0:
                                    res = 120000 * cant;
                                    break;
                                case 1:
                                    res = 140000 * cant;
                                    break;
                                case 2:
                                    res = 130000 * cant;
                            }
                            break;
                        case 1:
                            switch (op_m) {
                                case 0:
                                    res = 50000 * cant;
                                    break;
                                case 1:
                                    res = 80000 * cant;
                                    break;
                                case 2:
                                    res = 100000 * cant;
                            }
                            break;
                    }
                    break;
                case 1:
                    switch (op_t) {
                        case 0:
                            switch (op_m) {
                                case 0:
                                    res = 100000 * cant;
                                    break;
                                case 1:
                                    res = 130000 * cant;
                                    break;
                                case 2:
                                    res = 110000 * cant;
                            }
                            break;
                        case 1:
                            switch (op_m) {
                                case 0:
                                    res = 60000 * cant;
                                    break;
                                case 1:
                                    res = 70000 * cant;
                                    break;
                                case 2:
                                    res = 120000 * cant;
                            }
                            break;
                    }
                    break;
            }

            cajaUnitario.setText("$ " + res / cant);
            cajaResultado.setText("$ " + res);
        }
    }

    public void borrar(View v){
        cajaCantidad.setText("");
        cajaCantidad.requestFocus();
        cajaResultado.setText("");
        cajaUnitario.setText("");
    }

    public boolean validar(){
        if(cajaCantidad.getText().toString().isEmpty()){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_cant));
            return false;
        }
        if(Integer.parseInt(cajaCantidad.getText().toString())==0){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_cant_cero));
            return false;
        }
        return true;
    }

}
