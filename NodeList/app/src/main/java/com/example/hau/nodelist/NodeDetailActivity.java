package com.example.hau.nodelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class NodeDetailActivity extends AppCompatActivity {

    public static final String INDEX_CLICK = "IndexClick";
    public static String INDEX_LONG_CLICK = "IndexLongClick";
    private EditText etTitle;
    private EditText etContent;
    private Button btnSave;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_detail);
        getReferences();
        addListeners();
    }

    private void addListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTitle.getText().length() > 0) {
                    if (index != -1) {
                        NodeListActivity.titleArrayList.set(index, " " + etTitle.getText().toString());
                        NodeListActivity.contentArrayList.set(index, etContent.getText().toString());
                    } else {
                        NodeListActivity.titleArrayList.add(" " + etTitle.getText().toString());
                        NodeListActivity.contentArrayList.add(etContent.getText().toString());
                    }
                }
                finish();
            }
        });
    }

    private void getReferences() {
        etTitle = (EditText) findViewById(R.id.et_title);
        etContent = (EditText) findViewById(R.id.et_content);
        btnSave = (Button) findViewById(R.id.btn_save);
        Intent intent = getIntent();
        index = intent.getIntExtra("IndexClick", -1);
        if (index != -1) {
            etTitle.setText(NodeListActivity.titleArrayList.get(index));
            etContent.setText(NodeListActivity.contentArrayList.get(index));
        }
    }


}
