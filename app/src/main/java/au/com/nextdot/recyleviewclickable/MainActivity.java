package au.com.nextdot.recyleviewclickable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


/*
    use linear layout and card for clickable
    use relative for just recyclerview
*/

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] head,body;
    int[] image={R.drawable.a,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.j,R.drawable.ji,
    R.drawable.pic};
    ArrayList<Data>arrayList=new ArrayList<Data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        head= getResources().getStringArray(R.array.name);
        body=getResources().getStringArray(R.array.description);



        for(int i=0;i<8;i++)
        {
                Data data=new Data(image[i],head[i],body[i]);
                arrayList.add(data);
        }
        adapter =new RecycleAdapter(arrayList,this);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
