package com.example.datalogbook;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
public class ContactListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    int[] images = {R.drawable.people1,R.drawable.people2,R.drawable.people3,R.drawable.people4,R.drawable.people5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        recyclerView = findViewById(R.id.contact_recycler_view);

        databaseHelper = new DatabaseHelper(this);

        ArrayList<Contact> contactArrayList = databaseHelper.getAllContacts();

        ArrayList<Contact> contactWithImages = new ArrayList<>();

        /* add images */

        int j=0;
        for(int i=0;i<contactArrayList.size();i++)
        {
            if(j==images.length)j=0;
            Contact c = contactArrayList.get(i);
            c.setImageID(images[j]);
            j++;
            contactWithImages.add(c);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        ContactViewAdapter adapter = new ContactViewAdapter(this,contactArrayList);
        recyclerView.setAdapter(adapter);

    }//end of onCreate
}//end of on class