package com.example.hau.hw17_bai2.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hau.hw17_bai2.models.Node;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hau on 29/10/2016.
 */
public class DbHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "node.db";
    private static final int DATABASE_VERSION = 1;

    /*=========================== Node ===========================*/
    private static final String NODE_TABLE_NAME = "tbl_node";
    private static final String NODE_COLUMN_ID = "id";
    private static final String NODE_COLUMN_TITLE = "title";
    private static final String NODE_COLUMN_CONTENT = "content";
    private static final String NODE_COLUMN_TIME_CREATED = "time_created";
    private static final String[] NODE_COLUMNS = new String[] {
            NODE_COLUMN_ID,
            NODE_COLUMN_TITLE,
            NODE_COLUMN_CONTENT,
            NODE_COLUMN_TIME_CREATED
    };

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insert(Node node) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NODE_COLUMN_TITLE, node.getTitle());
        contentValues.put(NODE_COLUMN_CONTENT, node.getContent());
        contentValues.put(NODE_COLUMN_TIME_CREATED, node.getTimeCreated());
        long id = db.insert(NODE_TABLE_NAME, null, contentValues);
        node.setId((int) id);
        db.close();
    }

    public void update(Node node) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NODE_COLUMN_TITLE, node.getTitle());
        values.put(NODE_COLUMN_CONTENT, node.getContent());
        values.put(NODE_COLUMN_TIME_CREATED, node.getTimeCreated());
        db.update(NODE_TABLE_NAME, values, NODE_COLUMN_ID + "=" + node.getId(), null);
        db.close();
    }

    public Node selectRandomNode() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NODE_TABLE_NAME, NODE_COLUMNS,
                null,
                null,
                null,
                null,
                "RANDOM()",
                "1");
        if (cursor.moveToNext()) {
            return createNode(cursor);
        }
        db.close();
        return null;
    }

    public List<Node> selectAllNode() {
        List<Node> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NODE_TABLE_NAME, NODE_COLUMNS,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            list.add(createNode(cursor));
        }
        cursor.close();
        db.close();
        return list;
    }

    private Node createNode(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(NODE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(NODE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(NODE_COLUMN_CONTENT));
        String timeCreated = cursor.getString(cursor.getColumnIndex(NODE_COLUMN_TIME_CREATED));
        Node node = new Node(id, title, content, timeCreated);
        return node;
    }

    public void delete(Node node) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(NODE_TABLE_NAME, NODE_COLUMN_ID + "=" + node.getId(), null);
        db.close();
    }

    /*=========================== Singleton ===========================*/
    private static DbHelper instance = null;

    public static DbHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbHelper(context);
    }


}
