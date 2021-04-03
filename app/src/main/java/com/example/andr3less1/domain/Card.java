package com.example.andr3less1.domain;

import java.util.Objects;

public class Card<Content> {

    private int id;
    private boolean isMatch;

    // лежит ли карта лицом на вверх
    private boolean isFaceUp;

    // содержание карты стараться создвать объект
    private Content content;

    public Card(int id, boolean isMatch, boolean isFaceUp, Content content) {
        this.id = id;
        this.isMatch = isMatch;
        this.isFaceUp = isFaceUp;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(content, card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
