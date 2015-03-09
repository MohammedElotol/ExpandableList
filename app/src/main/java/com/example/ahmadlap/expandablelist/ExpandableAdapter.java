package com.example.ahmadlap.expandablelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahmad lap on 3/6/2015.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    List<String> listHeaders;
    HashMap<String, List<String>> listChildren;
    int groupLayoutId, childLayoutId;

    public ExpandableAdapter(Context context, List<String> listHeaders, HashMap<String, List<String>> listChildren, int groupLayoutId, int childLayoutId) {
        this.context = context;
        this.listHeaders = listHeaders;
        this.listChildren = listChildren;
        this.groupLayoutId = groupLayoutId;
        this.childLayoutId = childLayoutId;
    }
    @Override
    public int getGroupCount() {
        return this.listHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listChildren.get(this.listHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listChildren.get(this.listHeaders.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(groupLayoutId, null);

            holder = new ViewHolder();
            holder.holdedTextView= (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.holdedTextView.setText(listHeaders.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(childLayoutId, null);

            holder = new ViewHolder();
            holder.holdedTextView= (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.holdedTextView.setText((String) getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ViewHolder{
        TextView holdedTextView;
    }
}
