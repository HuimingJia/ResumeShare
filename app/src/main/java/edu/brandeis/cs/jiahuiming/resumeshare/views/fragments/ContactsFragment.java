package edu.brandeis.cs.jiahuiming.resumeshare.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.brandeis.cs.jiahuiming.resumeshare.R;
import edu.brandeis.cs.jiahuiming.resumeshare.adapters.ContactsAdapter;
import edu.brandeis.cs.jiahuiming.resumeshare.beans.ContactList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {


        View mFragment = inflater.inflate(R.layout.fragment_contact, container, false);
        //mWaveView = (WaveView)mFragment.findViewById(R.id.waveview);
        List<ContactList> item_ContactList=new ArrayList<>();
        for(int i = 0; i < 20 ; i++){
            if(i%2==0){
                item_ContactList.add(new ContactList(R.mipmap.ic_launcher,"Kate Spade","xxxx.@brandeis.edu","123.pdf","www.linkedin.com"));
            }else{
                item_ContactList.add(new ContactList(R.mipmap.ic_launcher,"Hao Wang","xxxx.@gmail.com","123.pdf","www.linkedin.com"));
            }

            //ContactList(int imageId,String name,String account,String resume,String linkedin)


        }
        ListView listView=(ListView)mFragment.findViewById(R.id.listView);
        listView.setAdapter(new ContactsAdapter(getActivity(),item_ContactList));

        return mFragment;
    }


}
