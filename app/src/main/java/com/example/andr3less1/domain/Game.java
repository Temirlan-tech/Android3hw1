package com.example.andr3less1.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// класс Game это ядро, вся логика работы приложения должны быть прописана в этом классе
// он не должен содержать андройд классов (фрагментов, кнопок, вьюшек и т.д.)
public class Game<Content> {

    // игра содержит какое то кол-во карт, создаем список карт, подключая женерик Content
    private final List<Card<Content>> cards = new ArrayList<>();

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++){
            // 4 карточки так как каждой карте нужна пара, первой паре будем давать четное значение id, второй нечетное
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
            cards.add(new Card<>((i * 2) +1, false, false, contents.get(i)));
        }
        Collections.shuffle(cards); // добавление элементов в разброс
    }

    // метод который выбирает карту (кликабельность), переворачивает карту
    public void choose(Card<Content> card) {
        // если карта лежит лицом вниз, то затем она лицом наверх
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
    }

    // метод который ищет открывшей карте пару
    private void checkPairs(Card<Content> card) {
        for (Card<Content> secondCard : cards){
            if (secondCard.isFaceUp()){
                if (card.getContent() == secondCard.getContent()
                        && card.getId() != secondCard.getId()){
                    cards.remove(card);
                    cards.remove(secondCard);
                    Log.d("TAG", "match" );
                    return;
                } else {
                    card.setFaceUp(!card.isFaceUp());
                    secondCard.setFaceUp(!secondCard.isFaceUp());
                }
            }
        }
    }

    private void remove() { // удаляем по новому списку
        List<Card<Content>> secondListCards = new ArrayList<>(cards);
        for (Card<Content> c : cards){
            if (c.isMatch())
            secondListCards.remove(c);
        }
        cards.clear(); // удаляем в старом cards
        cards.addAll(secondListCards); // добавляем в новый cards
    }

    // метод возврашающий нам карты
    public List<Card<Content>> getCards(){
        return cards;
    }
}
