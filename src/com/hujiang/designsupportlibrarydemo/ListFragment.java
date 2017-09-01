package com.hujiang.designsupportlibrarydemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<MyBean> mlist=new ArrayList<MyBean>();
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.list_fragment, container, false);
        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(8);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(getActivity(),mlist));
    }

	private void initData(int count) {
		for(int i=0;i<count;i++){
			MyBean bean=new MyBean();
			bean.setTitle("��Ů"+i);
			bean.setTakes("��������"+10+i);
			bean.setContents("���£�����������������ģ���ұ�����٣������ʶ���ϴ����Ķ��䡭��");
			bean.setUpdate("05-20 ��������78��");
			mlist.add(bean);
		}
		
	}
}
