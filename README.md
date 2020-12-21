# 基于NotePad应用做功能扩展

### 一、NoteList中显示条目增加时间戳显示 

添加一个time属性用于显示时间戳。显示当前时间的主要代码：

```
 public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        return time;
    }
```

![0V72HS9Q_J69~QB_~FKV__K.png](https://i.loli.net/2020/12/21/4hZaFKmwGfWd9Y6.png)

### 二、添加笔记查询功能（根据标题查询）

在ActionBar新增一个搜索图标

![4Q7_Q1L4_QPILB9FLE_2_JX.png](https://i.loli.net/2020/12/21/9TZvj51ghexIrcU.png)

新建一个Search的Activity用于搜索，主要使用SearchView完成搜索

添加布局

```
<SearchView
    android:id="@+id/search_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:iconifiedByDefault="false"
    android:queryHint="搜索" />
<ListView
    android:id="@+id/list_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    />
```

Search主要代码为

```
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

```

给搜索图标添加点击跳转事件跳转到Search界面，进行搜索。

![_9WJBREB0B_KB0T_M_@I_B0.png](https://i.loli.net/2020/12/21/HiTqhx6QGCepNrJ.png)

### 三、附加功能

（1）统计当前笔记总条数

在activity_mian中增加TextView，用与显示笔记条数，在MainActivity中将TextView与当前笔记列表的长度绑定。

```
public void linkmanNum(){
    textNum.setText("("+list.size()+")");
}
```

![PIE__6ID@0`EK98D14`H682.png](https://i.loli.net/2020/12/21/fYJow7EVFzStyNO.png)

（2）界面美化

将原先的黑白界面改成主题色为#FF4081的玫红色，在AtionBar中嵌入新增、搜索、切换夜间模式的功能。主界面添加的FloatingActionButton便于新增。

actionbar中的布局放在menu文件中，在MainActivity进行配置显示。

<img src="https://i.loli.net/2020/12/21/4hZaFKmwGfWd9Y6.png" alt="0V72HS9Q_J69~QB_~FKV__K.png" style="zoom:50%;" /><img src="https://i.loli.net/2020/12/21/bLV48Pdtqn197mc.png" alt="TG4@_U_A`HP_64Q_7MAH_H7.png" style="zoom:50%;" /><img src="https://i.loli.net/2020/12/21/cLr42WFpbRMGOK7.png" alt="MPAYVEKZ14_YCOGF_FZ2UHV.png" style="zoom:50%;" /><img src="https://i.loli.net/2020/12/21/gYfkNLC6y2cv7Ur.png" alt="2_JSCQS5QM__6X_Y`9_Z6NL.png" style="zoom:50%;" />

（3）改变记事本主题，日间模式和夜间模式切换。

新增一个change的Activity和一个app的类，用于切换夜间模式。

新增一个value-night文件夹，复制原来value中的colors.xml，设置夜间模式用的颜色,在change的Activity里配置切换日夜间模式，app类用来记录切换状态，方便更改模式。

备注：该功能不稳定，还需要完善

<img src="https://i.loli.net/2020/12/21/ZNr5mR3gQb4s9th.png" alt="OYF7536JOQ_WBK0_EDU8_~G.png" style="zoom:50%;" /><img src="https://i.loli.net/2020/12/21/lKafs24GxtJRFLP.png" alt="UI9_4Z@EKT@M83SS~__PV_4.png" style="zoom:50%;" />



源码：https://github.com/se-lqt/NoteBook

小结：该项目完成一些基础功能，还有许多地方可以完善，后续改进。
