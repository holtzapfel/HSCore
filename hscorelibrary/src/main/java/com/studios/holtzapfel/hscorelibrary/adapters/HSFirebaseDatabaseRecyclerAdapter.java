package com.studios.holtzapfel.hscorelibrary.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by holtzapfel on 12/2/17.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class HSFirebaseDatabaseRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements ChildEventListener {

    private static final String TAG = "FirebaseDatabaseAdapter";

    private DatabaseReference mReference;
    private List<DataSnapshot> mSnapshots = new ArrayList<>();
    boolean isInsertAtZero = false;

    public HSFirebaseDatabaseRecyclerAdapter(DatabaseReference reference){
        mReference = reference;
    }

    public HSFirebaseDatabaseRecyclerAdapter withInsertNewObjectsAtZero(boolean isInsertAtZero){
        this.isInsertAtZero = isInsertAtZero;
        return this;
    }

    public void startListening(){
        if (mReference != null) {
            mReference.addChildEventListener(this);
        }
    }

    public void stopListening(){
        if (mReference != null){
            mReference.removeEventListener(this);
        }

        mSnapshots.clear();
        notifyDataSetChanged();
    }

    public void setReference(DatabaseReference reference){
        stopListening();
        mReference = reference;
        startListening();
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        for (int x = 0; x < mSnapshots.size(); x++){
            if (mSnapshots.get(x).getKey().equals(dataSnapshot.getKey())){
                return;
            }
        }
        int x = onDetermineLocationToInsert();
        mSnapshots.add(x, dataSnapshot);
        notifyItemInserted(x);
        onDataChanged();
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        for (int x = 0; x < mSnapshots.size(); x++){
            if (mSnapshots.get(x).getKey().equals(dataSnapshot.getKey())){
                mSnapshots.remove(x);
                mSnapshots.add(x, dataSnapshot);
                notifyItemChanged(x);
                onDataChanged();
            }
        }
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        for (int x = 0; x < mSnapshots.size(); x++){
            if (mSnapshots.get(x).getKey().equals(dataSnapshot.getKey())){
                mSnapshots.remove(x);
                notifyItemRemoved(x);
                onDataChanged();
            }
        }
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        onDataChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG, "onCancelled: " + databaseError.getDetails());
    }

    @Override
    public int getItemCount() {
        return mSnapshots.size();
    }

    public DataSnapshot getSnapshot(int index){
        return mSnapshots.get(index);
    }

    public void onDataChanged(){

    }

    public int onDetermineLocationToInsert(){
        if (isInsertAtZero) return 0;
        return mSnapshots.size();
    }
}
