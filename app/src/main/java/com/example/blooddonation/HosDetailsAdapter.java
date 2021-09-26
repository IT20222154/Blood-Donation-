package com.example.blooddonation;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class HosDetailsAdapter extends FirebaseRecyclerAdapter<ModelHosDetails,HosDetailsAdapter.myviewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HosDetailsAdapter(@NonNull FirebaseRecyclerOptions<ModelHosDetails> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull ModelHosDetails model) {


        holder.hosID.setText(model.getHosId());
        holder.hoslocation.setText(model.getHosLocation());
        holder.hosemail.setText(model.getHosemail());
        holder.hoscontact.setText(model.getHosContactNo());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.hosID.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1250)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();


                EditText hosID = view.findViewById(R.id.txthosId);
                EditText hoslocation = view.findViewById(R.id.txtLocation);
                EditText hosemail = view.findViewById(R.id.txtEmail);
                EditText hoscontact = view.findViewById(R.id.txtContact);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                hosID.setText(model.getHosId());
                hoslocation.setText(model.getHosLocation());
                hosemail.setText(model.getHosemail());
                hoscontact.setText(model.getHosContactNo());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object>map = new HashMap<>();

                        map.put("hosId",hosID.getText().toString());
                        map.put("hosLocation",hoslocation.getText().toString());
                        map.put("hosContactNo",hoscontact.getText().toString());
                        map.put("hosemail",hosemail.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Hospitals")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.hosID.getContext(), "Updated Successfully.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();//close popup after updating
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.hosID.getContext(), "Error while Updating.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });



            }
        });


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.hosID.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseDatabase.getInstance().getReference().child("Hospitals")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.hosID.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hos_details_item,parent,false);
        return new myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder {

        TextView hosID,hoslocation,hoscontact,hosemail;

        Button btnEdit,btnDelete;

        public myviewHolder(@Nullable View itemView){
            super(itemView);

           hosID = (TextView)itemView.findViewById(R.id.hosID);
           hoslocation = (TextView)itemView.findViewById(R.id.hosLocation);
           hoscontact = (TextView)itemView.findViewById(R.id.hosContact);
           hosemail = (TextView)itemView.findViewById(R.id.hosEmail);

           btnEdit= (Button) itemView.findViewById(R.id.btnEdit);
           btnDelete = (Button) itemView.findViewById(R.id.btnDelete);




        }
    }

}


