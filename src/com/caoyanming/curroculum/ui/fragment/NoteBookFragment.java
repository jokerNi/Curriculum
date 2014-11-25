package com.caoyanming.curroculum.ui.fragment;


import so.cym.swipemenulistview.SwipeMenu;
import so.cym.swipemenulistview.SwipeMenuCreator;
import so.cym.swipemenulistview.SwipeMenuItem;
import so.cym.swipemenulistview.SwipeMenuListView;
import so.cym.swipemenulistview.SwipeMenuListView.OnMenuItemClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.caoyanming.curriculum.R;
import com.caoyanming.curroculum.adapter.CommonAdapter;
import com.caoyanming.curroculum.adapter.ViewHolder;
import com.caoyanming.curroculum.data.DataManager;
import com.caoyanming.curroculum.data.bean.Notebook;
import com.caoyanming.curroculum.ui.activity.MainActivity;

public class NoteBookFragment extends BaseFragment {

	private LinearLayout layout;
	private SwipeMenuListView notebookListView;
	private Button newNotebook;
	private MainActivity mainActivity;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		layout = (LinearLayout) inflater.inflate(R.layout.notebook_layout, container, false);
		mainActivity = (MainActivity) getActivity();
		notebookListView = (SwipeMenuListView) layout.findViewById(R.id.notebook_List);

		notebookListView.setAdapter(new CommonAdapter<Notebook>(mainActivity, DataManager.getDataManager(mainActivity).getAllNotebook(), R.layout.notebook_list_item) {

			@Override
			public void convert(ViewHolder helper, Notebook item) {
				helper.setText(R.id.notebook_item_title, item.getTitle());  
				helper.setText(R.id.notebook_item_date, item.getDate());  
			}
		});
		SwipeMenuCreator creator = new SwipeMenuCreator() {

			@Override
			public void create(SwipeMenu menu) {
				// create "open" item
				SwipeMenuItem collection = new SwipeMenuItem(
						mainActivity);
				// set item background
				collection.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
						0xCE)));
				// set item width
				collection.setWidth(dp2px(90));
				// set item title
				collection.setTitle("取消");
				// set item title fontsize
				collection.setTitleSize(18);
				// set item title font color
				collection.setTitleColor(Color.WHITE);
				// add to menu
				menu.addMenuItem(collection);
				// create "delete" item
				SwipeMenuItem share = new SwipeMenuItem(
						mainActivity);
				// set item background
				share.setBackground(new ColorDrawable(Color.rgb(0xFF,
						0x30, 0x30)));
				// set item width
				share.setWidth(dp2px(90));
				// set a icon
				share.setTitle("删除");
				share.setTitleSize(18);

				share.setTitleColor(Color.WHITE);

				// add to menu
				menu.addMenuItem(share);
			}
		};

		// set creator
		notebookListView.setMenuCreator(creator);

		notebookListView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public void onMenuItemClick(final int position, SwipeMenu menu, int index) {
				switch (index) {
				case 0:
					break;
				case 1:
					break;
				}
			}
		});

		notebookListView.setOnItemClickListener(new ItemClick());
		return layout;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		showUpdate();
	}

	public void showUpdate() {


	}

	class ItemClick implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> paramAdapterView,
				View paramView, int paramInt, long paramLong) {

		}

	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getResources().getDisplayMetrics());
	}
}