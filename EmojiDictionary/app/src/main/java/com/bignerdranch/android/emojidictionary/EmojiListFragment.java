package com.bignerdranch.android.emojidictionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EmojiListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private EmojiAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_emoji, container, false);
        mRecyclerView = view.findViewById(R.id.emoji_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private class EmojiAdapter extends RecyclerView.Adapter<EmojiHolder> {
        private List<Emoji> mEmojiList;

        public EmojiAdapter(List<Emoji> list) {
            mEmojiList = list;
        }

        @NonNull
        @Override
        public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new EmojiHolder(layoutInflater, parent);
        }

        @Override
        public int getItemCount() {
            return mEmojiList.size();
        }

        @Override
        public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
            Emoji emoji = mEmojiList.get(position);
            holder.bind(emoji);

        }
    }

    private class EmojiHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        private TextView mEmojiName;
        private TextView mEmojiDescription;
        private Emoji mEmoji;

        public EmojiHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_emoji, parent, false));

            mEmojiName = itemView.findViewById(R.id.emoji_name);
            mEmojiDescription = itemView.findViewById(R.id.emoji_description);
        }

        public void  bind(Emoji emoji) {
            mEmoji = emoji;

            mEmojiName.setText(mEmoji.getSymbol() + " - " + mEmoji.getName());
            mEmojiDescription.setText(mEmoji.getDescription());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = EmojiActivity.newIntent(getActivity(),mEmoji.getSymbol());
            startActivity(intent);
        }
    }

    private void updateUI() {
        DataController dataController = DataController.getDataConroller();
        List<Emoji> emojis = dataController.getEmojis();

        mAdapter = new EmojiAdapter(emojis);
        mRecyclerView.setAdapter(mAdapter);
    }
}
