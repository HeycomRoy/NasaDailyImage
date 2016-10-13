package ecs.vuw.ac.nz.webserviceapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ResponseActivity extends AppCompatActivity {
    private TextView outputMessage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        outputMessage = new TextView(this);
        final Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        setContentView(outputMessage);


        class SOAPOperation extends AsyncTask<Void, Void, Void> {

            private String responseMessage = null;  //for storing the response message from web services

            @Override
            protected Void doInBackground(Void... params) {
                //##Missing##
                //1. Create a SOAP Envelope using the org.ksoap2.serialization.SoapSerializationEnvelope class.
                //2. Set the request information for the SOAP envelope. The request information
                //   will be represented by an org.ksoap2.serialization.SoapObject object.
                //3. Specify details of the service request by using instances of
                //   the org.ksoap2.serialization.PropertyInfo class.
                //4. Create an HTTP transport request object to deliver the SOAP request
                //   (org.ksoap2.transport.HttpTransportSE).
                //5. Send the SOAP request over HTTP using the HTTP Transport and SOAP Envelope objects
                //   created earlier. This call is a synchronous call.
                //6. Process the web service response (or handle any unexpected errors).

                SoapObject request = new SoapObject("http://example/","convert");
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

//                PropertyInfo arg0 = new PropertyInfo();
//                arg0.setName("arg0");
//                arg0.setValue("nzd");
//                arg0.setType(String.class);
//                request.addProperty(arg0);
//
//                PropertyInfo arg1 = new PropertyInfo();
//                arg1.setName("arg1");
//                arg1.setValue("usd");
//                arg1.setType(String.class);
//                request.addProperty(arg1);

                PropertyInfo arg0 = new PropertyInfo();
                arg0.setName("arg0");
                arg0.setValue(1);
                arg0.setType(double.class);
                request.addProperty(arg0);

                envelope.setOutputSoapObject(request);

                HttpTransportSE ht = new HttpTransportSE("http://192.168.1.72:8080/MyWebService/WebServiceInterface?wsdl"); //Please note here: if your “url-forservice-wsdl”
//                starts with http://localhost:8080, please change
//                “localhost” to your IP address (use “ifconfig” to check).

                try {
                    ht.call("WebServiceInterfaceExample", envelope);
                    SoapPrimitive response = (SoapPrimitive)
                            envelope.getResponse();
                    // assign the response message to a pre-defined variable
                    //“responseMessage”
                } catch (Exception e) {
                    e.printStackTrace();
                }



                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                outputMessage.setText(responseMessage);
            }
        }

        new SOAPOperation().execute();


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}
