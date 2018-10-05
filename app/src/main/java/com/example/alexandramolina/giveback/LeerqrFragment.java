package com.example.alexandramolina.giveback;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class LeerqrFragment extends Fragment {
    Button btn_scan, btn_contacto;
    TextView txt, txt1, txt2, txt3;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =inflater.inflate(R.layout.fragment_leerqr, container, false);
        btn_scan = v.findViewById(R.id.button);
        btn_contacto = v.findViewById(R.id.button2);

        final Fragment fragment = this;

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(fragment.getActivity());
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        btn_contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Información del dueño:");
                builder.setMessage("Nombre: María Vargas - Correo: mari_v@gmail.com - Número: 8889 8879");
                builder.create().show();
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(getActivity(),"Scanneo cancelado",Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(getActivity(),result.getContents(),Toast.LENGTH_SHORT).show();
            }

        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
