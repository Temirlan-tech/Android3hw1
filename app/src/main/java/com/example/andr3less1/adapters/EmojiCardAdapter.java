package com.example.andr3less1.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andr3less1.R;
import com.example.andr3less1.domain.Card;
import com.example.andr3less1.ui.EmogiGame;


public class EmojiCardAdapter extends RecyclerView.Adapter<EmojiCardAdapter.EmojiHolder> {

    private final Listener listener;

    public EmojiCardAdapter(Listener listener){
        this.listener = listener;
    }

    private final EmogiGame emogiGame = new EmogiGame();

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cards, parent, false);
        return new EmojiHolder(view);
    }

    @Override
    public int getItemCount() {
        return emogiGame.getCards().size();
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emogiGame.getCards().get(position));
    }

    class EmojiHolder extends RecyclerView.ViewHolder{
        private final TextView tvCard;
        public EmojiHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_cards);
        }

        public void onBind(Card<String> card){
            if (card.isFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }
            tvCard.setOnClickListener(v -> {
                emogiGame.choose(card);
                listener.choose();
            });
        }
    }

    public interface Listener {
        void choose();
    }
}
