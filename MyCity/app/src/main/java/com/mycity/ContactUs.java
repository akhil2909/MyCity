package com.mycity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Akhil Bhai on 1/10/2015.
 */
public class ContactUs extends Fragment {

    EditText mailTo,subject,mailMsg;
    Button send,cancel;
    ConnectionDetector cd;
    GPSTracker gps;

    public static ContactUs getInstance(){
        ContactUs contactUs = new ContactUs();
        return  contactUs;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.contact,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
           ((ImageView)getActivity().findViewById(R.id.msg)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popMail("naveen.nani001@gmail.com");
            }
        });

        ((ImageView)getActivity().findViewById(R.id.map_img)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(getActivity());
                if (gps.canGetLocation()) {
                    if (gps.getLatitude() != 0 && gps.getLongitude() != 0) {
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://maps.google.com/maps?f=d&saddr=" + gps.getLatitude() + "," + gps.getLongitude() + "&daddr=17.956122,79.614705"));
                        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(mapIntent);
                    } else {
                        Toast.makeText(getActivity(), "Unable to find ur Location. Please Try Again !", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ((ImageView)getActivity().findViewById(R.id.call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getActivity(),"Call",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void popMail(String mailadrs){

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.emal);
        dialog.setTitle("Feedback");
        mailTo = (EditText)dialog.findViewById(R.id.editTextTo);
        subject = (EditText)dialog.findViewById(R.id.editsubject);
        mailMsg = (EditText)dialog.findViewById(R.id.editTextMessage);
        send = (Button)dialog.findViewById(R.id.send_email);
        cancel = (Button)dialog.findViewById(R.id.send_cancel);
        mailTo.setText(mailadrs);
        //Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AftaSerif.ttf");
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // TODO Auto-generated method stub
                String to = mailTo.getText().toString();
                String msg = mailMsg.getText().toString();
                String sub = subject.getText().toString();
                String[] recipients = {to};
                Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, recipients);
                email.putExtra(Intent.EXTRA_SUBJECT, "App Feedback");
                email.putExtra(Intent.EXTRA_TEXT, msg);
                //need this to prompts email client only
                email.setType("message/rfc822");
                try {
                    // the user can choose the email client
                    startActivity(Intent.createChooser(email, "Choose an email client from..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "No email client installed.",
                            Toast.LENGTH_LONG).show();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
