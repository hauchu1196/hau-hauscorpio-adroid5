package com.example.hau.nodelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NodeListActivity extends AppCompatActivity {

    private static final String TAG = NodeListActivity.class.toString();
    private ListView lvTool;
    private Button btnAdd;

    private static final String[] TITLE = new String[]{" Tool", " Activity", " View"};
    public static ArrayList<String> titleArrayList = new ArrayList<>(Arrays.asList(TITLE));
    private static final String[] CONTENT = new String[]{" Android studio",
            " life cycle",
            " Layout\n TextView\n Button\n Edittext\n ListView"};
    public static ArrayList<String> contentArrayList = new ArrayList<>(Arrays.asList(CONTENT));
    private ArrayAdapter<String> noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_list);
        getReferences();
        setupUIProperties();
        addListeners();
    }

    private void addListeners() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NodeListActivity.this, NodeDetailActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick");
            }
        });

        lvTool.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                titleArrayList.remove(position);
                contentArrayList.remove(position);
                Intent intent = new Intent(NodeListActivity.this, NodeDetailActivity.class);
                intent.putExtra(NodeDetailActivity.INDEX_LONG_CLICK, position);
                noteAdapter.notifyDataSetChanged();
                return true;
            }
        });

        lvTool.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NodeListActivity.this, NodeDetailActivity.class);
                intent.putExtra(NodeDetailActivity.INDEX_CLICK, position);
                startActivity(intent);
            }
        });
    }

    private void setupUIProperties() {

    }

    private void getReferences() {
        lvTool = (ListView) findViewById(R.id.lv_tool);
        if (noteAdapter == null) {
            noteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleArrayList);
            lvTool.setAdapter(noteAdapter);
        }
        btnAdd = (Button) findViewById(R.id.btn_add);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }
}
