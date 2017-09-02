package com.acadgild.assignment93;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //declaration

    ListView listView;
    Adapter adapter;
    int index=0;
    //Taling string of name and number
    private final static String name[]={"Bhawani","Neha","Ritika","Ganesh","Chandan","Vikash","Vishwas","Mithun","Barun","Sudha","Rajesh"};
    private final static String number[]={"6754389765","8975432189","8954762376","9865349654","9845063478","89855667432","9812546754",
            "9097534246","7589435686","8165890432","7954637892"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);
        adapter = new Adapter(this,name,number);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(this, "Long press to Call /SMS", Toast.LENGTH_SHORT).show();
        index=position;
    }

    @Override
    // creating context Menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // adding header in the menu
        menu.setHeaderTitle("Select the Action");
        // adding call and send sms action in the menu
        menu.add(0, 1, 0, "Call");
        menu.add(0, 2, 1, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Applying conditions for cal;l and sms
        try {
            //  call
            if(item.getItemId()==1 && item.getGroupId()==0){
                //here we are creating intent
                Intent i=new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+number[index]));
                startActivity(i);
            }
            // sms
            else if(item.getItemId()==2 && item.getGroupId()==0){
                //Creating  the intent to show number
                Intent i=new Intent();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ number[index])));
                //Starting the intent
                startActivity(i);
            }
            else{
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

