package edu.brandeis.cs.jiahuiming.resumeshare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.brandeis.cs.jiahuiming.resumeshare.R;
import edu.brandeis.cs.jiahuiming.resumeshare.beans.ContactList;

/**
 * Created by jiahuiming on 10/25/16.
 */
public class ContactsAdapter extends BaseAdapter {

    private List<ContactList> mList;
    private LayoutInflater mInflater;

    public ContactsAdapter(Context context, List<ContactList> list){
        mList=list;
        mInflater=LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.fragment_contact_item,null);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.tv_image);
            viewHolder.name=(TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.account=(TextView)convertView.findViewById(R.id.tv_account);
            convertView.setTag(viewHolder);
        }else{

            viewHolder=(ViewHolder) convertView.getTag();

        }
        ContactList bean=mList.get(position);
        viewHolder.imageView.setImageResource(bean.getImageId());
        viewHolder.name.setText(bean.getName());
        viewHolder.account.setText(bean.getAccount());


        return convertView;



    }
    //ContactList(int imageId,String name,String account,String resume,String linkedin)

    class ViewHolder{
        public ImageView imageView;
        public TextView name;
        public TextView account;

    }

}
