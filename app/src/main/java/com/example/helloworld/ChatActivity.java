package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<Msg>();
    private RecyclerView recycler_view_chat;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initMsg();
        recycler_view_chat = (RecyclerView) findViewById(R.id.recycler_view_chat);
        final EditText editText = (EditText) findViewById(R.id.et_content);
        Button button = (Button) findViewById(R.id.btn_send);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_view_chat.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        recycler_view_chat.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText.getText().toString();
                if (content != null) {
                    Msg msg = new Msg(content, Msg.send);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    recycler_view_chat.scrollToPosition(msgList.size()-1);
                    editText.setText("");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg = new Msg("那个他，你在哪", Msg.received);
        msgList.add(msg);
        Msg msg1 = new Msg("嘿嘿，我在这", Msg.send);
        msgList.add(msg1);
        Msg msg2 = new Msg("我等你很久了", Msg.received);
        msgList.add(msg2);

    }

    public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

        private List<Msg> mMsgList;

        class ViewHolder extends RecyclerView.ViewHolder {

            LinearLayout llLeft;
            LinearLayout ll_right;
            TextView tv_left_content;
            TextView tv_right_content;

            public ViewHolder(View itemView) {
                super(itemView);
                llLeft = (LinearLayout) itemView.findViewById(R.id.ll_left);
                ll_right = (LinearLayout) itemView.findViewById(R.id.ll_right);
                tv_left_content = (TextView) itemView.findViewById(R.id.tv_left_content);
                tv_right_content = (TextView) itemView.findViewById(R.id.tv_right_content);
            }
        }

        public MsgAdapter(List<Msg> msgList){
            mMsgList = msgList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
            Msg msg = mMsgList.get(position);
            if (msg.getFlag() == Msg.received) {
                holder.llLeft.setVisibility(View.VISIBLE);
                holder.ll_right.setVisibility(View.GONE);
                holder.tv_left_content.setText(msg.getContent().toString());
            } else {
                holder.llLeft.setVisibility(View.GONE);
                holder.ll_right.setVisibility(View.VISIBLE);
                holder.tv_right_content.setText(msg.getContent()+"");
            }
        }

        @Override
        public int getItemCount() {
            return mMsgList.size();
        }
    }
}
