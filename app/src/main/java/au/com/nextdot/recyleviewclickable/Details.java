package au.com.nextdot.recyleviewclickable;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Details extends AppCompatActivity {

    private ImageView img;
    private TextView name,details;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img=(ImageView)findViewById(R.id.image);
        name=(TextView)findViewById(R.id.text1);
        details=(TextView)findViewById(R.id.text2);

        img.setImageResource(getIntent().getIntExtra("image",0));
        name.setText(getIntent().getStringExtra("head"));
        details.setText(getIntent().getStringExtra("body"));


        //for starting another app
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                //Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                Uri num=Uri.parse("tel:01671148461");
                Intent intent=new Intent(Intent.ACTION_DIAL,num);

                // Verify it resolves
               /* PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(chooser);
                }
                */
                //chooser
                String title="Share";
                Intent chooser = Intent.createChooser(intent,title);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });
    }
}
