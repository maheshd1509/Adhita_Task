package in.mahesh.adhita_task;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mahesh on 6/11/17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Country> mCountryList;

    public CountryAdapter(Context mContext, ArrayList<Country> mCountryList) {
        this.mContext = mContext;
        this.mCountryList = mCountryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_adpater,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTxtCountryName.setText("Country :" + mCountryList.get(position).getmCountry());
        holder.mTxtCityName.setText("City :" + mCountryList.get(position).getmName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity mainActivity= (MainActivity) v.getContext();
                FragmentDetails fragmentDetails=new FragmentDetails();
                Bundle bundle=new Bundle();
                bundle.putSerializable("Data",mCountryList.get(position));
                fragmentDetails.setArguments(bundle);
                mainActivity.getSupportFragmentManager().beginTransaction().add(R.id.Container,fragmentDetails).addToBackStack("").commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtCountryName,mTxtCityName;
        public ViewHolder(View view) {
            super(view);

            mTxtCountryName= (TextView) view.findViewById(R.id.txtCountryName);
            mTxtCityName= (TextView) view.findViewById(R.id.txtCityName);


        }


    }
}
