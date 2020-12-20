package com.example.notebook;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notebook.dbutil.DatabaseUtil;

public class Search extends AppCompatActivity {
    private SearchView mSearchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_search);

        mSearchBar = (SearchView) findViewById(R.id.search_view);
       // DataBase mDataBase = new DataBase(this, "wy.db", null, 1);
        DatabaseUtil du= new DatabaseUtil(this);
        SQLiteDatabase mDataBase = du.getWritableDatabase();



        Cursor mCursor = mDataBase.rawQuery("select * from UserInfo",null);
//        SimpleCursorAdapter mSimpleCursorAdapter= new SimpleCursorAdapter(this,R.layout.activity_note_search,mCursor,new String[]{"title"},new int[]{R.id,R.id.item_phone});
//        mSearchBar.setSuggestionsAdapter(mSimpleCursorAdapter);
        SimpleCursorAdapter mSimpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item2,mCursor, new String[]{"userName","userPhone"}, new int[]{R.id.item_name,R.id.item_phone});
        mSearchBar.setSuggestionsAdapter(mSimpleCursorAdapter);
        mSearchBar.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(final int mI) {
                return false;
            }

            @Override

            public boolean onSuggestionClick(final int mI) {
//                点击提示条目获取条目的位置
                Toast.makeText(Search.this, mI+"", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String mS) {
//                点击软键盘搜索按钮，自动获取edittext的内容进行搜索
                Toast.makeText(Search.this, mS, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(final String mS) {
                return false;
            }
        });


    }
}
