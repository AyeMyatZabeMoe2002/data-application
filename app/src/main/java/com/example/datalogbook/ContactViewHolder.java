package com.example.datalogbook;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
public class ContactViewHolder extends RecyclerView.ViewHolder {
    ImageView contactImageView;
    TextView contactName,contactDob,contactEmail;

    public ContactViewHolder(View itemView) {
        super(itemView);
        contactImageView = itemView.findViewById(R.id.contact_imageView);
        contactName      = itemView.findViewById(R.id.contact_name_view);
        contactDob       = itemView.findViewById(R.id.contact_dob_view);
        contactEmail     = itemView.findViewById(R.id.contact_email_view);

    }//end of contact view holder
}//enf of class
