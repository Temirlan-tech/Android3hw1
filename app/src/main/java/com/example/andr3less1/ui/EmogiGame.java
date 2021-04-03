package com.example.andr3less1.ui;


import com.example.andr3less1.domain.Card;
import com.example.andr3less1.domain.Game;

import java.util.ArrayList;
import java.util.List;

// класс который дает знает игре что будут эмоджи и дает понять другим классам
// с чем они будут работать, то есть конкретика
public class EmogiGame {

    private Game<String> game;

    public EmogiGame() {
        List<String> cards = new ArrayList<>();
        cards.add("\uD83D\uDE00");
        cards.add("\uD83D\uDE06");
        cards.add("\uD83D\uDE1C");
        game = new Game<>(cards);
    }

    // он передает выполнение классу Game
    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }
}
