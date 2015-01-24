package com.mycity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akhil Bhai on 1/21/2015.
 */
public class Home extends Fragment {

    List<RowItem> mListItem;

    public static Home getInstance(){
        Home myFragment=new Home();
        return myFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.activity_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListItem = new ArrayList<RowItem>();
        String title[] = {"Hanamkonda","Thousand Pillar","Warangal Fort","Ramapa Temple","Badrakali Temple"};
        int icons[] = {R.drawable.hanumakonda_b,R.drawable.thousand_pillar,R.drawable.warangalfortb,R.drawable.ramapa_banner,R.drawable.badrakali_banner};
        for(int i=0; i<title.length; i++){
            RowItem ri = new RowItem();
            ri.setIcon(icons[i]);
            ri.setTitle(title[i]);
            mListItem.add(ri);
        }
        LazyAdapter adapter = new LazyAdapter(getActivity(),R.layout.list_item_2, mListItem);
        ListView listView = (ListView)getActivity().findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),Desciption.class);
                startActivity(i);
//                finish();
            }
        });
    }

    public class LazyAdapter extends ArrayAdapter<RowItem> {

        Context context;
        public LazyAdapter(Context context, int resourceId,
                           List<RowItem> items) {
            super(context, resourceId, items);
            this.context = context;
        }
        private class ViewHolder {
            ImageView iv1;
            TextView txtTitle;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            RowItem rowItem = getItem(position);
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
//            Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item_2, null);
                holder = new ViewHolder();
                holder.txtTitle = (TextView) convertView.findViewById(R.id.title1);
                holder.iv1 = (ImageView) convertView.findViewById(R.id.icon1);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();
            holder.txtTitle.setText(rowItem.getTitle());
//            holder.txtTitle.setTypeface(tf);
            holder.iv1.setImageResource(rowItem.getIcon());
            return convertView;
        }
    }

}
