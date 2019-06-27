package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSearch;
import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.DirectSearch;
import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.SearchFactory;
import net.lzzy.algorithm.algorlib.SortFactory;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spinner,spinner_search;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        linearLayout=findViewById(R.id.ll);
        spinner=findViewById(R.id.Sp);
        spinner_search=findViewById(R.id.Sp1);
        setSpinner();
        findViewById(R.id.activity_main_btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSearch();
            }
        });
        resetSearch();
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BaseSearch<Integer> search =
                    SearchFactory.getInSearch(spinner_search.getSelectedItemPosition(),items);
            if (search!=null){
                int pos=search.search(v.getId());
                tvResult.setText("该元素位于数组的第".concat((pos+1)+"位"));
            }
        }
    };


    private void resetSearch(){
        generateItems();
        tvResult.callOnClick();
        for (Integer i:items){
            Button btn=new Button(this);
            btn.setText(String.format(i.toString(), Locale.CHINA));
            btn.setId(i);
            btn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
            btn.setOnClickListener(listener);


        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                //directSort();
                //insertSort();
                BaseSort<Integer> way = SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer> sortNotNull= Objects.requireNonNull(way);
                sortNotNull.getDuration();
                String result=way.getResult();
                tvResult.setText(result);
                //displayItems(tvResult);
                Toast.makeText(this, "时间间隔"+way.getDuration()+
                                "\n比较次数"+way.getCompareCount()+
                                "\n移动次数"+way.getMovie()+"\n交换次数"+way.getSwapMovie()
                        , Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现
        for(int b=0;b<items.length;b++){
            for (int c=b+1;c<items.length;c++){
                if (items[b] > items[c]) {
                    int temp=items[b];
                    items[b]=items[c];
                    items[c]=temp;
                }
            }

        }

    }

    private void insertSort(){
        for(int i=1;i<items.length;i++){
            int j=i-1;
            if (items[j].compareTo(items[i])<0) {
                continue;
            }
            Integer num=items[i];
            while (j>=0&&items[j].compareTo(num)>0){
                items[j+1]=items[j];
                j--;
        }items[j+1]=num;

        }
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }

    private void setSpinner() {
        String[] names={"插入排序","选择排序","希尔排序","冒泡排序"};
        String[] name2={"顺序查找","二分查找","二叉排序树"};
        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,SortFactory.getSortName()));
        spinner_search.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, SearchFactory.getSearchName()));

    }


}
